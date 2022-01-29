package Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeafTap extends BaseClass {
	@Given("Enter the Username as {string}")
	public void enterUserName(String Username) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Username);

	}

	@Given("Enter password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

	}

	@When("Click on Login Button")
	public void clickLogin1() {
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

	}

	@Then("Homepage should display")
	public void verifyHomepage() {
		String title = driver.getTitle();
		if (title.contains("TestLeaf")) {
			System.out.println(" Page is verified");
		} else {
			System.out.println(" Page is not verifed");
		}

	}

	@When("Click on Leads")
	public void clickOnLead() {
		driver.findElement(By.linkText("Leads")).click();

	}

	@When("Create Lead")
	public void createLead() {
		driver.findElement(By.linkText("Create Lead")).click();

	}

	@When("Enter Company Name {string}")
	public void enterCompanyName(String company) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);

	}

	@When("Enter First Name {string}")
	public void enterFirstName(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}

	@When("Enter Last Name {string}")
	public void enterLastName(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);

	}

	@When("Click Submit Button")
	public void clickSubmitButton() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Then("Verify Lead creation")
	public void verifyLeadCreation() {
		System.out.println("Lead Create Sussfully");
	}

	@Given("Find Lead to Edit")
	public void findLead() {
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@When("Click PhoneNumber and Enter Number {string}")
	public void clicPhoneNumber(String phone) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phone);

	}

	@When("Click Find Lead")
	public void fineLead1() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
	}

	@When("Edit Lead Company Name {string}")
	public void editcompany(String comp) {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(comp);

	}

	@When("Click Submit Button for edit")
	public void sub() {
		driver.findElement(By.name("submitButton")).click();
	}

	@Given("Find Lead to Merge")
	public void findLeadToMerge() {
		driver.findElement(By.linkText("Merge Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(1));
	}

	@When("Enter Firstname to Merge {string}")
	public void firstNametoMerge(String namee) {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(namee);

	}

	@When("Click submit to Merge")
	public void clickMerge() {
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allhandles = new ArrayList<String>(allWindows);
		driver.switchTo().window(allhandles.get(0));
	}

	@Given("Select Lead to Find Duplicate")
	public void findDuplicateLead() {
		driver.findElement(By.linkText("Find Leads")).click();
	}

	@When("Enter Phonenumber {string}")
	public void enterphone(String ph) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);

	}

	@When("Find Lead for Duplicate")
	public void leadDuplicate() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();

	}

	@When("Click Submit to know Duplicate")
	public void subDuplicate() {
		driver.findElement(By.name("submitButton")).click();
	}

	@When("Select Lead to Delete")
	public void selectDeleteLead() {
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@When("Enter PhoneNumber {string}")
	public void enterPhonenumbers(String pph) {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(pph);

	}

	@When("Click Lead to Delete")
	public void leadDelete() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Delete")).click();

	}

	@When("Verify Lead Deleted")
	public void verifyLeadDelete() {
		String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"))
				.getText();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
	}
}
