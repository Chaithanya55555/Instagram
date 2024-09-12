package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommentAreaPage {
    public WebDriver driver;
    WebDriverWait wait;
    Actions act ;
    // Selector properties
    private By comment = By.xpath("(//textarea[@placeholder='Add a comment…'])[1]");
    private By post = By.xpath("//div[contains(text(),'Post')]");
    public CommentAreaPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        act  = new Actions(driver);
    }

    public void enterComment(String comm) {
        WebElement textarea = driver.findElement(comment);
        wait.until(ExpectedConditions.elementToBeClickable(textarea));
//        act.contextClick(textarea);
        textarea = driver.findElement(comment) ;
        wait.until(ExpectedConditions.presenceOfElementLocated(comment));
        textarea.sendKeys(comm);
    }

    public String getCommentText() {
        return driver.findElement(comment).getText();
    }

    public String getPlaceholderText() {
        return driver.findElement(comment).getAttribute("placeholder");
    }
    public void clickOnPostButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(post));
        driver.findElement(post).click();
    }
}
