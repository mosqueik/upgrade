import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ui.bean.LoanInfo;
import ui.bean.PersonalInfo;
import ui.common.BasePage;
import ui.pages.LoginPage;
import ui.pages.NonDMFunnelPage;
import ui.pages.OfferPage;
import ui.pages.PersonalInfoPage;
import utils.LoadProperties;
import utils.Util;


public class WebChallengeTest {

    private LoanInfo loanInfo;
    private PersonalInfo personalInfo;
    private String defaultEmail = "mariano" + RandomStringUtils.randomNumeric(3) + "@upgrade-challenge.com";

    @BeforeTest
    public void setup() {
        loanInfo = new LoanInfo();
        personalInfo = new PersonalInfo();
        personalInfo.setEmail(defaultEmail);
    }

    @AfterTest
    public void tearDown() {
        LoadProperties.prop = null;
        BasePage.quitDriver();
    }

    @Test
    public void registerUser() {
        NonDMFunnelPage nonDMFunnelPage = new NonDMFunnelPage();
        nonDMFunnelPage.checkYourRate(loanInfo);

        PersonalInfoPage personalInfoPage = new PersonalInfoPage(loanInfo.getLoanPurpose(), loanInfo.getLoanAmount());
        personalInfo.setPassword(Util.generateRandomPassword());
        personalInfoPage.fillPersonalInformation(personalInfo);

        OfferPage offerPage = new OfferPage();

        String amount = offerPage.getLoanAmount();
        String monthlyPayment = offerPage.getMonthlyPayment();
        String loanTerm = offerPage.getLoanTerm();
        String interestRate = offerPage.getInterestRate();
        String apr = offerPage.getAPR();

        offerPage.signOut();

        LoginPage loginPage = new LoginPage();
        loginPage.signIn(personalInfo);

        OfferPage offerPageLogged = new OfferPage();

        Assert.assertEquals(amount, offerPageLogged.getLoanAmount());
        Assert.assertEquals(monthlyPayment, offerPageLogged.getMonthlyPayment());
        Assert.assertEquals(loanTerm, offerPageLogged.getLoanTerm());
        Assert.assertEquals(interestRate, offerPageLogged.getInterestRate());
        Assert.assertEquals(apr, offerPageLogged.getAPR());
    }

}
