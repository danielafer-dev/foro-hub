package api.hub.domain.course;

public enum Category {
    FULL_STACK("Full_stack"),
    FRONT_END("Front_end"),
    BACK_END("Back_end");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public static Category fromString(String text) {
        for (Category category : Category.values()) {
            if (category.value.equalsIgnoreCase(text)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Category not found: " + text);
    }
}