package lesson3.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class CinemaSeatsCount {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        driver.get("http://liniakino.com/showtimes/aladdin/");

        this.clickShowtimeLink();

        this.switchToIframe();

        this.close3DPopup();

        this.parseSeats();
    }

    @AfterTest
    public void cleanUp() {
        driver.quit();
    }

    private void clickShowtimeLink() {
        driver.findElement(By.xpath(
                "//a[@href='/movies/?id=7531']" + //finding a link leading to the "Dambo" movie description
                        "/.." + //making a step up to h1 containing it
                        "/.." + //another step up to the "Dambo" movie div
                        "//li[@class='showtime-item'][1]/a" //finding the first link
        )).click();
    }

    private void switchToIframe() {
        driver.switchTo().frame(
                driver.findElement(
                        By.xpath("//div[@id='vkino-widget']/iframe")
                ));
    }

    private void close3DPopup() {
        WebElement popupClose = new WebDriverWait(driver,5)
                .until(
                        ExpectedConditions.visibilityOfElementLocated(
                                By.xpath(
                                        "//div[@class='window-close arcticmodal-close']"
                                )));
        new Actions(driver).moveToElement(popupClose).click().perform(); //won't allow to click it, unless scrolled to it
    }

    private void parseSeats() {
        List<WebElement> seats = driver.findElements(
                By.xpath(
                        "//div[@id='hall-scheme-container']/div/div[contains(@class,'seat')]"
                ));

        int available = 0, occupied = 0, total = seats.size();
        for (WebElement seat: seats) {
            String selector = seat.getAttribute("class");
            if (selector.equals("seat seat-color1")) {
                available++;
            } else if (selector.equals("seat seat-occupied")) {
                occupied++;
            }
        }

        System.out.println("Total seats: "+total);
        System.out.println("Occupied seats: "+occupied);
        System.out.println("Available seats: "+available);
        System.out.printf("Fraction of occupied: %.2f%%\n", ((double) occupied)/total*100);
        System.out.printf("Fraction of available: %.2f%%\n", ((double) available)/total*100);
    }

}
