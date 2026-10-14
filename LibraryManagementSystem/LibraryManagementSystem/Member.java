import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Member {
    public static final int MAX_LOANS = 3;

    private final String id;
    private final String name;
    private final Set<String> activeItemIds = new LinkedHashSet<>();

    public Member(String id, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty.");
        }
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getActiveLoanCount() { return activeItemIds.size(); }
    public Set<String> getActiveItemIds() {
        return Collections.unmodifiableSet(new LinkedHashSet<>(activeItemIds));
    }

    void addActiveItem(String itemId) throws MemberLimitExceededException {
        if (activeItemIds.size() >= MAX_LOANS) {
            throw new MemberLimitExceededException(
                "Member " + name + " already has the maximum of " + MAX_LOANS + " active loans."
            );
        }
        activeItemIds.add(itemId);
    }

    void removeActiveItem(String itemId) {
        activeItemIds.remove(itemId);
    }

    @Override
    public String toString() {
        return "Member{id='" + id + "', name='" + name
            + "', activeLoans=" + activeItemIds.size() + "}";
    }
}
