package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class getting_soaps {
    WebDriver driver;
    public getting_soaps(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//span[contains(text(),'Sofas & Recliners')]")
    WebElement Sofas_Recliners;
    @FindBy(xpath = "//span[contains(text(),'1 Seater Recliners')]")
    WebElement Seater_Recliners;
    @FindBy(xpath = "//div[contains(text(),'Price')]")
    WebElement Price_dropdown;
    @FindBy(xpath = "//div[@class='noUi-handle noUi-handle-lower']")
    WebElement Slider_bar;
    @FindBy(xpath = "//a[@class='close-reveal-modal hide-mobile']")
    WebElement close;
    @FindBy(xpath = "//div[@class='price-number']")
    List<WebElement> prices_web_element;
    @FindBy(xpath = "//span[@class='name']")
    List<WebElement> names_web_elements;
    Actions actions;
    WebDriverWait wait;
    public void get_sofas_recliners(){
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        actions.moveToElement(Sofas_Recliners).pause(Duration.ofSeconds(2)).moveToElement(Seater_Recliners).click().perform();
        wait.until(ExpectedConditions.visibilityOf(Price_dropdown));
    }

}
