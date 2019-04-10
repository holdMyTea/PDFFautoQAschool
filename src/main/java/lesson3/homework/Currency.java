package lesson3.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import templates.BaseTest;

public class Currency extends BaseTest {

    @Test
    private void test() {
        Bank[] banks = {
                parsePrivat(),
                parseUkrSib(),
                parseUniversal(),
                parseOschad(),
                parseNBU()
        };

        double totalBuying=0, totalSelling=0;
        double minimumBuying=Double.MAX_VALUE, maximumSelling=Double.MIN_VALUE;
        Bank minBuyBank = null, maxSellBank = null;
        for(Bank b: banks){
            totalBuying += b.getBuyingRate();
            totalSelling += b.getSellingRate();

            if(b.getBuyingRate() < minimumBuying) {
                minimumBuying = b.getBuyingRate();
                minBuyBank = b;
            }
            if(b.getSellingRate() > maximumSelling) {
                maximumSelling = b.getSellingRate();
                maxSellBank = b;
            }
        }

        System.out.println("Mean buying rate: " + (totalBuying / banks.length));
        System.out.println("Mean selling rate: " + (totalSelling / banks.length));
        System.out.println(minBuyBank.getName() + " buys USD at the lowest rate of " + minBuyBank.getBuyingRate());
        System.out.println(maxSellBank.getName() + " sells USD at the highest rate of " + maxSellBank.getBuyingRate());
    }

    private Bank parsePrivat() {
        this.driver.get("https://www.privat24.ua/");
        String rates = driver.findElement(
                By.xpath("//div[@class='section-content rate']")
        ).getText();

        double buyingRate = Double.parseDouble(rates.substring(0,rates.indexOf(" ")));
        double sellingRate = Double.parseDouble(rates.substring(rates.lastIndexOf(" ")));

        return new Bank("Privat",buyingRate,sellingRate);
    }

    private Bank parseUkrSib() {
        this.driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");

        WebElement container = driver.findElement(
                By.xpath("//table[@class='currency__table']/tbody")
        );

        double buyingRate = Double.parseDouble(
                container.findElement(
                        By.xpath(".//td[2]")
                ).getText());
        double sellingRate = Double.parseDouble(
                container.findElement(
                        By.xpath(".//td[3]")
                ).getText());
        return new Bank("UkrSib",buyingRate,sellingRate);
    }

    private Bank parseUniversal() {
        this.driver.get("https://www.universalbank.com.ua/");

        double buyingRate = Double.parseDouble(
                driver.findElement(
                        By.xpath("//tbody/tr[2]//td[2]")
                ).getText()
        );

        double sellingRate = Double.parseDouble(
                driver.findElement(
                        By.xpath("//tbody/tr[2]//td[3]")
                ).getText()
        );

        return new Bank("Universal",buyingRate,sellingRate);
    }

    private Bank parseOschad(){
        this.driver.get("https://www.oschadbank.ua/ua");

        double buyingRate = Double.parseDouble(
                driver.findElement(
                        By.xpath("//strong[@class='buy-USD']")
                ).getText()
        );

        double sellingRate = Double.parseDouble(
                driver.findElement(
                        By.xpath("//strong[@class='buy-USD']")
                ).getText()
        );

        return new Bank("Oschad",buyingRate,sellingRate);
    }

    private Bank parseNBU(){
        this.driver.get("https://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");

        double rate;
        // damn NBU, can have either big badass table for a 100 currencies or a single row for USD
        // I hope there are no other versions of this table
        // if we were allowed to search by text I would use this instead:
        // //table[4]//td[.=840]/following-sibling::td[4]
        try {
            rate = Double.parseDouble(
                    driver.findElement(
                            By.xpath("//table[4]//tr[9]/td[5]")
                    ).getText()
            ) / 100;
        } catch (NoSuchElementException e) {
            rate = Double.parseDouble(
                    driver.findElement(
                            By.xpath("//table[4]//tr[2]/td[5]")
                    ).getText()
            ) / 100;
        }

        return new Bank("NBU",rate,rate);
    }
}

class Bank {
    private String name;
    private double buyingRate;
    private double sellingRate;

    Bank(String name, double buyingRate, double sellingRate) {
        this.name = name;
        this.buyingRate = buyingRate;
        this.sellingRate = sellingRate;
    }

    String getName() {
        return name;
    }

    double getBuyingRate() {
        return buyingRate;
    }

    double getSellingRate() {
        return sellingRate;
    }
}