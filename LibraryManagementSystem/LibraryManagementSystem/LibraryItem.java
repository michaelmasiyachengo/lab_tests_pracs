import java.time.LocalDate;

public abstract class LibraryItem implements Borrowable {
    private final String id;
    private final String title;
    private Member currentMember;
    private LocalDate loanDate;
    private LocalDate dueDate;

    protected LibraryItem(String id, String title) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Item ID cannot be empty.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.id = id.trim();
        this.title = title.trim();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public abstract int loanPeriodDays();

    public boolean isAvailable() { return currentMember == null; }
    public Member getCurrentMember() { return currentMember; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }

    @Override
    public void borrow(Member member)
            throws ItemNotAvailableException, MemberLimitExceededException {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null.");
        }
        if (!isAvailable()) {
            throw new ItemNotAvailableException("Item '" + title + "' is already on loan.");
        }
        // Add to the member first; if the limit is exceeded, the item stays available.
        member.addActiveItem(id);
        currentMember = member;
        loanDate = LocalDate.now();
        dueDate = loanDate.plusDays(loanPeriodDays());
    }

    @Override
    public void giveBack() throws ItemNotAvailableException {
        if (isAvailable()) {
            throw new ItemNotAvailableException("Item '" + title + "' is not currently on loan.");
        }
        currentMember.removeActiveItem(id);
        currentMember = null;
        loanDate = null;
        dueDate = null;
    }

    void restoreLoan(Member member, LocalDate borrowedOn, LocalDate dueOn)
            throws MemberLimitExceededException {
        if (member == null || borrowedOn == null || dueOn == null) {
            throw new IllegalArgumentException("Invalid saved loan data.");
        }
        member.addActiveItem(id);
        currentMember = member;
        loanDate = borrowedOn;
        dueDate = dueOn;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id='" + id + "', title='" + title
            + "', loanDays=" + loanPeriodDays()
            + ", available=" + isAvailable()
            + (isAvailable() ? "" : ", due=" + dueDate) + "}";
    }
}
