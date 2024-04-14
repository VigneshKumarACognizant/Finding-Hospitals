package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps 
{
	WebDriver driver = new ChromeDriver();
	@Given("User Navigate To Learining Page")
	public void userNavigateToLeariningPage() 
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}
	@When("User Click Submit Button")
	public void userClickSubmitButton()
	{
		 driver.findElement(By.id("submit")).click();
	}
	@Then("Login Should Be Success")
	public void loginShouldBeSuccess() 
	{
	   String verification = driver.findElement(By.className("post-title")).getText();
	   driver.quit();
	   Assert.assertEquals(verification, "Logged In Successfully");
	   
	}
	@But("Login Should Be Failure")
	public void loginShouldBeFailure()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String verification = driver.findElement(By.id("error")).getText();
		 driver.quit();
		 Assert.assertEquals(verification, "Your password is invalid!");
		   
	}
	@Given("User Enter The Name As {string}")
	public void userEnterTheNameAs(String Password)
	{
		driver.findElement(By.id("username")).sendKeys(Password);
	}
	@Given("User Enter The Password As {string}")
	public void userEnterThePasswordAs(String Name) 
	{
		
		driver.findElement(By.id("password")).sendKeys(Name);
	}
}
