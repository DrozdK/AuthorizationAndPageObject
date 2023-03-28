package enums;

public enum Password {
    SELENIUM_PASSWORD("Axa@Demo");

    private final String password;

    Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
