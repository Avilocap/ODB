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
public class GeneralUITest {

	private WebDriver driver;

	private String baseUrl;

	private final boolean acceptNextAlert = true;

	private final StringBuffer verificationErrors = new StringBuffer();

	@LocalServerPort
	private int port;

	@BeforeEach
	private void setUp() {
		String url = "http://localhost:" + port;
		System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

		driver = new FirefoxDriver();
		// driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url + "/login");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("testuser");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("testuser");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Test
	private void testListApplicationsUI() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
		Assert.assertTrue(driver.getPageSource().contains("Lone Echo"));
	}

	@Test
	private void testAddToFavoritesUI() {
		String url = "http://localhost:" + port;
		driver.get(url + "/applications/appInfo/102");
		driver.findElement(By.id("addToFav")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Guided Tai Chi")).isDisplayed());
	}

	@Test
	private void testAddToFavoritesUI2() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Eleven Table Tennis")).click();
		driver.findElement(By.id("addToFav")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Eleven Table Tennis")).isDisplayed());
	}

	@Test
	private void testAddToFavoritesError() throws Exception {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
		driver.findElement(By.id("addToFav")).click();
		Assert.assertTrue(driver.getPageSource().contains("already"));
	}

	@Test
	private void testDeleteFavorite() throws Exception {
		driver.findElement(By.id("favorites")).click();
		driver.findElement(By.linkText("Quit from list")).click();
		Assert.assertTrue(driver.getPageSource().contains("My favorite apps"));
	}

	@Test
	private void testAddCommentUI() {
		String url = "http://localhost:" + port;
		driver.get(url + "/applications/appInfo/100");
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
	private void testCommentUIHasError() throws Exception {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Eleven Table Tennis")).click();
		driver.findElement(By.id("addCom")).click();
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("good");
		driver.findElement(By.id("sub")).click();
		Assert.assertEquals("New Comment", driver.findElement(By.xpath("//h2")).getText());
	}

	@Test
	private void testAddCommentUI2() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
		driver.findElement(By.id("addCom")).click();
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).clear();
		driver.findElement(By.id("title")).sendKeys("Comentario de prueba");
		driver.findElement(By.id("content")).clear();
		driver.findElement(By.id("content")).sendKeys("Esto es un comentario de prueba");
		driver.findElement(By.id("sub")).click();
		Assert.assertTrue(driver.getPageSource().contains("comentario de prueba"));
	}

	@Test
	private void testDeleteComment() {
		String url = "http://localhost:" + port;
		driver.get(url + "/applications/appInfo/100");
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[3]/a")).click();
		Assert.assertTrue(driver.findElement(By.id("opSuc")).isDisplayed());

	}

	@Test
	private void testFavoritesList() {
		String url = "http://localhost:" + port;
		driver.get(url + "/applications/favorites");
		Assert.assertTrue(driver.findElement(By.linkText("Lone Echo")).isDisplayed());
	}

	@Test
	private void getNewApplicationExists() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Get New")).click();
		driver.findElement(By.name("id")).clear();
		driver.findElement(By.name("id")).sendKeys("1368187813209608");
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
		Assert.assertTrue(driver.getPageSource().contains("already"));
	}

	@Test
	private void getNewApplication() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Get New")).click();
		driver.findElement(By.name("id")).clear();
		driver.findElement(By.name("id")).sendKeys("1141678862547889");
		driver.findElement(By.xpath("/html/body/div/div/form/input[2]")).click();
		Assert.assertTrue(driver.getPageSource().contains("app"));
	}

	@Test
	private void testDownloadPDF() {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
		driver.findElement(By.linkText("Download info on PDF")).click();
	}

	@Test
	private void testListUsers() {
		String url = "http://localhost:" + port;
		driver.get(url + "/tools");
		driver.findElement(By.linkText("User List")).click();
		Assert.assertEquals("josema", driver.findElement(By.xpath("//table[@id='app']/tbody/tr[2]/td")).getText());
	}

	@Test
	private void testNewSponsorship() {
		String url = "http://localhost:" + port;
		driver.get(url + "/tools");
		driver.findElement(By.linkText("New Sponsorhips")).click();
		driver.findElement(By.id("title")).click();
		driver.findElement(By.id("title")).sendKeys("New sponsorship");
		driver.findElement(By.id("attachmentUrl")).click();
		driver.findElement(By.id("attachmentUrl")).sendKeys("A new sponsorship");
		driver.findElement(By.id("sub")).click();
	}

	@Test
	private void testShowApplicationsDetailsUI() throws Exception {
		driver.findElement(By.id("appList")).click();
		driver.findElement(By.linkText("Lone Echo")).click();
		Assert.assertEquals("Lone Echo", driver.findElement(By.xpath("//h1")).getText());

	}

	@Test
	public void testNewSponsorship2() throws Exception {
		String url = "http://localhost:" + port;
		driver.get(url + "/tools");

	}

	@AfterEach
	private void tearDown() {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
