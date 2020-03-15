package ui.common;

import org.openqa.selenium.WebDriver;

public class WebdriverConnector {

    Base base;

    protected Base getBase() {
        if (base == null)
            base = new Base();
        return base;
    }

    public WebDriver getDriver() {
        try {
            return getBase().getDriver();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getBaseUrl() {
        return getBase().getBaseUrl();
    }

}
