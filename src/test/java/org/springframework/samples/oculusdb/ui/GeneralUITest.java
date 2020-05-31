package org.springframework.samples.oculusdb.ui;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeneralUITest {

	private WebDriver driver;

	private String baseUrl;

	private boolean acceptNextAlert = true;

	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
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

	@Test
	public void testApplicationWithoutLogin() throws Exception {
		driver.get("http://localhost:8080/");
		Assert.assertTrue(driver.findElement(By.linkText("Lone Echo")).isDisplayed());
	}

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
	public void testAddToFavoritesUI2() throws Exception {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Eleven Table Tennis")).click();
		driver.findElement(By.id("addToFav")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Eleven Table Tennis")).isDisplayed());
	}

	@Test
	public void testPaymentUI() {
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
	public void testAddCommentUI() {
		driver.get("http://localhost:8080/applications/appInfo/100");
		driver.findElement(By.id("addCom")).click();
		driver.findElement(By.name("title")).clear();
		driver.findElement(By.name("title")).sendKeys("Automated Test Comment");
		driver.findElement(By.name("content")).clear();
		driver.findElement(By.name("content")).sendKeys("This is a test of Automated Test Comment");
		driver.findElement(By.id("sub")).click();
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/a"))
				.isDisplayed());
	}

	@Test
	public void testAddCommentUI2() throws Exception {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
		driver.findElement(By.id("addCom")).click();
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("Comentario de prueba");
		driver.findElement(By.id("content")).clear();
		driver.findElement(By.id("content")).sendKeys("Esto es un comentario de prueba");
		driver.findElement(By.id("sub")).click();
	}

	@Test
	public void testDeleteComment() {
		driver.get("http://localhost:8080/applications/appInfo/100");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/a")).click();
		Assert.assertTrue(driver.findElement(By.id("opSuc")).isDisplayed());

	}

	@Test
	public void testFavoritesList() throws Exception {
		driver.get("http://localhost:8080/applications/favorites");
		Assert.assertTrue(driver.findElement(By.linkText("Lone Echo")).isDisplayed());
	}

	@Test
	public void getNewApplicationExits() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Get New")).click();
		driver.findElement(By.name("id")).clear();
		driver.findElement(By.name("id")).sendKeys("1368187813209608");
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
		Assert.assertTrue(driver.getPageSource().contains("already"));
	}

	@Test
	public void getNewApplication() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Get New")).click();
		driver.findElement(By.name("id")).clear();
		driver.findElement(By.name("id")).sendKeys("1141678862547889");
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
		Assert.assertTrue(driver.getPageSource().contains("Evil"));
	}

	@Test
	public void testDownloadPDF() throws Exception {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
		driver.findElement(By.linkText("Download info on PDF")).click();
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
