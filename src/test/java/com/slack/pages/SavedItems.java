package com.slack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Predicate;


/**
 * SavedItems page object containing login web elements and methods.
 */
@WaitFor(SavedItems.PageLoaded.class)
public class SavedItems {
    WebDriver driver;
    WebDriverWait wait;
    static class PageLoaded implements Predicate<SearchContext> {
        @Override
        public boolean test(SearchContext context) {
            return !context.findElements(By.xpath("//div[@data-qa='channel_name']")).isEmpty();
        }
    }

    public SavedItems(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isMessagePresent(String message){
         return !driver.findElements(By.xpath("//div[text()='"+ message +"']")).isEmpty();
    }
}
