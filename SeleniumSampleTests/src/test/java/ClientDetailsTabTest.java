import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ClientDetailsTabTest {

    /*
      Test Scenario: Below is a sample webpage. Please write the code to click on the “Client Details” tab,
        check the “Take App over the Phone” checkbox and verify if the First name and last name textboxes are disabled.


      Test Steps:
        1. open Web Page app
        2. click on client Details Page
        3. check the “Take App over the Phone” checkbox
        4. verify the FirstName and LastName textbox disabled
        (if its enabled then print enabled, if its disabled then print disabled)

     */

    WebDriver driver;

    @Test
    public void verify_firstName_lastName_textBox_isEnabledORDisabled() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("url to web Base page");


        //click on Client Details Page
        WebElement clientDetailsTabElement = driver.findElement(By.xpath("//select[@id='clientDetailsTab']"));
        clientDetailsTabElement.click();

        WebElement takeAppOverThePhoneCheckBoxElement = driver.findElement(By.xpath("//select[@id='takeAppOverThePhoneCheckBox']"));
        //Wait for the checkbox element to be visible
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(takeAppOverThePhoneCheckBoxElement));

        //check the “Take App over the Phone” checkbox
        selectTheCheckBox(takeAppOverThePhoneCheckBoxElement);

        WebElement firstNameTextbox = driver.findElement(By.xpath("//select[@id='firstname']"));
        WebElement lastNameTextbox = driver.findElement(By.xpath("//select[@id='lastname']"));


        //first name and last name textbox condition print
      if(firstNameTextbox.isEnabled()) {
          System.out.println("First Name Textbox is enabled");
      }

      else {
          System.out.println("First Name Textbox is disabled");
      }

      if(lastNameTextbox.isEnabled()) {
          System.out.println("Last Name Textbox is enabled");
      }
      else {
          System.out.println("Last Name Textbox is disabled");

      }

    }


    //function to check “Take App over the Phone” checkbox
    private void selectTheCheckBox(WebElement takeAppOverThePhoneCheckBoxElement) {
        try {
            if (takeAppOverThePhoneCheckBoxElement.isSelected()) {
                System.out.println("Checkbox: " + takeAppOverThePhoneCheckBoxElement + "is already selected");
            } else {
                // Select the checkbox
                takeAppOverThePhoneCheckBoxElement.click();
            }
        } catch (Exception e) {
            System.out.println("Unable to select the checkbox: " + takeAppOverThePhoneCheckBoxElement);
        }

    }


}






