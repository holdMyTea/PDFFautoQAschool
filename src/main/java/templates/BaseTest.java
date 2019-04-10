package templates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    protected void setUp() {
        driver = new ChromeDriver(generateChromeOptions());
    }

    @AfterTest
    protected void cleanUp() {
        driver.quit();
    }

    private ChromeOptions generateChromeOptions() {
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",prefs);
        return options;
    }
}

