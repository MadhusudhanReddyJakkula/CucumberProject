package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;



public class SearchRestaurant {
	 
	WebDriver driver= null ;
	

	
		@Before
		public void browserSetup() {
	
//			String projectPath=System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
//			driver = new ChromeDriver();
//
//			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//			driver.manage().window().maximize();
	
    String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
}
		
		  public static void waitForElementToAppear(ChromeDriver driver, By selector, long timeOutInSeconds) {
			  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
			  }
		

	@Given("User is on Homepage")
	public void user_is_on_Homepage() {
	    System.out.println("1");
	
		driver.navigate().to("https://www.skipthedishes.com");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath ("//*[text()='SkipTheDishes']")));
	}

	@When("User search for restaurants in {string}")
	public void user_search_for_restaurants_in(String string) {
		System.out.println("2");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath (" //input[@class='c5151 c5164']")));
		driver.findElement(By.xpath (" //input[@class='c5151 c5164']")).sendKeys(string);
		driver.findElement(By.xpath ("//span[@class= 'MuiButton-label-1216 jss75']")).click();
		
	}

	@And("User clicks on find restaurants in your area")
	public void user_clicks_on_find_restaurants_in_your_area() {
		System.out.println("2");
	Actions builder = new Actions(driver);        	
	builder.sendKeys(Keys.ENTER);
	}

	@Then("User should see some restaurants in searched address")
	public void user_should_see_some_restaurants_in_searched_address() {
		System.out.println("3");
	}


}
