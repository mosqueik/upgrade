package ui.pages;

import ui.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.LoadProperties;
import utils.Util;

public class OfferPage extends BasePage {

    @FindBy(how = How.CSS, using = "[data-auto='userLoanAmount']")
    WebElement loanAmount;

    @FindBy(how = How.CSS, using = "[data-auto='defaultMonthlyPayment']")
    WebElement monthlyPay;

    @FindBy(how = How.CSS, using = "[data-auto='defaultLoanTerm']")
    WebElement loanTerm;

    @FindBy(how = How.CSS, using = "[data-auto='defaultLoanInterestRate']")
    WebElement interestRate;

    @FindBy(how = How.CSS, using = "[data-auto='defaultMoreInfoAPR']")
    WebElement apr;

    @FindBy(how = How.XPATH, using = "//div[@class='header-nav']/label[@class='header-nav__toggle']")
    WebElement menu;

    @FindBy(how = How.XPATH, using = "//a[@href='/funnel/logout']")
    WebElement signOut;

    @FindBy(how = How.XPATH, using = "//div[@data-delay='250']")
    WebElement spinner;

    public OfferPage(){
        waitUrlContains(LoadProperties.prop.getProperty(Util.OFFER_PAGE_PATH));
        PageFactory.initElements(getDriver(), this);
        waitClickableElement(loanAmount);
    }

    public String getLoanAmount(){
        return loanAmount.getText();
    }

    public String getMonthlyPayment(){
        return monthlyPay.getText();
    }

    public String getLoanTerm(){
        return loanTerm.getText();
    }

    public String getInterestRate(){
        return interestRate.getText();
    }

    public String getAPR(){
        return apr.getText();
    }

    public void signOut() {
        menu.click();
        waitElement(signOut);
        signOut.click();
    }
}
