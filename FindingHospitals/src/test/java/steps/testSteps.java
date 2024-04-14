package steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjectModel.EmployeeHealthElements;
import pageObjectModel.PractoHomePageElements;
import utilities.PropertiesUtility;

public class testSteps extends Baseclass

{

	@Given("user Open Practo page")
	public void userOpenPractoPage() throws FileNotFoundException, IOException {
		driver = new ChromeDriver();
		practo = new PractoHomePageElements(driver); 
		details = new EmployeeHealthElements(driver);
		property = new PropertiesUtility();
		driver.get(property.getValue("Test_URL"));
		detail = property.getValue("Details").split(" ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Given("user click on For corparates dropdown")
	public void userClickOnForCorparatesDropdown() {
		practo.clickOnCorporate();
	}
	@Given("Click on Health and wellness plan")
	public void clickOnHealthAndWellnessPlan() {
		practo.clickOnHealth();
	}
	@Given("Enter the name")
	public void enterTheName() {
		details.enterName(detail[0]);
	}
	@Given("Enter the Organization name")
	public void enterTheOrganizationName() {
		details.enterOrganization(detail[1]);
	}
	@Given("selects the organization size")
	public void selectsTheOrganizationSize() {
		details.selectOrgSize(detail[2]);
	}
	@Given("select the Interested in option")
	public void selectTheInterestedInOption() {
		details.selectInterestedIn(detail[3].replace("-", " "));
	}
	@Given("user enter the contact number as {string}")
	public void userEnterTheContactNumberAs(String phnum) {
		details.enterContact(phnum);
	}
	@Given("user enter the email id as {string}")
	public void userEnterTheEmailIdAs(String email) {
		details.enterEmail(email);
	}
	@When("Login button should be enabeld")
	public void loginButtonShouldBeEnabeld() {
		//WebElement submitBtn = details.getSubmitElement();
		details.clickOnSubmit();
		
		System.out.println(details.getConformationMessage());
		SoftAssert a = new SoftAssert();
		a.assertEquals(details.getConformationMessage(),"THANK YO");
		driver.quit();
	}
	@When("Login button should be Disabeld")
	public void loginButtonShouldBeDisabeld() {
		Assert.assertEquals(details.getSubmitElement().isEnabled(),false);
		driver.quit();
	}

}
