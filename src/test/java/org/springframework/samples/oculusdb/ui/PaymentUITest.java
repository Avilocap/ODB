package org.springframework.samples.oculusdb.ui;

import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentUITest {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	@LocalServerPort
	private int port;

	@BeforeEach
	private void setUp() throws Exception {
		String url = "http://localhost:" + port;
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

		driver = new FirefoxDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url + "/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("miguel");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testuser");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Test
	@Order(3)
	private void testPaymentUI_OK() {
		driver.findElement(By.id("paym")).click();
		Assert.assertTrue(driver.findElement(By.id("eveok")).isDisplayed());
	}

	@Test
	@Order(2)
	private void testPaymentUI_Already() {
		driver.findElement(By.id("paym")).click();
		driver.findElement(By.name("number")).clear();
		driver.findElement(By.name("number")).sendKeys("4567887754321234");
		driver.findElement(By.name("expY")).clear();
		driver.findElement(By.name("expY")).sendKeys("2026");
		driver.findElement(By.name("expM")).clear();
		driver.findElement(By.name("expM")).sendKeys("10");
		driver.findElement(By.name("cvv")).clear();
		driver.findElement(By.name("cvv")).sendKeys("356");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.id("eveok")).isDisplayed());
	}

	@Test
	@Order(1)
	private void testPaymentUI_bad() {
		driver.findElement(By.id("paym")).click();
		driver.findElement(By.name("number")).clear();
		driver.findElement(By.name("number")).sendKeys("11232431343431431433");
		driver.findElement(By.name("expY")).clear();
		driver.findElement(By.name("expY")).sendKeys("2000");
		driver.findElement(By.name("expM")).clear();
		driver.findElement(By.name("expM")).sendKeys("01");
		driver.findElement(By.name("cvv")).clear();
		driver.findElement(By.name("cvv")).sendKeys("222");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.id("paymentErr")).isDisplayed());
	}

	@AfterEach
	private void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
