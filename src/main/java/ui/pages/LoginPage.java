package ui.pages;

import ui.bean.PersonalInfo;
import ui.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.LoadProperties;
import utils.Util;

public class LoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "[data-auto='username']")
    WebElement email;

    @FindBy(how = How.CSS, using = "[data-auto='password']")
    WebElement password;

    @FindBy(how = How.CSS, using = "[data-auto='login']")
    WebElement signInButton;

    public LoginPage() {
        getDriver().get(getBaseUrl() + LoadProperties.prop.getProperty(Util.LOGIN_PATH));
        PageFactory.initElements(getDriver(), this);
        waitElement(signInButton);
    }

    private void setEmail(String email){
        this.email.sendKeys(email);
    }

    private void setPass(String password){
        this.password.sendKeys(password);
    }

    private void clickSigIn(){
        signInButton.click();
    }

    public void signIn(PersonalInfo personalInfoBean){
        setEmail(personalInfoBean.getEmail());
        setPass(personalInfoBean.getPassword());
        clickSigIn();
    }
}
