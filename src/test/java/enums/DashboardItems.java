package enums;

    public enum DashboardItems {
        DATA_INTERVAL("Data interval "),
        TOTAL_ORDERS("Total orders"),
        TOTAL_WINNING_ORDERS("Total winning orders "),
        TOTAL_LOSING_ORDERS("Total losing orders ");

        private final String item;

        DashboardItems(String item) {
            this.item = item;
        }

        public String getItem() {
            return item;
        }
    }
