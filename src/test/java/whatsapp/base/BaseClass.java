package whatsapp.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class BaseClass {
	public static WebDriver driver;

	public WebDriver launchBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public void screenshot() {
		String date = new SimpleDateFormat("dd_MM_yy_hhmmss").format(new Date());
		TakesScreenshot x = (TakesScreenshot) driver;
		File temp = x.getScreenshotAs(OutputType.FILE);
		File dest = new File("screenshots\\" + date + ".JPEG");
		try {
			Files.copy(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadUrl(String webPageName) {
		try {
			driver.get(webPageName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openNewTab() {
		try {
			Robot rbt = new Robot();
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_T);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			rbt.keyRelease(KeyEvent.VK_T);
			switchToWindow(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToWindow(int i) {
		try {
			Thread.sleep(2000);
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(i));
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buttonClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void quitBrowser() {
		try {
			Thread.sleep(2000);
			driver.quit();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
