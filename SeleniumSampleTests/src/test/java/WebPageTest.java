import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebPageTest {

    /*

       Test scenario : A web page has 4 dropdowns on it. Each dropdown has a few options present which are dynamic.
       Please write a method that selects the first option from the first dropdown, second from the second and so on.
       You can assume xpaths of the dropdown and the options present.

       Test Steps:
        1. open Web Page app
        2. locate the drop down boxes
        3. select first option from first dropdown, second from the second and so on.

     */

    WebDriver driver;

    @Test
    public void webPageDropDownSelectTest() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("url to web page");
        WebElement[] accessDropDownElement = new WebElement[4];


        accessDropDownElement[0] = driver.findElement(By.xpath("//select[@id='firstDropDown']"));
        accessDropDownElement[1] = driver.findElement(By.xpath("//select[@id='secondDropdown']"));
        accessDropDownElement[2] = driver.findElement(By.xpath("//select[@id='thirdDropDown']"));
        accessDropDownElement[3] = driver.findElement(By.xpath("//select[@id='forthDropDown']"));

        //select first option from first dropdown, second from the second and so on.
        for (int i = 0; i < accessDropDownElement.length; i++) {
            selectdropDown(accessDropDownElement[i], i);
        }

        driver.quit();
    }


    //function for selecting drop-downs on web page
    private void selectdropDown(WebElement accessDropDownElement, int index) throws Exception {

            if (accessDropDownElement.isEnabled() && accessDropDownElement.isDisplayed()) {
                System.out.println("selecting drop-down boxes ");
                Select selectdropdowns = new Select(accessDropDownElement);
                selectdropdowns.selectByIndex(index);

            }

            else {
                System.out.println("Unable to select drop-down boxes");
            }
        }

    }
