package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.CommentAreaPage;
import pages.ProfilePage;
import pages.loginPage;


import java.time.Duration;

public class stepDefinitions {
    public WebDriver driver;
    public loginPage login;
    public ProfilePage profile;
    public CommentAreaPage comment;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new loginPage(driver);
        profile = new ProfilePage(driver);
        comment = new CommentAreaPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Given("I on instagram login page")
    public void navigateToLoginPage(){
        driver.get("https://www.instagram.com");

    }

    @When("Enter username, password relevant input box")
    public void EnterUsernameAndPass(){
        login.enterUsername("tonystark7731076727@gmail.com");
        login.enterPassword("7731076727");

    }

    @And("Click on login button")
    public void clickOnLoginButton(){
        Assert.assertTrue(login.isLoginButtonEnabled());
        login.clickLoginButton();
    }

    @Then("Navigated to home page")
    public void navigateToHomePage(){
        login.Waits("https://www.instagram.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/" ,"Not navigated to home page");
        Assert.assertTrue(login.isLogoDisplayed());
    }

    @Given("I on instagram home page")
    public void navigateToHome(){
        navigateToLoginPage();
        login.enterUsername("tonystark7731076727@gmail.com");
        login.enterPassword("7731076727");
        login.clickLoginButton();
        login.Waits("https://www.instagram.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.instagram.com/" ,"Not navigated to home page");
//        Assert.assertTrue(login.isLogoDisplayed());
    }

    @When("Click on profile option on side bar")
    public void clickOnProfileOption(){
        profile.clickProfilePicture();
    }

    @Then("Navigate to profile page")
    public void  navigateToProfile(){
        login.Waits("https://www.instagram.com/sontonystark/?next=%2F");
        Assert.assertEquals(profile.getProfileName(),"Profile");
    }

    @When("Click on add profile picture")
    public void clickOnAddProfilePic(){
        profile.clickAddProfilePhotoButton();
    }

    @And("Select a picture")
    public void selectPic() throws InterruptedException {
        Thread.sleep(15000);
    }

    @Then("Profile picture is uploaded")
    public void validateProfilePic(){
        Assert.assertTrue(profile.getProfilePhotoDisplayed());
    }


    @When("Add comment to the post")
    public void addComment() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(driver.findElement(By.xpath("(//textarea[@placeholder='Add a comment…'])[1]")).isEnabled());
        comment.enterComment("Hello");

        comment.clickOnPostButton();
    }

    @Then("Verify it")
    public void verifyComment(){
        Assert.assertEquals(comment.getCommentText(),"Hello");
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
