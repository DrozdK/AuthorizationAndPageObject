package enums;

public enum Username {
    MAIN_USERNAME("selenium_chrome"),
    WRONG_USERNAME("wrong");

    private final String username;

    Username(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
