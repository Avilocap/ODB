package org.springframework.samples.oculusdb.ui.cucumber;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import io.cucumber.java.en.Given;
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
public class LoginTest {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	private void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\CimaGrande\\Documents\\geckodriver.exe");
		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("I am not logged in the system")
	public void testHome() throws Exception {
		setUp();
		driver.get("http://localhost:8080");
	}

	@Given("I do login as testuser")
	public void testLogin() throws Exception {
		driver.get("http://localhost:8080/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("testuser");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testuser");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
