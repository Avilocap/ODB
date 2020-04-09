package org.springframework.samples.oculusdb.ui;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled
public class LoginUITest {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\CimaGrande\\Documents\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("testuser");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testuser");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

//	@Test
//	public void testLogin() throws Exception {
//		driver.get("http://localhost:8080/login");
//		driver.findElement(By.name("username")).clear();
//		driver.findElement(By.name("username")).sendKeys("testuser");
//		driver.findElement(By.name("password")).click();
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys("testuser");
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//	}

	@Test
	public void testListApplicationsUI() throws Exception {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
	}

	@Test
	public void testAddToFavoritesUI() throws Exception {
		driver.get("http://localhost:8080/applications/appInfo/100");
		driver.findElement(By.id("addToFav")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Lone Echo")).isDisplayed());
	}

	@Test
	public void testPaymentUI(){
		driver.findElement(By.id("paym")).click();
		driver.findElement(By.name("number")).clear();
		driver.findElement(By.name("number")).sendKeys("4766649212071864");
		driver.findElement(By.name("expY")).clear();
		driver.findElement(By.name("expY")).sendKeys("2021");
		driver.findElement(By.name("expM")).clear();
		driver.findElement(By.name("expM")).sendKeys("12");
		driver.findElement(By.name("cvv")).clear();
		driver.findElement(By.name("cvv")).sendKeys("213");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.id("eveok")).isDisplayed());
	}

	@Test
	public void testAddCommentUI(){
		driver.get("http://localhost:8080/applications/appInfo/100");
		driver.findElement(By.id("addCom")).click();
		driver.findElement(By.name("title")).clear();
		driver.findElement(By.name("title")).sendKeys("Automated Test Comment");
		driver.findElement(By.name("content")).clear();
		driver.findElement(By.name("content")).sendKeys("This is a test of Automated Test Comment");
		driver.findElement(By.id("sub")).click();
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[3]/table/tbody/tr/td[1]")).isDisplayed());

	}



	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			}
			else {
				alert.dismiss();
			}
			return alertText;
		}
		finally {
			acceptNextAlert = true;
		}
	}

}
