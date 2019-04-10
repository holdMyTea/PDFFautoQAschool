package lesson5.lecture;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver driver;

    @BeforeTest
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterTest
    void cleanUp() {
        driver.quit();
    }
}

