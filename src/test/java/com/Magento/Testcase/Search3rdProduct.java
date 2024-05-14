package com.Magento.Testcase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Search3rdProduct {
	
    @Test
	public void verifySearchModule() throws InterruptedException, IOException
	{
		
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	driver.get("https://magento.softwaretestingboard.com/");
    	Thread.sleep(2000);
    	WebElement element = driver.findElement(By.xpath("//span[text()='Gear']"));
    	Actions act = new Actions(driver);
    	act.moveToElement(element).build().perform();
    	driver.findElement(By.xpath("//span[text()='Watches']")).click();
    	driver.findElement(By.className("filter-options-title")).click();
    	driver.findElement(By.className("count")).click();
    	Thread.sleep(2000);
    	JavascriptExecutor jse= (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,1340);");
    	Thread.sleep(5000);
    	TakesScreenshot ts= (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File("./Screenshots/Watch.png");
        Files.copy(src, des);
    	driver.findElement(By.xpath("(//img[@class='product-image-photo'])[3]")).click();
    	String ActualMessage = driver.findElement(By.xpath("//span[text()='Bolo Sport Watch']")).getText();
    	Assert.assertEquals(ActualMessage, "Bolo Sport Watch", "Not Matching");
    	String ActualMessage1 = driver.findElement(By.xpath("//span[text()='$49.00']")).getText();
    	Assert.assertEquals(ActualMessage1, "$49.00");
    	driver.findElement(By.id("qty")).clear();
    	driver.findElement(By.id("qty")).sendKeys("3");
    	driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//span[@class='counter-number']")).click();
    	driver.findElement(By.xpath("//span[text()='View and Edit Cart']")).click();
    	
	}
}
