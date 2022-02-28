package com.slack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.function.Predicate;


/**
 * NavBar page object containing login web elements and methods.
 */
@WaitFor(NavBar.PageLoaded.class)
public class NavBar {
    WebDriver driver;
    static class PageLoaded implements Predicate<SearchContext> {
        @Override
        public boolean test(SearchContext context) {
            return !context.findElements(By.xpath("//button[@data-qa='top_nav_search']")).isEmpty();
        }
    }

    public NavBar(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResults searchText(String message) {
        driver.findElement(By.className("p-top_nav__search__text")).click();
        driver.findElement(By.xpath("//div[@data-qa='focusable_search_input']/div")).sendKeys(message);
        driver.findElement(By.xpath("//div[@data-qa='focusable_search_input']/div")).sendKeys(Keys.ENTER);
        return PageFactory.initElements(driver, SearchResults.class);
    }
}
