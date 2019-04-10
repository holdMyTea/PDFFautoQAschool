package templates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    protected void setUp() {
        driver = new ChromeDriver();
    }

    @AfterTest
    protected void cleanUp() {
        driver.quit();
    }
}

