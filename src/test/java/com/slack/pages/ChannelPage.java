package com.slack.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Predicate;


/**
 * ChannelPage page object containing login web elements and methods.
 */
@WaitFor(ChannelPage.PageLoaded.class)
public class ChannelPage {
    WebDriver driver;
    WebDriverWait wait;
    static class PageLoaded implements Predicate<SearchContext> {
        @Override
        public boolean test(SearchContext context) {
            return !context.findElements(By.xpath("//button[@data-qa='team-menu-trigger']")).isEmpty();
        }
    }
    public ChannelPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "//div[@data-qa='message_input']/div/p")
    WebElement messageTextbox;
    @FindBy(xpath = "//span[@data-qa='channel_sidebar_name_page_psaved']")
    WebElement savedItemsLink;

    public ChannelPage sendMessage(String message){
        messageTextbox.sendKeys(message);
        messageTextbox.sendKeys(Keys.ENTER);
        return this;
    }

    public ChannelPage addToSavedMessage(String message)  {
        Actions action = new Actions(driver);
        WebElement sentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+message+"']")));

        action.moveToElement(sentMessage);
        action.build().perform();
        /*
        old code
        driver.findElement(By.xpath("//button[@data-qa='more_message_actions']")).click();
        driver.findElement(By.xpath("//div[text()= 'Add to saved items']")).click();
        */
        driver.findElement(By.xpath("//button[@aria-label='Add to saved items']")).click();
        return this;
    }

    public SavedItems viewSavedMessages(){
        savedItemsLink.click();
        return PageFactory.initElements(driver, SavedItems.class);
    }
}
