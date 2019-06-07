import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AmazonHomePage {

    /*
        1. open Amazon web app
        2. locate the search text box and type Parth
        3. Click on search button

     */

    WebDriver driver;
    @Test
    public void amazonHomePageTest() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://www.amazon.com/");
        WebElement searchTextBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchTextBox.sendKeys("Parth");
        WebElement goButton = driver.findElement(By.cssSelector("input[value=Go]"));
        clickOnButton(goButton);
    }

    public void clickOnButton(WebElement buttonElement) throws Exception {
        try {
            if (buttonElement.isEnabled() && buttonElement.isDisplayed()) {
                System.out.println("Clicking on go button ");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonElement);
            } else {
                System.out.println("Unable to click on go button");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "+ e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM "+ e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element "+ e.getStackTrace());
        }
    }
}