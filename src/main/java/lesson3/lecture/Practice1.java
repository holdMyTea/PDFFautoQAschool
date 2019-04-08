package lesson3.lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Practice1 {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("https://www.imdb.com/chart/top");
        for(WebElement element: driver.findElements(By.xpath("//td[@class='titleColumn']/a"))) {
            System.out.print(element.getText()+" -- ");
            System.out.println(element.getAttribute("href"));
        }
        for(WebElement element: driver.findElements(By.xpath("//td[@class='ratingColumn imdbRating']/strong"))) {
            System.out.println(element.getText());
        }

    }

    @AfterTest
    public void closeUp() {
        driver.quit();
    }
}
