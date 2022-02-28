package com.slack.pages;

import org.openqa.selenium.SearchContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.function.Predicate;

/**
 * @WaitFor annotation applies to a class or a field.
 * Instance of the class/field won't be loaded till supplied Predicate returns true.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface WaitFor {
    Class<? extends Predicate<? super SearchContext>> value();
}
