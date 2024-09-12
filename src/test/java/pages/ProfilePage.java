package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private WebDriver driver;

    // Selectors
    private By profileNameSelector = By.xpath("//span[contains(text(),'Profile')]");
    private By profilePictureSelector = By.xpath("//span[@role='link']//img");
    private By addProfilePhotoButton = By.xpath("//button[@title='Add a profile photo']");
    private By profilePhotoPreview = By.xpath("//img[@alt='Add a profile photo']");


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProfileName() {
        return driver.findElement(profileNameSelector).getText();
    }

    public void clickProfilePicture() {
        driver.findElement(profilePictureSelector).click();
    }
    public void clickAddProfilePhotoButton() {
        driver.findElement(addProfilePhotoButton).click();
    }




    public Boolean getProfilePhotoDisplayed() {
        return driver.findElement(profilePhotoPreview).isDisplayed();
    }
}
