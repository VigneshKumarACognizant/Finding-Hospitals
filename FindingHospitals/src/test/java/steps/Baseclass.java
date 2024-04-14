package steps;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageObjectModel.EmployeeHealthElements;
import pageObjectModel.PractoHomePageElements;
import utilities.PropertiesUtility;

public class Baseclass 
{
	protected static WebDriver driver;
	protected PractoHomePageElements practo; 
	protected EmployeeHealthElements details;
	protected PropertiesUtility property;
	protected String[] detail = new String[6]; 
	TakesScreenshot ts;
}
