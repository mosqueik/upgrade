/*
 * Copyright (c) 2015-2018, Episode Six and/or its affiliates. All rights reserved.
 * EPISODE SIX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * Copying is only permitted per the terms of an executed Non-Disclosure Agreement
 * with Episode Six. Use is only permitted for conducting an evaluation of
 * Episode Six APIs as authorized by Episode Six.
 *
 */

package ui.common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static WebdriverConnector webdriverConnector;
    private int timeOutInSeconds = 30;


    public WebDriver getDriver() {
        if (webdriverConnector == null) {
            webdriverConnector = new WebdriverConnector();
        }
        return webdriverConnector.getDriver();
    }

    public String getBaseUrl() {
        if (webdriverConnector == null) {
            webdriverConnector = new WebdriverConnector();
        }
        return webdriverConnector.getBaseUrl();
    }

    public void waitElement(WebElement element) {
        new WebDriverWait(getDriver(), timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitClickableElement(WebElement element) {
        new WebDriverWait(getDriver(), timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUrlContains(String urlString) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.urlContains(urlString));
    }

    public static void quitDriver() {
        webdriverConnector.getBase().quitDriver();
    }
}
