package ui.common;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import utils.LoadProperties;
import utils.Util;

public class Base {

    private WebDriver driver;
    private DriverManager driverManager = new ChromeManager();
    private String baseUrl;

    public Base() {

    }

    public WebDriver getDriver() throws Exception{
        if ( LoadProperties.prop == null ) {
            String propertiesFilename = "cfg.ui.properties";
            LoadProperties.loadProperties(propertiesFilename);

            if (LoadProperties.prop == null)
                throw new Exception("Properties not set");

            baseUrl = LoadProperties.prop.getProperty(Util.BASE_URL);
        }

        if ( driver == null ) {
            System.out.println(LoadProperties.prop);
            System.out.println(LoadProperties.prop.getProperty(Util.WEBDRIVER));
            switch(LoadProperties.prop.getProperty(Util.WEBDRIVER)) {
                case "FIREFOX":
                    // Won't use it but I left this here to show that can be done. Need to create a FirefoxManager class to create the webdriver.
                    // driverManager = new FirefoxManager();
                    break;
                default:
                    driverManager = new ChromeManager();
                    break;
            }
            driver = driverManager.createDriver();

        }

        try {
            driver.getTitle();
        }catch(NoSuchSessionException e){
            // No session for the driver, we need to instantiate another.
            driver = driverManager.createDriver();
        }

        return driver;
    }

    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    public void quitDriver(){
        if ( driver != null ) {
            driver.quit();
            driver = null;
        }
    }

    public String getBaseUrl(){
        return baseUrl;
    }
}
