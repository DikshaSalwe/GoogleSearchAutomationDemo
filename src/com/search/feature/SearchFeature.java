package com.search.feature;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchFeature {
	WebDriver driver;
	private String chromeDriverPath = "./Driver/chromedriver.exe";
	private String URL = "https://www.google.co.nz";

	@BeforeClass
	public void testSetup() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void openBrowser() {
		driver.get(URL);
		System.out.println("Window title is " + driver.getTitle());
	}

	@Test(suiteName="Google Search Feature", description = "To Check the avalability of search box to enter keywords")
	public void googleSearchFeature() {

		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		// locate Search
		WebElement searchbox = driver.findElement(By.name("q"));
		String inputTitle = searchbox.getAttribute("title");
//		searchbox.sendKeys("Crimson Education");
//		searchbox.sendKeys(Keys.ENTER);
		Assert.assertEquals(inputTitle, "Search");
	}
	
	@Test(suiteName="Google Search Feature", description="To check the availability of button to submit keywords to search and verify that request get hit by clicking search")
	public void validateSearchButton() {
		WebElement searchButton = driver.findElement(By.name("btnK"));
		Assert.assertNotNull(searchButton);
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Crimson Education");
		
		//searchButton.click();
	}

	@Test(suiteName="Google Search Feature", description="To check for the order of search result, whether it is according to metalogs or relevent")
	public void checkForSearchResultOrder() {
		// 
	}
	
	@Test(suiteName="Google Search Feature", description="To check for the order of search result, whether it is according to metalogs or relevent")
	public void checkForVoiceSearchButton() throws InterruptedException {
		WebElement voiceSearchBtn = driver.findElement(By.xpath("//*[@aria-label='Search by voice']"));
		Assert.assertNotNull(voiceSearchBtn);
		//voiceSearchBtn.click();
	}
	@AfterClass
	public void postclass() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
