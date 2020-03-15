package ui.pages;

import ui.bean.PersonalInfo;
import ui.common.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.LoadProperties;
import utils.Util;

public class PersonalInfoPage extends BasePage {

    @FindBy(how = How.NAME, using = "borrowerFirstName")
    WebElement firstName;

    @FindBy(how = How.NAME, using = "borrowerLastName")
    WebElement lastName;

    @FindBy(how = How.NAME, using = "borrowerStreet")
    WebElement street;

    @FindBy(how = How.CSS, using = "[class='geosuggest__item__matched-text']")
    WebElement streetOption;

    @FindBy(how = How.NAME, using = "borrowerCity")
    WebElement city;

    @FindBy(how = How.NAME, using = "borrowerState")
    WebElement state;

    @FindBy(how = How.NAME, using = "borrowerZipCode")
    WebElement zipCode;

    @FindBy(how = How.NAME, using = "borrowerDateOfBirth")
    WebElement dob;

    @FindBy(how = How.NAME, using = "borrowerIncome")
    WebElement income;

    @FindBy(how = How.NAME, using = "borrowerAdditionalIncome")
    WebElement additionalIncome;

    @FindBy(how = How.NAME, using = "username")
    WebElement username;

    @FindBy(how = How.NAME, using = "password")
    WebElement password;

    @FindBy(how = How.CSS, using = "[data-auto='continuePersonalInfo']")
    WebElement continueBtn;

    @FindBy(how = How.XPATH, using = "//input[@name='agreements']/following-sibling::div[1]")
    WebElement agreements;

    @FindBy(how = How.CSS, using = "[data-auto='submitPersonalInfo']")
    WebElement submitBtn;

    public PersonalInfoPage(String purpose, String amount){
        getDriver().get(getBaseUrl() + LoadProperties.prop.getProperty(Util.PERSONAL_INFO_PATH) + "/" + purpose + "/" + amount + "?step=contact");
        PageFactory.initElements(getDriver(), this);
        waitElement(continueBtn);
    }

    public void setFirstName(String fname){
        firstName.sendKeys(fname);
    }

    public void setLastName(String lname){
        lastName.sendKeys(lname);
    }

    public void setStreet(String street) {
        this.street.sendKeys(street);
        waitElement(streetOption);
        streetOption.click();
    }

    public void setCity(String city){
        this.city.sendKeys(city);
    }

    public void setState(String state){
        this.state.sendKeys(state);
    }

    public void setZipCode(String zipCode){
        this.zipCode.sendKeys(zipCode);
    }

    public void setIncome(String income){
        this.income.sendKeys(income);
        continueBtn.click();
    }

    public void setAdditionalIncome(String addIncome){
        additionalIncome.sendKeys(addIncome);
        continueBtn.click();
    }

    public void setUsername(String emailAccount){
        username.sendKeys(emailAccount);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void acceptAgreements(){
        agreements.click();
    }

    public void setDOB(String dob){
        this.dob.sendKeys(dob); }

    public void submitPI(){
        submitBtn.click();
    }

    public void fillPersonalInformation(PersonalInfo personalInfoBean) {
        setFirstName(personalInfoBean.getFname());
        setLastName(personalInfoBean.getLname());
        setStreet(personalInfoBean.getStreet());
        setDOB(personalInfoBean.getDobMonth() + personalInfoBean.getDobDay() + personalInfoBean.getDobYear());
        continueBtn.click();

        setIncome(personalInfoBean.getIncome());
        setAdditionalIncome(personalInfoBean.getAdditionalIncome());
        waitElement(continueBtn);
        continueBtn.click();

        setUsername(personalInfoBean.getEmail());
        setPassword(personalInfoBean.getPassword());
        acceptAgreements();
        submitPI();
    }

}
