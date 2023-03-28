package enums;

    public enum DashboardItem {
        DATA_INTERVAL("Data interval "),
        TOTAL_ORDERS("Total orders"),
        TOTAL_WINNING_ORDERS("Total winning orders "),
        TOTAL_LOSING_ORDERS("Total losing orders ");

        private final String item;

        DashboardItem(String item) {
            this.item = item;
        }

        public String getItem() {
            return item;
        }
    }
