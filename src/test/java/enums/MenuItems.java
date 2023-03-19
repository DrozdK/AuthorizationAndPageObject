package enums;

public enum MenuItems {
    SUMMARY("Summary"),
    GRID("Grid & chart"),
    HISTOGRAM("Histogram"),
    SCATTER("Scatter-plot"),
    REPORTS("Reports");

    private final String item;

    MenuItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
