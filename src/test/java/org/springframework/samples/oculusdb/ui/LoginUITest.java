package org.springframework.samples.oculusdb.ui;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginUITest {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLogin() throws Exception {
		driver.get("http://localhost:8080/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("testuser");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testuser");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Test
	public void testRegister() throws Exception {
		driver.get("http://localhost:8080/registration");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("testregister");

		driver.findElement(By.name("name")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Test");

		driver.findElement(By.name("surname")).click();
		driver.findElement(By.name("surname")).clear();
		driver.findElement(By.name("surname")).sendKeys("Register");

		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys("testregister@testregister.com");

		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("TestRegister1");

		driver.findElement(By.name("getPasswordConfirm")).click();
		driver.findElement(By.name("getPasswordConfirm")).clear();
		driver.findElement(By.name("getPasswordConfirm")).sendKeys("TestRegister1");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/form/input")).click();

		Assert.assertTrue(driver.getPageSource().contains("Welcome"));
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
