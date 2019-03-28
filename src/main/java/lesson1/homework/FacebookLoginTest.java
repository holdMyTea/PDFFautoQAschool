package lesson1.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FacebookLoginTest {

    private final Path fbLoginsFilePath = Paths.get("/Users/oleksandrpohrebniak/stuff/fblogins.txt");
    private WebDriver driver;
    private String facebookEmail, facebookPass;

    public static void main(String[] args) throws InterruptedException {
        try{
            new FacebookLoginTest().execute();
        } catch (InterruptedException e) {
            System.out.println("Threading error");
        }
    }

    public FacebookLoginTest () {
        if (Files.exists(fbLoginsFilePath)) {
            System.out.println("Logins file found");
            try {
                this.readLoginsFromFile();
                System.out.println("Logins have been read from the file");
                return;
            } catch (IOException ioEx) {
                System.out.println("File reading failed, defaulting to console input");
            }
        }
        System.out.println("Logins file missing, manual input:");
        this.readLoginsFromConsole();
    }

    public void execute () throws InterruptedException {
        this.driver = new ChromeDriver(generateChromeOptions());

        driver.get("https://facebook.com");
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.cssSelector("[name='email']"));
        emailField.clear();
        emailField.sendKeys(this.facebookEmail);

        WebElement passField = driver.findElement(By.cssSelector("[name='pass']"));
        passField.clear();
        passField.sendKeys(this.facebookPass);
        passField.sendKeys(Keys.ENTER);

        // clicking on Messenger shortcut in the toolbar
        driver.findElement(By.cssSelector("[title='Messenger']")).click();

        Thread.sleep(1000);
        String lastMessage = driver.findElement(By.cssSelector("[class='_3oh- _58nk']")).getText();
        System.out.println("Your last message is: " + lastMessage);

        driver.quit();
    }

    private void readLoginsFromFile() throws IOException {
        List<String> lines = Files.readAllLines(fbLoginsFilePath);
        this.facebookEmail = lines.get(0);
        this.facebookPass = lines.get(1);
    }

    private void readLoginsFromConsole() {
        Scanner s = new Scanner(System.in);
        System.out.print("Email: ");
        this.facebookEmail = s.next();
        System.out.print("Password: ");
        this.facebookPass = s.next();
        s.close();
    }

    private static ChromeOptions generateChromeOptions() {
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",prefs);
        return options;
    }

}
