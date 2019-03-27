package lesson1.lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchHelloWorld {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[name='q']")).clear();
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Hello, World!");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector(".g h3")).click();

        Thread.sleep(1000);
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}
