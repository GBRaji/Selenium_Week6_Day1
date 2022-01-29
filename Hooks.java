package Steps;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass {
	@Before
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
	     driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
	}
		
	
	@After
	public void postCondition() {
	driver.close();

}
}