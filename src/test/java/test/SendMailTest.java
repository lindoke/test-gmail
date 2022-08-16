package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMailTest extends BaseTest{

    public static final String GMAIL_USERNAME = "testaccepam123";
    public static final String GMAIL_PASSWORD = "111abrakadabra111";
    public static final String RECEIVER = "l1ndoke@protonmail.com";
    public static final String THEME = "Greetings!";
    public static final String MESSAGE = "Hello, my friend!";

    @Test
    public void testSendMail() throws InterruptedException {
        getLogInGmailPage().clickLogInButton();
        getLogInGmailPage().implicitWait(10);
        getLogInGmailPage().enterEmail(GMAIL_USERNAME);
        getLogInGmailPage().clickNextButton();
        getLogInGmailPage().pageLoadTimeout(15);
        getLogInGmailPage().enterPassword(GMAIL_PASSWORD);
        Thread.sleep(1000);
        getLogInGmailPage().clickNextButton();
        getLogInGmailPage().pageLoadTimeout(15);
        getGmailAccountPage().clickWriteButton();
        Thread.sleep(3000);
        getGmailAccountPage().typeReceiverOfEmail(RECEIVER);
        getGmailAccountPage().typeThemeOfLetter(THEME);
        getGmailAccountPage().typeMessageOfTheLetter(MESSAGE);
        getGmailAccountPage().clickSendButton();
        getLogInGmailPage().implicitWait(40);
        getGmailAccountPage().clickSentMessagesButton();
        getLogInGmailPage().implicitWait(40);
        Assert.assertTrue(getGmailAccountPage().didLetterSendToSpecificReceiver());
    }
}
