package com.slack.tests;

import com.slack.pages.LoginPage;
import com.slack.pages.NavBar;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


/**
 * BaseTestCase  containing set up, teardown and reused methods.
 */
public class BaseTestCase {

    WebDriver driver;

    @Before
    public void setup(){
        // Need to be configured per os/browser. This is hard coded for windows and chrome 98.
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    protected LoginPage goToLoginPage(){
        driver.get("https://slack-automation-co.slack.com");
        return PageFactory.initElements(driver,LoginPage.class);
    }

    protected NavBar gotoNavBar(){
        return PageFactory.initElements(driver,NavBar.class);
    }

    @After
    public void quit(){
        driver.quit();
    }

}
