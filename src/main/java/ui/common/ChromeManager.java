package ui.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.LoadProperties;
import utils.Util;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class ChromeManager extends DriverManager {

    protected ChromeDriver driver;
    private int screenResolutionWidth;
    private int screenResolutionHeight;

    private void manageWindow (final Consumer<WebDriver.Window> window) {
        window.accept(driver.manage().window());
    }

    @Override
    protected WebDriver createDriver() {
        long delayImplicit = Long.parseLong(LoadProperties.prop.getProperty(Util.DELAY_IMPLICIT));
        long delayPageLoad = Long.parseLong(LoadProperties.prop.getProperty(Util.DELAY_PAGE_LOAD));

        long delayScriptLoad = Long.parseLong(LoadProperties.prop.getProperty(Util.DELAY_SCRIPT_LOAD));
        String screenState = LoadProperties.prop.getProperty(Util.SCREEN_STATE);
        boolean headlessMode = Boolean.parseBoolean(LoadProperties.prop.getProperty(Util.HEADLESS_MODE));
        screenResolutionWidth = Integer.parseInt(LoadProperties.prop.getProperty(Util.SCREEN_RESOLUTION_WIDTH));
        screenResolutionHeight = Integer.parseInt(LoadProperties.prop.getProperty(Util.SCREEN_RESOLUTION_HEIGHT));

        String webDriverRootPath = System.getProperty("user.dir") + "/build/";
        String osName = System.getProperty("os.name").toLowerCase();

        String chromeWebDriverName = "chromedriver";
        if ( osName.contains("win") ) {
            osName = "windows";
            chromeWebDriverName = chromeWebDriverName + ".exe";
        }
        String webDriverPath = webDriverRootPath + "chromedriver/" + osName + "/" + chromeWebDriverName;


        System.setProperty("webdriver.chrome.driver", webDriverPath);

        final ChromeOptions chromeOptions = new ChromeOptions ();
        if (headlessMode) {
            chromeOptions.addArguments ("--headless");
        }
        driver = new ChromeDriver(ChromeDriverService.createDefaultService(), chromeOptions);

        // Times to wait for page load and elements in the page.
        driver.manage().timeouts().implicitlyWait(delayImplicit, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(delayPageLoad, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(delayScriptLoad, TimeUnit.SECONDS);

        switch (screenState) {
            case "FULL_SCREEN":
                manageWindow(WebDriver.Window::fullscreen);
                break;
            case "MAXIMIZED":
                manageWindow(WebDriver.Window::maximize);
                break;
            case "NORMAL":
            default:
                manageWindow(w -> w.setSize(new Dimension(screenResolutionWidth, screenResolutionHeight)));
                break;
        }

        return driver;

    }

    @Override
    public WebDriver getDriver() {
        if (driver == null) {
            this.createDriver();
        }
        return driver;
    }

}
