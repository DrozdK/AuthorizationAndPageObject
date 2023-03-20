package enums;

public enum MenuItems {
    GRID("Grid & chart"),
    HISTOGRAM("Histogram"),
    SCATTER("Scatter-plot");

    private final String item;

    MenuItems(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
