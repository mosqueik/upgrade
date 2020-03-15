package ui.pages;

import ui.bean.LoanInfo;
import ui.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.LoadProperties;
import utils.Util;

public class NonDMFunnelPage extends BasePage {

    @FindBy(how = How.NAME, using = "desiredAmount")
    WebElement desiredAmount;

    @FindBy(how = How.CSS, using = "[data-auto='dropLoanPurpose']")
    WebElement dropLoanPurpose;

    @FindBy(how = How.CSS, using = "[data-auto='CheckYourRate']")
    WebElement checkYourRateBtn;

    public NonDMFunnelPage() {
        getDriver().get(getBaseUrl() + LoadProperties.prop.getProperty(Util.NO_DM_FUNNEL_PATH));
        PageFactory.initElements(getDriver(), this);
        waitElement(desiredAmount);
    }

    public void addDesiredAmount(String desAmount){
        desiredAmount.sendKeys(desAmount);
    }

    public void selectLoanPurpose(String loanPurpose){
        Select drop= new Select(dropLoanPurpose);
        switch (loanPurpose){
            case "DEBT_CONSOLIDATION":
                drop.selectByValue("DEBT_CONSOLIDATION");
                break;
            case "SMALL_BUSINESS":
                drop.selectByValue("SMALL_BUSINESS");
                break;
            case "HOME_IMPROVEMENT":
                drop.selectByValue("HOME_IMPROVEMENT");
                break;
            case "LARGE_PURCHASE":
                drop.selectByValue("LARGE_PURCHASE");
                break;
            case "OTHER":
                drop.selectByValue("OTHER");
                break;
            default:
                drop.selectByValue("CREDIT_CARD");
                break;
        }
    }

    public void checkYourRate(LoanInfo loanInfoBean){
        addDesiredAmount(loanInfoBean.getLoanAmount());
        selectLoanPurpose(loanInfoBean.getLoanPurpose());
        checkYourRateBtn.click();
    }

}
