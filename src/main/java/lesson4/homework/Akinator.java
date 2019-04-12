package lesson4.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class Akinator {
    private WebDriver driver;
    private Scanner scanner;
    private String question;

    public static void main(String[] args) {
        new Akinator().test();
    }

    private void test() {
        driver = new ChromeDriver(generateChromeOptions());
        scanner = new Scanner(System.in);

        driver.get("https://ru.akinator.com");
        driver.findElement(By.cssSelector(".btn-play")).click();

        By titleLocator = By.cssSelector(".question-text");
        question = "";

        this.waitUntilElementIsFound(titleLocator);

        try {
            while (true) {
                wiatForQuestionUpdate(titleLocator);
                System.out.println(question);
                requestInput(findAndPrintOptions());
            }
        } catch (TimeoutException e) {
            System.out.println("The answer is: " + driver.findElement(By.cssSelector(".proposal-title")).getText());
        }

        driver.quit();
    }

    private List<WebElement> findAndPrintOptions() {
        List<WebElement> list = driver.findElements(By.cssSelector(".database-selection.selector.dialog-box li a"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " - " + list.get(i).getText());
        }
        return list;
    }

    private void requestInput(List<WebElement> options) {
        System.out.print("Your choice: ");
        int choice = 0;
        while (!(0 < choice && choice < options.size() + 1)) {
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Missed");
            }
        }
        options.get(choice-1).click();
    }

    private void wiatForQuestionUpdate(By rule) {
        new WebDriverWait(driver, 5).until(
                (ExpectedCondition<Boolean>) webDriver -> {
                    String current = webDriver.findElement(rule).getText();
                    if (!current.equals(question)) {
                        question = current;
                        return true;
                    }
                    return false;
                }
        );
    }

    private WebElement waitUntilElementIsFound(By rule) throws TimeoutException {
        return new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(rule));
    }

    private ChromeOptions generateChromeOptions() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        return options;
    }
}
