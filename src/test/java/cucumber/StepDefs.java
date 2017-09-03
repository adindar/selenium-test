package cucumber;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDefs {

    WebDriver driver;

    @Given("^I am on the QAWorks Site$")
    public void iAmOnTheQAWorksSite() throws Throwable {
        System.setProperty("webdriver.chrome.driver","/Users/Alex/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://qaworks.com/contact.aspx");
    }

    @Then("^I try to contact QAWorks with the following information$")
    public void iShouldBeAbleToContactQAWorksWithTheFollowingInformation(List<Contact> contacts) throws Throwable {
        Assert.assertNotNull(contacts);
        Assert.assertTrue(contacts.size() > 0);

        for(Contact contact : contacts) {
            setText("ctl00_MainContent_NameBox", contact.getName());
            setText("ctl00_MainContent_EmailBox", contact.getEmail());
            setText("ctl00_MainContent_MessageBox", contact.getMessage());

            WebElement submitButton = driver.findElement(By.id("ctl00_MainContent_SendButton"));
            submitButton.click();
            checkInformationSent();
        }
    }

    @Then("^I can see the following message \"([^\"]*)\"$")
    public void iCanSeeTheFollowingMessage(String message) throws Throwable {
        Assert.assertTrue(driver.getPageSource().contains(message.trim()));
    }

    private void setText(String fieldId, String msg){
        WebElement nameBox = driver.findElement(By.id(fieldId));
        nameBox.sendKeys(msg);
    }

    private void checkInformationSent() {
        WebElement nameBox = driver.findElement(By.id("ctl00_MainContent_NameBox"));
        Assert.assertTrue(nameBox.getText().equals(""));
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}