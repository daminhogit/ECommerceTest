package com.tutorialsninja.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class baseClass {
	WebDriver driver;
	
	public WebDriver initializeBrowserAndOpenAppURL (String browserName) {
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get("http://www.tutorialsninja.com/demo/");
		
		return driver;
		
	}

}
