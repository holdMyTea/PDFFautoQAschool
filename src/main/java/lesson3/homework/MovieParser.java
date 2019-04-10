package lesson3.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import templates.BaseTest;

public class MovieParser extends BaseTest {

    @Test
    private void test() {
        this.driver.get("https://www.imdb.com/title/tt0111161/");

        System.out.println("Title: " +
                this.driver.findElement(
                        By.xpath("//div[@class='title_wrapper']/h1")
                ).getText()
        );

        System.out.println("Release date: " +
                this.driver.findElement(
                        By.xpath("//a[@title='See more release dates']")
                ).getText()
        );

        System.out.println("Duration: " +
                formatDuration(
                        this.driver.findElement(
                                By.xpath("//div[@class='subtext']/time")
                        ).getText()
                )
        );

        System.out.println("Rating: " +
                this.driver.findElement(
                        By.xpath("//div[@class='ratingValue']//span")
                ).getText()
                + "/10"
        );

        System.out.println("Genre: " +
                this.driver.findElement(
                        By.xpath("//div[@class='subtext']/a[contains(@href,'/search/title?genres=')]")
                ).getText()
        );

        System.out.println("Link to trailer: " +
                this.driver.findElement(
                        By.xpath("//div[@class='slate']/a")
                ).getAttribute("href")
        );

        System.out.println("Link to poster: " +
                this.driver.findElement(
                        By.xpath("//div[@class='poster']/a/img")
                ).getAttribute("src")
        );

        System.out.println("Director: " +
                this.driver.findElement(
                        By.xpath("//div[@class='plot_summary ']/div[@class='credit_summary_item'][1]/a")
                ).getText()
        );

        System.out.println("Cast: " + parseCast());

        System.out.println("Metacritic score: " +
                this.driver.findElement(
                        By.xpath("//div[@class='metacriticScore score_favorable titleReviewBarSubItem']/span")
                ).getText()
                + "/100"
        );

        System.out.println("Reviews: " + parseReviews());

        System.out.println("Similar movies: " + parseSimilars());
    }

    private String formatDuration(String time) {
        int hours = Integer.parseInt(
                time.substring(0, time.indexOf("h")));

        int minutes = Integer.parseInt(
                time.substring(
                        time.indexOf(" ") + 1,
                        time.indexOf("min")
                ));

        int totalMinutes = minutes + hours * 60;
        return totalMinutes + " minutes (" + (totalMinutes * 60) + " seconds)";
    }

    private String parseCast() {
        WebElement castTable = this.driver.findElement(
                By.xpath("//table[@class='cast_list']/tbody")
        );

        String cast = "";
        for (int i = 0; i < 5; i++) {
            cast += castTable.findElement(
                    By.xpath("./tr[" + (i + 2) + "]/td[2]/a")
            ).getText() + ", ";
        }
        cast = cast.substring(0, cast.length() - 2); // removing extra comma and space
        return cast;
    }

    private String parseReviews() {
        WebElement container = this.driver.findElement(
                By.xpath("//div[@class='titleReviewBarItem titleReviewbarItemBorder']//span")
        );

        int users = parseReviewCount(
                container.findElement(
                        By.xpath("./a[1]")
                ).getText()
        );

        int critics = parseReviewCount(
                container.findElement(
                        By.xpath("./a[2]")
                ).getText()
        );

        return users + " users, " + critics + " critics, " + (users + critics) + " total";
    }

    private String parseSimilars() {
        WebElement container = this.driver.findElement(
                By.xpath("//div[@class='rec_page rec_selected']")
        );

        String similars = "";
        for (int i = 0; i < 3; i++) {
            similars += "\"" + container.findElement(
                    By.xpath("./div[" + (i + 1) + "]/a/img")
            ).getAttribute("title") + "\", ";
        }
        similars = similars.substring(0, similars.length() - 2); // removing extra comma and space
        return similars;
    }

    private int parseReviewCount(String s) {
        return Integer.parseInt(
                s.substring(
                        0, s.indexOf(" ")
                ).replaceAll(",", "")
        );
    }
}
