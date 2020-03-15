package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    // API properties values
    public static String BASE_URL = "env.baseUrl";
    public static String LOGIN_PATH = "env.loginPath";
    public static String DEFAULT_USERNAME = "env.username";
    public static String DEFAULT_PASSWORD = "env.password";

    // UI properties# Implicit waits in seconds.
    public static String WEBDRIVER = "webdriver";
    public static String DELAY_IMPLICIT = "delayImplicit";
    public static String DELAY_PAGE_LOAD = "delayPageLoad";
    public static String DELAY_SCRIPT_LOAD = "delayScriptLoad";
    public static String SCREEN_STATE = "screenState";
    public static String HEADLESS_MODE = "headlessMode";
    public static String SCREEN_RESOLUTION_WIDTH = "screenResolutionWidth";
    public static String SCREEN_RESOLUTION_HEIGHT = "screenResolutionHeight";
    public static String NO_DM_FUNNEL_PATH = "env.nonDmFunnelPath";
    public static String OFFER_PAGE_PATH = "env.offerPagePath";
    public static String PERSONAL_INFO_PATH = "env.personalInfoPath";

    public static String generateRandomPassword() {
        String upperCaseLetters = RandomStringUtils.random(2, 65, 90, true, true);
        String lowerCaseLetters = RandomStringUtils.random(2, 97, 122, true, true);
        String numbers = RandomStringUtils.randomNumeric(2);
        String specialChar = RandomStringUtils.random(2, 33, 47, false, false);
        String totalChars = RandomStringUtils.randomAlphanumeric(2);
        String combinedChars = upperCaseLetters.concat(lowerCaseLetters)
                .concat(numbers)
                .concat(specialChar)
                .concat(totalChars);
        List<Character> pwdChars = combinedChars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(pwdChars);
        String password = pwdChars.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return password;
    }
}
