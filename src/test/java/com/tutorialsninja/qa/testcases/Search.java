package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.baseClass;

public class Search extends baseClass {
	WebDriver driver;
	
	@BeforeMethod
	public void setup () {
		driver = initializeBrowserAndOpenAppURL("firefox");
	}
	
	@AfterMethod
	public void tearDown () {
		driver.quit();
	}
	
	@Test (priority=1)
	public void verifySearchWithValidProduct () {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}
	
	@Test (priority=2)
	public void verifySearchWithInvalidProduct () {
		driver.findElement(By.name("search")).sendKeys("Lenovo");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		String productWarning = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).getText();
		Assert.assertEquals(productWarning, "There is no product that matches the search criteria.", "No product warning about product search");
	}
	
	@Test (priority=3)
	public void verifySearchWithoutAnyProduct () {
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		String productWarning = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]")).getText();
		Assert.assertEquals(productWarning, "There is no product that matches the search criteria.", "No product warning about product search");
		
	}
}
