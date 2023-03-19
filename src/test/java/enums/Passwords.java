package enums;

public enum Passwords {
    SELENIUM_PASSWORD("Axa@Demo");

    private final String password;

    Passwords(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
