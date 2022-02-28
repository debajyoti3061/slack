package com.slack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Predicate;

/**
 * LoginPage page object containing login web elements and methods.
 */
@WaitFor(LoginPage.PageLoaded.class)
public class LoginPage {

    WebDriver driver;

    static class PageLoaded implements Predicate<SearchContext> {
        public boolean test(SearchContext context) {
            return !context.findElements(By.xpath("//input[@data-qa='login_email']")).isEmpty();
        }

    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@data-qa='login_email']")
    WebElement loginTextbox;
    @FindBy(xpath = "//input[@data-qa='login_password']")
    WebElement passwordTextbox;
    @FindBy(xpath = "//button[@data-qa='signin_button']")
    WebElement signInButton;

    public ChannelPage doLogin(String email, String password) {
        loginTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(driver, ChannelPage.class);
    }


}
