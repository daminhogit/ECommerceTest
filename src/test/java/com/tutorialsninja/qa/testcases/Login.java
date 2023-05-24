package com.tutorialsninja.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.baseClass;

public class Login extends baseClass {
	WebDriver driver;
	
	@BeforeMethod
	public void setup () {
		
	driver = initializeBrowserAndOpenAppURL("edge");
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.linkText("Login")).click();
	}
	
	@AfterMethod
	public void	tearDown () {
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifyingLoginWithValidCredentials () {

		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
				
	}
	@Test (priority=2)
	public void loginWithWrongDetails () {

		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@yahoomail.com");
		driver.findElement(By.id("input-password")).sendKeys("ABC12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
		
	}
	@Test (priority=3)
	public void verifyingLoginWithValidEmailAndInvalidPassword () {

		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("ABC123345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
		
	}
	@Test (priority=4)
	public void verifyingLoginWithoutProvidingCredentials () {

		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
		
	}
}
 