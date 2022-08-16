package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GmailAccountPage extends BasePage{
    public GmailAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Написать']")
    private WebElement writeButton;

    @FindBy(xpath = "//span/preceding-sibling::input")
    private WebElement toField;

    @FindBy(xpath = "//input[@aria-label='Тема']")
    private WebElement themeField;

    @FindBy(xpath = "//div[@aria-label='Текст письма']")
    private WebElement text;

    @FindBy(xpath = "//div[text()='Отправить']")
    private WebElement sendButton;

    @FindBy(xpath = "//a[@aria-label='Отправленные']")
    private WebElement sended;

    @FindBy(css = "[email='l1ndoke@protonmail.com']")
    List <WebElement> toName;

    public void clickWriteButton(){
        writeButton.click();
    }

    public void typeReceiverOfEmail(String keyword){
        toField.sendKeys(keyword);
    }

    public void typeThemeOfLetter(String theme){
        themeField.sendKeys(theme);
    }

    public void typeMessageOfTheLetter(String message){
        text.sendKeys(message);
    }

    public void clickSendButton(){
        sendButton.click();
    }

    public void clickSentMessagesButton(){
        sended.click();
    }

    public boolean didLetterSendToSpecificReceiver(){
        return !toName.isEmpty();
    }
}


