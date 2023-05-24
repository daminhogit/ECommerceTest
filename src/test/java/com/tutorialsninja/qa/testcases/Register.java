package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.baseClass;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends baseClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup () {
		driver = initializeBrowserAndOpenAppURL("chrome");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod
	public void tearDown () {
		driver.quit();
	}
	

	@Test (priority = 1)
	public void verifyRegistrationOfAccountWithMandatoryFields () {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Damilola");
		driver.findElement(By.id("input-lastname")).sendKeys("Adesanya");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailwithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345678?!");
		driver.findElement(By.id("input-confirm")).sendKeys("12345678?!");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualSuccessHeading = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!","Account Success page is not displayed");
		
		
				
	}
	@Test (priority = 2)
	public void registerAccountByProvidingAllFields() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Daminho");
		driver.findElement(By.id("input-lastname")).sendKeys("Adez");
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailwithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345678?!");
		driver.findElement(By.id("input-confirm")).sendKeys("12345678?!");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String actualSuccessHeading = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualSuccessHeading,"Your Account Has Been Created!","Account Success page is not displayed");
			
		
		}
	
	@Test (priority=3)
	public void registerAccountWithAnExistingEmail() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Daminho");
		driver.findElement(By.id("input-lastname")).sendKeys("Adez");
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345678?!");
		driver.findElement(By.id("input-confirm")).sendKeys("12345678?!");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		
		Assert.assertEquals(actualWarning, "Warning: E-Mail Address is already registered!", "Warning Message regarding duplicate E-mail not displayed");
		
			
		}
	
	@Test (priority=4)
	public void verifyRegistrationWithoutFillingAnyDetails () {
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String actualPrivacyWarning = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(actualPrivacyWarning.contains("Warning: You must agree to the Privacy Policy!"),"Privacy Policy warning message is not displayed!");
		
		String actualFirstNameWarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertEquals(actualFirstNameWarning,"First Name must be between 1 and 32 characters!","First Name warning message is not displayed");
		
		String actualLastNameWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
		Assert.assertEquals(actualLastNameWarning,"Last Name must be between 1 and 32 characters!","Last Name warning message is not displayed");
		
		String actualEmailWarning = driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText();
		Assert.assertEquals(actualEmailWarning,"E-Mail Address does not appear to be valid!","E-Mail warning message is not displayed");
		
		String actualTelephoneWarning = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();
		Assert.assertEquals(actualTelephoneWarning,"Telephone must be between 3 and 32 characters!","Telephone warning message is not displayed");
	
		String actualPasswordWarning = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		Assert.assertEquals(actualPasswordWarning,"Password must be between 4 and 20 characters!","Password warning message is not displayed");
	
		
	
	}
	
}
	



