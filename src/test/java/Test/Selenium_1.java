package Test;
import Driver_setup.driver_setup;
import Pages.getting_soaps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class Selenium_1 extends driver_setup {
    @Test
    public void selenium_test() throws InterruptedException {
        String title = driver.getTitle();
        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Sofas & Recliners')]"));
        WebElement element2 = driver.findElement(By.xpath("//span[contains(text(),'1 Seater Recliners')]"));
        action.moveToElement(element).pause(Duration.ofSeconds(2)).moveToElement(element2).click().perform();
        wait.until(ExpectedConditions.invisibilityOfAllElements());
        WebElement price = driver.findElement(By.xpath("//div[contains(text(),'Price')]"));
        WebElement drag_btn = driver.findElement(By.xpath("//div[@class='noUi-handle noUi-handle-lower']"));
        WebElement close = driver.findElement(By.xpath("//a[@class='close-reveal-modal hide-mobile']"));
        wait.until(ExpectedConditions.visibilityOf(close));
        close.click();
        action.moveToElement(price).pause(Duration.ofSeconds(2)).moveToElement(drag_btn).pause(Duration.ofSeconds(2)).clickAndHold().moveByOffset(36, 0).pause(Duration.ofSeconds(2)).release().perform();
        wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//li[@class='product psticker']"))));
        List<WebElement> arr = new ArrayList<>();
        arr = driver.findElements(By.xpath("//div[@class='price-number']"));
        List<WebElement> all_names = driver.findElements(By.xpath("//span[@class='name']"));
        List<String> names = new ArrayList<>();
        List<String> prices = new ArrayList<>();
        for (WebElement webElement : arr) {
            String str = webElement.getText();
            String[] arr1 = str.split(" ");
            if (arr1.length == 2) {
                prices.add(arr1[1]);
            } else {
                prices.add(arr1[0]);
            }
        }
        for (WebElement name_element : all_names) {
            String s = name_element.getText();
            names.add(s);
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
            System.out.println(prices.get(i));
        }
    }
//        Thread.sleep(4000);
//        getting_soaps obj = new getting_soaps(driver);
//        obj.get_sofas_recliners();

}


