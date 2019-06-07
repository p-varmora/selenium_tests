import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class GoogleHomePage {

    /*
       1.open the google web app
       2.miximize the window
       3.verify page title "Google"
       4.verify google search button is present
       5.verify google feeling button is present
       6.verify google sign-in button is present
       7.type "you rock!" in google search box
       8.verify "you rock!" in google search box
       9.collects all urls after typing "you rock!"
       10.close the google web app

     */



    @Test
    public void googleHomePageTest() {


        WebDriver driver = new FirefoxDriver();

        //open google app
        driver.get("https://www.google.com");

        //maximize the window
        driver.manage().window().maximize();

        //verify page title
        Assert.assertEquals(driver.getTitle(), "Google");

        //check google search button is present
        List<WebElement> googleSearchbutton = driver.findElements(By.name("btnK"));
        if(googleSearchbutton.size()!=0)
            System.out.println("google search button is present");
        else
            System.out.println("google search button is not present");

        //check google feeling button is present
        Boolean isPresentGoogleFeelingButton = driver.findElements(By.id("gbqfbb")).size()>0;
        Assert.assertTrue(isPresentGoogleFeelingButton, "Google feeling button is present");

        //check sign in button is present
        Boolean ispresentSignInButton = driver.findElements(By.id("gb_70")).size()>0;
        Assert.assertTrue(ispresentSignInButton, "Google Sign-In Button is Present");

        //locate the google text box and type selenium and enter
        WebElement googleTextbox = driver.findElement(By.name("q"));
        googleTextbox.sendKeys("you rock!");

        googleTextbox.submit();

        //verify "you rock!" in text box
        try {
            WebDriverWait exlicitwait = new WebDriverWait(driver, 10);
            exlicitwait.until(ExpectedConditions.visibilityOf(googleTextbox));
            Assert.assertEquals(googleTextbox.getAttribute("value"), "you rock!");
        }
        catch (StaleElementReferenceException e){
            System.out.println("Element is not attached to the page document "+ e.getStackTrace());
        }



        //collect all urls on that page
        List<WebElement> allLinksInWebPage = driver.findElements(By.tagName("a"));

        int totalURL = allLinksInWebPage.size();

        if(totalURL!=0)
            System.out.println("total url on this page : "+totalURL);
        else
            System.out.println("this page does not have url");


        driver.quit();

    }
}
