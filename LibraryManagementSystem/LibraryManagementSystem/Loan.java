import java.time.LocalDate;

public class Loan {
    private final String itemId;
    private final String memberId;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    public Loan(String itemId, String memberId, LocalDate loanDate, LocalDate dueDate) {
        if (itemId == null || memberId == null || loanDate == null || dueDate == null) {
            throw new IllegalArgumentException("Loan fields cannot be null.");
        }
        this.itemId = itemId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public String getItemId() { return itemId; }
    public String getMemberId() { return memberId; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }

    public boolean isOverdue() {
        return dueDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Loan{itemId='" + itemId + "', memberId='" + memberId
            + "', loanDate=" + loanDate + ", dueDate=" + dueDate + "}";
    }
}
