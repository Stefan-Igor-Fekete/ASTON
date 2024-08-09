package framework.enums;

public enum MtsPaymentCategory {
    COMMUNICATION_SERVICES("Услуги связи");

    private final String menuElementLocator;

    MtsPaymentCategory(String menuElementLocator) {
        this.menuElementLocator = menuElementLocator;
    }

    public String getValue() {
        return menuElementLocator;
    }
}
