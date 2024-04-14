package books;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import driver.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class hooks extends DriverInstance
{
	@BeforeStep
	public void beforeStep(Scenario s)
	{
		System.out.println("Step started");
		byte [] screen = driver.getScreenshotAs(OutputType.BYTES);
		s.attach(screen, "image/png","img1");
	}
	
	@AfterStep
	public void afterStep(Scenario s)
	{
		System.out.println("Step done");
		byte [] screen = driver.getScreenshotAs(OutputType.BYTES);
		s.attach(screen, "image/png","img1");
	}
	
	@Before
	public void beforeScenario(Scenario s)
	{
		System.out.println(s.getName()+"Started");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@After
	public void afterScenario(Scenario s)
	{
		System.out.println(s.getName()+"Ended");
		if(s.isFailed())
		{
			byte [] screen = driver.getScreenshotAs(OutputType.BYTES);
			s.attach(screen, "image/png","img1");
		}
		driver.quit();
	}
}
