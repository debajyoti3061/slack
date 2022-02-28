package com.slack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.function.Predicate;


/**
 * SearchResults page object containing login web elements and methods.
 */
@WaitFor(SearchResults.PageLoaded.class)
public class SearchResults {
    WebDriver driver;

    static class PageLoaded implements Predicate<SearchContext> {
        public boolean test(SearchContext context) {
            return !context.findElements(By.xpath("//span[contains(text(),'Search results for')]")).isEmpty();
        }
    }

    public SearchResults(WebDriver driver){
        this.driver = driver;
    }

    public boolean isTextPresent(String message){
        return !driver.findElements(By.xpath("//div[text()='"+ message +"']")).isEmpty();
    }
}
