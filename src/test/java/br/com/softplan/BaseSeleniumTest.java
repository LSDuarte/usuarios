package br.com.softplan;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSeleniumTest {

	protected WebDriver driver;
	protected WebDriverWait waitDefault;
	
	@Before
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Dev/drivers/chromedriver.exe"); //necessário trocar para pasta onde fica o Driver
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		waitDefault = new WebDriverWait(driver, 30);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
}