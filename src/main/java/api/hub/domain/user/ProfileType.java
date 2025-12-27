package api.hub.domain.user;

public enum ProfileType {
    ADMIN("Administrator"),
    MODERATOR("Moderator"),
    USER("User");

    private final String displayName;

    ProfileType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}