import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library(Path.of("data"));

    public static void main(String[] args) {
        try {
            library.load();
            System.out.println("Library Management System");
            boolean running = true;

            while (running) {
                showMenu();
                String choice = readLine("Choose an option: ");

                try {
                    switch (choice) {
                        case "1": addItem(); break;
                        case "2": registerMember(); break;
                        case "3": borrowItem(); break;
                        case "4": returnItem(); break;
                        case "5": listOverdue(); break;
                        case "6": searchByTitle(); break;
                        case "7": listItems(); break;
                        case "8": listMembers(); break;
                        case "0":
                            library.save();
                            running = false;
                            System.out.println("Data saved. Goodbye!");
                            break;
                        default:
                            System.out.println("Please choose a listed option.");
                    }
                } catch (ItemNotAvailableException | MemberLimitExceededException
                         | IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Could not load/save data: " + ex.getMessage());
        }
    }

    private static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add item (Book/DVD)");
        System.out.println("2. Register member");
        System.out.println("3. Borrow item");
        System.out.println("4. Return item");
        System.out.println("5. List overdue items");
        System.out.println("6. Search by title");
        System.out.println("7. List all items");
        System.out.println("8. List all members");
        System.out.println("0. Save and exit");
    }

    private static void addItem() {
        String type = readLine("Type (B for Book, D for DVD): ").trim().toUpperCase();
        String id = readLine("Item ID: ");
        String title = readLine("Title: ");
        LibraryItem item;
        if ("B".equals(type)) item = new Book(id, title);
        else if ("D".equals(type)) item = new Dvd(id, title);
        else {
            System.out.println("Unknown item type.");
            return;
        }
        library.addItem(item);
        System.out.println("Added: " + item);
    }

    private static void registerMember() {
        String id = readLine("Member ID: ");
        String name = readLine("Member name: ");
        Member member = new Member(id, name);
        library.registerMember(member);
        System.out.println("Registered: " + member);
    }

    private static void borrowItem()
            throws ItemNotAvailableException, MemberLimitExceededException {
        String itemId = readLine("Item ID: ");
        String memberId = readLine("Member ID: ");
        library.borrowItem(itemId, memberId);
        System.out.println("Borrow successful.");
    }

    private static void returnItem() throws ItemNotAvailableException {
        String itemId = readLine("Item ID to return: ");
        library.returnItem(itemId);
        System.out.println("Return successful.");
    }

    private static void listOverdue() {
        List<Loan> overdue = library.overdueLoans();
        if (overdue.isEmpty()) {
            System.out.println("No overdue items.");
            return;
        }
        overdue.forEach(loan -> {
            LibraryItem item = library.findItem(loan.getItemId()).orElse(null);
            Member member = library.findMember(loan.getMemberId()).orElse(null);
            System.out.println(loan + " | title="
                + (item == null ? "Unknown" : item.getTitle())
                + " | member=" + (member == null ? "Unknown" : member.getName()));
        });
    }

    private static void searchByTitle() {
        String query = readLine("Enter title or part of title: ");
        List<LibraryItem> matches = library.searchByTitle(query);
        if (matches.isEmpty()) {
            System.out.println("No matching items.");
        } else {
            matches.forEach(System.out::println);
        }
    }

    private static void listItems() {
        if (library.getItems().isEmpty()) {
            System.out.println("No items registered.");
        } else {
            library.getItems().values().forEach(System.out::println);
        }
    }

    private static void listMembers() {
        if (library.getMembers().isEmpty()) {
            System.out.println("No members registered.");
        } else {
            library.getMembers().values().forEach(System.out::println);
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
