package enums;

public enum Colors {
    RED_COLOR("rgba(239, 79, 78, 1)"),
    GRAY_COLOR("rgba(108, 117, 125, 1)"),
    GREEN_COLOR("rgba(23, 169, 142, 1)");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
