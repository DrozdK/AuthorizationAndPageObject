package enums;

public enum MenuItem {
    GRID("Grid & chart"),
    HISTOGRAM("Histogram"),
    SCATTER("Scatter-plot");

    private final String item;

    MenuItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
