package framework.enums;

public enum MtsPaymentCategory {
    COMMUNICATION_SERVICES("Услуги связи"),
    HOME_INTERNET("Домашний интренет"),
    CREDIT("Рассрочка"),
    DEBT("Задолженность");

    private final String menuElementLocator;

    MtsPaymentCategory(String menuElementLocator) {
        this.menuElementLocator = menuElementLocator;
    }

    public String getValue() {
        return menuElementLocator;
    }
}
