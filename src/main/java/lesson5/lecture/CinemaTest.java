package lesson5.lecture;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import templates.BaseTest;

import java.util.List;

public class CinemaTest extends BaseTest {

    @Test
    private void myTest() {
        driver.get("http://liniakino.com/showtimes/aladdin/");
        List<WebElement> elements = this.driver.findElements(
                By.xpath(
                        "//ul[@class='showtimes-list']//a[contains(@href,'/movies/?id=')]"
                ));
        System.out.println(elements.size());
        for(WebElement e: elements) {
            System.out.println(e.getText());
        }
    }
}
