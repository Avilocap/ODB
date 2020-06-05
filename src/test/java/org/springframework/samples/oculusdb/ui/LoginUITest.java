package org.springframework.samples.oculusdb.ui;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Transactional
public class LoginUITest {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	@LocalServerPort
	private int port;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLogin() throws Exception {
		String url = "http://localhost:" + port;
		driver.get(url + "/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("testuser");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testuser");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Test
	public void testRegister() throws Exception {
		String url = "http://localhost:" + port;
		driver.get(url + "/registration");
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
