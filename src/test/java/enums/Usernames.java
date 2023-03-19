package enums;

public enum Usernames {
    MAIN_USERNAME("selenium_chrome"),
    WRONG_USERNAME("wrong");

    private final String username;

    Usernames(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
