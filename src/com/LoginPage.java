package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage extends openMRSTests{
//	@Test(priority=0)
	@Given("^Open Application and Enter url$")
	public void open_Application_and_Enter_url() throws Throwable {
	  openMRSTests.driver.get("https://demo.openmrs.org/openmrs/login.htm");
	  
	}
	@Test(priority=1)
	@When("^enter username$")
	public void enter_username() throws Throwable {
		openMRSTests.driver.findElement(By.id("username")).sendKeys("Admin123456");
	}
	@Test(priority=2)
	@When("^enter password$")
	public void enter_password() throws Throwable {
		openMRSTests.driver.findElement(By.id("password")).sendKeys("Admin123");
		openMRSTests.driver.findElement(By.id("Inpatient Ward")).click();
		openMRSTests.driver.findElement(By.id("loginButton")).click();
	}
//	@Test(priority=3)
//	@Then("^verify Msg$")
	public void verify_Msg() throws Throwable {
	   boolean result =  openMRSTests.driver.findElement(By.tagName("h4")).getText().contains("Logged");
	   Assert.assertTrue(result);
	}

}
