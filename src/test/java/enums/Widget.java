package enums;

public enum Widget {
    ORDERS_GRID("Orders grid"),
    ALGO_PERFORMANCE("Algo Performance"),
    ORDERS_BY_INSTRUMENT_OR_ALGO("Orders by instrument / algo (top 10)"),
    PRICE_BY_INSTRUMENT("Price improvement by instrument / algo (top 10)"),
    PRICE_BY_CURRENCY("Price improvement by currency"),
    ORDERS_BY_ALGO("Orders by algo"),
    ORDERS_BY_INSTRUMENT("Orders by instrument (top 10)"),
    ALGO_PERFORMANCE_TIMELINE("Algo performance timeline (by 3 hours)"),
    ORDERS_BY_ALGO_TIMELINE("Orders by algo timeline (by 3 hours)");

    private final String widget;

    Widget(String widget) {
        this.widget = widget;
    }

    public String getWidget() {
        return widget;
    }
}
