package framework.base;

public class BasePage {

    private BaseElement baseElement;
    private String name;

    public BasePage() {
    }

    public BasePage(BaseElement baseElement, String name) {
        this.baseElement = baseElement;
        this.name = name;
    }

    public void waitForOpen() {
        baseElement.waitElementDisplayed();
    }

    public boolean isOnPage() {

        return baseElement.isDisplayed();
    }
}