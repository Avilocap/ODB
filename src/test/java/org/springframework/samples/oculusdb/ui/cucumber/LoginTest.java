package org.springframework.samples.oculusdb.ui.cucumber;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginTest {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	private void setUp() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
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
