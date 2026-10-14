import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Library {
    private final Map<String, LibraryItem> items = new LinkedHashMap<>();
    private final Map<String, Member> members = new LinkedHashMap<>();
    private final Map<String, Loan> loans = new LinkedHashMap<>();
    private final Path dataDir;

    public Library(Path dataDir) {
        this.dataDir = dataDir;
    }

    public Map<String, LibraryItem> getItems() {
        return java.util.Collections.unmodifiableMap(new LinkedHashMap<>(items));
    }

    public Map<String, Member> getMembers() {
        return java.util.Collections.unmodifiableMap(new LinkedHashMap<>(members));
    }

    public void addItem(LibraryItem item) {
        if (items.containsKey(item.getId())) {
            throw new IllegalArgumentException("An item with that ID already exists.");
        }
        items.put(item.getId(), item);
    }

    public void registerMember(Member member) {
        if (members.containsKey(member.getId())) {
            throw new IllegalArgumentException("A member with that ID already exists.");
        }
        members.put(member.getId(), member);
    }

    public void borrowItem(String itemId, String memberId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        LibraryItem item = requireItem(itemId);
        Member member = requireMember(memberId);
        item.borrow(member);
        loans.put(itemId, new Loan(itemId, memberId, item.getLoanDate(), item.getDueDate()));
    }

    public void returnItem(String itemId) throws ItemNotAvailableException {
        LibraryItem item = requireItem(itemId);
        item.giveBack();
        loans.remove(itemId);
    }

    public List<Loan> overdueLoans() {
        return loans.values().stream()
            .filter(Loan::isOverdue)
            .sorted(Comparator.comparing(Loan::getDueDate))
            .collect(Collectors.toList());
    }

    public List<LibraryItem> searchByTitle(String query) {
        String q = query == null ? "" : query.trim().toLowerCase();
        return items.values().stream()
            .filter(item -> item.getTitle().toLowerCase().contains(q))
            .sorted(Comparator.comparing(LibraryItem::getTitle))
            .collect(Collectors.toList());
    }

    public Optional<LibraryItem> findItem(String id) {
        return Optional.ofNullable(items.get(id));
    }

    public Optional<Member> findMember(String id) {
        return Optional.ofNullable(members.get(id));
    }

    private LibraryItem requireItem(String id) {
        LibraryItem item = items.get(id);
        if (item == null) throw new IllegalArgumentException("No item found with ID: " + id);
        return item;
    }

    private Member requireMember(String id) {
        Member member = members.get(id);
        if (member == null) throw new IllegalArgumentException("No member found with ID: " + id);
        return member;
    }

    public void save() throws IOException {
        Files.createDirectories(dataDir);

        List<String> itemLines = new ArrayList<>();
        itemLines.add("type,id,title");
        for (LibraryItem item : items.values()) {
            String type = item instanceof Book ? "BOOK" : "DVD";
            itemLines.add(CsvUtil.row(type, item.getId(), item.getTitle()));
        }
        Files.write(dataDir.resolve("items.csv"), itemLines);

        List<String> memberLines = new ArrayList<>();
        memberLines.add("id,name");
        for (Member member : members.values()) {
            memberLines.add(CsvUtil.row(member.getId(), member.getName()));
        }
        Files.write(dataDir.resolve("members.csv"), memberLines);

        List<String> loanLines = new ArrayList<>();
        loanLines.add("itemId,memberId,loanDate,dueDate");
        for (Loan loan : loans.values()) {
            loanLines.add(CsvUtil.row(
                loan.getItemId(), loan.getMemberId(),
                loan.getLoanDate().toString(), loan.getDueDate().toString()
            ));
        }
        Files.write(dataDir.resolve("loans.csv"), loanLines);
    }

    public void load() throws IOException {
        Files.createDirectories(dataDir);
        items.clear();
        members.clear();
        loans.clear();

        Path itemFile = dataDir.resolve("items.csv");
        if (Files.exists(itemFile)) {
            List<String> lines = Files.readAllLines(itemFile);
            for (int i = 1; i < lines.size(); i++) {
                List<String> f = CsvUtil.parse(lines.get(i));
                if (f.size() < 3) continue;
                LibraryItem item = "BOOK".equalsIgnoreCase(f.get(0))
                    ? new Book(f.get(1), f.get(2))
                    : new Dvd(f.get(1), f.get(2));
                items.put(item.getId(), item);
            }
        }

        Path memberFile = dataDir.resolve("members.csv");
        if (Files.exists(memberFile)) {
            List<String> lines = Files.readAllLines(memberFile);
            for (int i = 1; i < lines.size(); i++) {
                List<String> f = CsvUtil.parse(lines.get(i));
                if (f.size() < 2) continue;
                Member member = new Member(f.get(0), f.get(1));
                members.put(member.getId(), member);
            }
        }

        Path loanFile = dataDir.resolve("loans.csv");
        if (Files.exists(loanFile)) {
            List<String> lines = Files.readAllLines(loanFile);
            for (int i = 1; i < lines.size(); i++) {
                List<String> f = CsvUtil.parse(lines.get(i));
                if (f.size() < 4) continue;
                String itemId = f.get(0);
                String memberId = f.get(1);
                LibraryItem item = items.get(itemId);
                Member member = members.get(memberId);
                if (item == null || member == null) continue;

                LocalDate loanDate = LocalDate.parse(f.get(2));
                LocalDate dueDate = LocalDate.parse(f.get(3));
                try {
                    item.restoreLoan(member, loanDate, dueDate);
                    loans.put(itemId, new Loan(itemId, memberId, loanDate, dueDate));
                } catch (MemberLimitExceededException ex) {
                    System.err.println("Skipped saved loan for item " + itemId + ": " + ex.getMessage());
                }
            }
        }
    }
}
