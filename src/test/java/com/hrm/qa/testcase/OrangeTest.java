package com.hrm.qa.testcase;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.hrm.qa.basetest.BaseTest;
import com.hrm.qa.utilities.DataProviderForLogin;

public class OrangeTest extends BaseTest {

	@Test(dataProviderClass = DataProviderForLogin.class, dataProvider = "getLoginData")
	public void login(String username, String password) throws Exception {
		System.setProperty("org.uncommons.reportng.escape-output", "false"); // Need to import this package to use html
																				// tag in selenium
		// SoftAssert soft = new SoftAssert();
		// Validate the title
		Assert.assertEquals("OrangeHRM", "OrangeHRM", "Correct Title Showing");
		// System.out.println("Enter Username");
		log.debug("Enter Username");
		WebElement uName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		uName.clear();
		uName.sendKeys(username);
		// System.out.println("Enter Password");
		log.debug("Enter Password");
		// Reporter.log("Enter Password");
		// Reporter.log("<a
		// href=\"D:\\JavaWorkSpaceNew-Selenium1Jan2021\\DataDrivenFramework2\\Capture.jpg\">Screenshot</a>");
		// -> Escape sequence will be used \
		Reporter.log(
				"<a target=\"_blank\" href=\"D:\\JavaWorkSpaceNew-Selenium1Jan2021\\DataDrivenFramework2\\Capture.jpg\"><img src=\"D:\\JavaWorkSpaceNew-Selenium1Jan2021\\DataDrivenFramework2\\Capture.jpg\" height=200 weight=200></img> </a>");
		WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passWord.click();
		passWord.sendKeys(password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	@Test
	public void validatePage() {
		// Verify Account
		Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'Dashboard1')]")),"Element Not presentated");
		log.debug("Login successfully executed");
	}

}
