import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.LoadProperties;
import utils.Util;
import api.dto.LoansInReview;
import api.dto.LoginV2;
import api.dto.RequestPayload;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class APIChallengeTest {
    private static String baseUrl = null;
    private static String loginPath = null;

    @BeforeClass
    public static void setup(){
        String propertiesFilename = "cfg.api.properties";
        LoadProperties.loadProperties(propertiesFilename);
        Assert.assertNotNull(LoadProperties.prop, "Configuration file not properly loaded");

        baseUrl = LoadProperties.prop.getProperty(Util.BASE_URL);
        loginPath = LoadProperties.prop.getProperty(Util.LOGIN_PATH);

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl)
                .addHeader("x-cf-source-id", "coding-challenge")
                .addHeader("x-cf-corr-id", UUID.randomUUID().toString())
                .addFilter(new ResponseLoggingFilter())//log request and response for better debugging. You can also only log if a requests fails.
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    private RequestPayload generateDummyPayload(boolean random) {
        String pass = LoadProperties.prop.getProperty(Util.DEFAULT_PASSWORD);
        String username = LoadProperties.prop.getProperty(Util.DEFAULT_USERNAME);
        if ( random ) {
            pass = Util.generateRandomPassword();
            username = "RANDOM_USERNAME";
        }

        return new RequestPayload()
                .setPassword(pass)
                .setUsername(username);
    }

    @AfterClass
    public void tearDown() {
        LoadProperties.prop = null;
    }

    @Test
    public void createUserByLogin(){
        RequestPayload requestPayloadDTO = generateDummyPayload(false);

        LoginV2 retrievedLogin = given()
                .spec(RestAssured.requestSpecification)
                .when()
                .body(requestPayloadDTO)
                .post(loginPath)
                .then()
                .statusCode(200)
                .extract().as(LoginV2.class);

        // Check that the borrower has at least one loan in review.
        Assert.assertTrue(retrievedLogin.getLoansInReview().size() > 0, "Borrower doesn't have a loan in review");

        for (LoansInReview loansInReview : retrievedLogin.getLoansInReview()) {
            Assert.assertTrue(loansInReview.getProductType() != null, "Loan in review doesn't have the Product type");
            Assert.assertTrue(loansInReview.getProductType().equals(LoansInReview.PERSONAL_LOAN_TYPE), "Loan in review type is not: " + LoansInReview.PERSONAL_LOAN_TYPE);
        }
    }

    @Test
    public void createUserByLoginNegative(){
        RequestPayload requestPayloadDTO = generateDummyPayload(true);
        given()
                .spec(RestAssured.requestSpecification)
                .when()
                .body(requestPayloadDTO)
                .post(loginPath)
                .then()
                .statusCode(401);
    }

}
