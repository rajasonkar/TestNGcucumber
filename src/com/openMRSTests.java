package com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

 
		@CucumberOptions(
				features="F:\\workspace\\Test_TestNG_Cucuber\\src\\com\\Login.feature",
				glue={"org.cucumber.stepdefs"},
				format=
						{"pretty",
						"html:target/cucumber-reports/cucumber-pretty",
						"json:target/cucumber-reports/CucumberTestReport.json",
						"rerun:target/cucumber-reports/re-run.txt",
						"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
				)
		public class openMRSTests  {
			public static WebDriver driver  ;
			private TestNGCucumberRunner testRunner;
			
		@BeforeClass
		public void setUP()
		{
			ExtentReports  e = new ExtentReports();
		
		ExtentHtmlReporter  htmlReporter = new ExtentHtmlReporter("test-output/myExtentReport.html");
        e.attachReporter(htmlReporter);
			System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Desktop/jars/chromedriver.exe");
			driver = new ChromeDriver() ;
			testRunner = new TestNGCucumberRunner(openMRSTests.class);
			
		}
		//description="login"
		@Test(description="login" , dataProvider = "features")
		public void login(CucumberFeatureWrapper cFeature)
		{
			testRunner.runCucumber(cFeature.getCucumberFeature());
		}
		@DataProvider(name="features")
		public Object[][] getFeatures()
		{
			return testRunner.provideFeatures();
		}
	//	@AfterMethod
		@AfterClass
		public void tearDown()
		{
			
			Reporter.loadXMLConfig(new File("src/com/extent-config.xml"));
			Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
			Reporter.setSystemInfo("User Name", "RS");
			Reporter.setSystemInfo("Application Name", "Test App ");
			Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
			Reporter.setSystemInfo("Environment", "TEST");
			Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
			driver.quit();
		//	testRunner.finish();
		}
}
 
	
	
