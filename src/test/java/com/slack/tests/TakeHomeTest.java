package com.slack.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Slack's take home test to
 *  1. Login & send message
 *  2. Save the message
 *  3. Search in the saved messages
 *  4. Search in Nav bar & verify search results
 */
public class TakeHomeTest extends BaseTestCase {
    @Test
    public void test1() {
        String generatedMessage = RandomStringUtils.randomAlphabetic(5);

        Assert.assertTrue(
                goToLoginPage().
                        doLogin(/* email= */"debajyoti.3061@gmail.com", /* password= */"Test123$$").
                        sendMessage(generatedMessage).
                        addToSavedMessage(generatedMessage).
                        viewSavedMessages().
                        isMessagePresent(generatedMessage));

        Assert.assertTrue(
                gotoNavBar().
                        searchText(/* message= */"has:star").isTextPresent(generatedMessage));
    }
}
