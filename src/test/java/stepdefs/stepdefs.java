package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class stepdefs 
{
	WebDriver driver;
	String url="https://amazon.in";
	
	
	@Given("User Opened the Browser")
	public void User_Opened_the_Browser() 
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@When("User navigated to app url")
	public void User_navigated_to_app_url() 
	{
		driver.get(url);
	}
	
	@Then("user is able to see application landing page")
	public void user_is_able_to_see_application_landing_page() 
	{
		//assertion
		String titleExpected="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String titleActual=driver.getTitle();
		Assert.assertEquals(titleExpected, titleActual);
	}
	
	@Given("User Opened the Browser and navigated to app url")
	public void User_Opened_the_Browser_and_navigated_to_app_url() 
	{
		User_Opened_the_Browser();
		User_navigated_to_app_url();
	}
	
	@When("User search for the new product")
	public void User_search_for_the_new_product() 
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
	}
	
	@Then("Search result for the product is displayed")
	public void Search_result_for_the_product_is_displayed() 
	{
		
	}
}
