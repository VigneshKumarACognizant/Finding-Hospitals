package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends Baseclass
{
	@AfterStep
    public void addScreenshot(Scenario scenario) {
        
        if(scenario.isFailed()) {
        	ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());   
        	driver.quit();
        }
    }

	
	
}
