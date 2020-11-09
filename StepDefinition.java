import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.annotation.en.Then;


public class StepDefinition {

	WebDriver driver;
	String text;

	@Given("^firefox is started and navigated to index page$")
	public void firefox_is_started_and_navigated_to_index_page() {
		driver = new FirefoxDriver();

		driver.get("http://apps.qa2qe.cognizant.e-box.co.in/CucumberHostelFeeCalc/");

	}

	@When("^I enter student name, student type \"([^\"]*)\", Number of Students Per room \"([^\"]*)\" and click the get total fee button.$")
	public void I_enter_student_name_student_type_Number_of_Students_Per_room_and_click_the_get_total_fee_button(String arg1, String arg2) {

		driver.findElement(By.name("name")).sendKeys("keerthi");

		if (arg1.equalsIgnoreCase("Hosteller")){
			driver.findElements(By.name("type")).get(0).click();
		}
		else{
			driver.findElements(By.name("type")).get(1).click();	
		}

		driver.findElement(By.name("number")).sendKeys(arg2);
		driver.findElement(By.name("getFee")).click();
		
	}

	@Then("^I validate College Fee \"([^\"]*)\", Hostel Fee \"([^\"]*)\", Additional Fee \"([^\"]*)\", Total Fee \"([^\"]*)\" and close the driver with quit method$")
	public void I_validate_College_Fee_Hostel_Fee_Additional_Fee_Total_Fee_and_close_the_driver_with_quit_method(String arg1, String arg2, String arg3, String arg4) {

		if (arg1.equals("0"))
			arg1 = "--";
		else
			arg1 = "Rs." + arg1 + ".0";
		
		if (arg2.equals("0"))
			arg2 = "--";
		else
			arg2 = "Rs." + arg2 + ".0";
		
		if (arg3.equals("0"))
			arg3 = "--";
		else
			arg3 = "Rs." + arg3 + ".0";
		
		if (arg4.equals("0"))
			arg4 = "--";
		else
			arg4 = "Rs." + arg4 + ".0";
		
		System.out.println(driver.findElement(By.xpath("//table//tr[1]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//table//tr[2]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//table//tr[3]/td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//table//tr[4]/td[2]")).getText());
		
		Assert.assertTrue(driver.findElement(By.xpath("//table//tr[1]/td[2]")).getText().equals(arg1));
		Assert.assertTrue(driver.findElement(By.xpath("//table//tr[2]/td[2]")).getText().equals(arg2));
		Assert.assertTrue(driver.findElement(By.xpath("//table//tr[3]/td[2]")).getText().equals(arg3));
		Assert.assertTrue(driver.findElement(By.xpath("//table//tr[4]/td[2]")).getText().equals(arg4));
		
		
		driver.close();
		driver.quit();
	}



}
