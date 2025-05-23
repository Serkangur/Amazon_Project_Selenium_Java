package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    //Finds and returns a WebElement if it exists in the DOM.
    public WebElement find(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Retrieves the current page URL.
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    //Waits until the WebElement is clickable and then clicks on it using the provided locator.
    public  void clickToWebElement (By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    //Inputs the given text into a text field located by the provided locator.
    public void inputTextMethod(String input,By locator) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(input);
    }

    // Waits until the WebElement located by the given locator is visible on the page.
    public WebElement waitElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    // Retrieves the text from a WebElement.
    //If the text is longer than 28 characters, trims the last 28 characters.
    // This is used to match product names in the cart.
    public String getTextMethod(By locator) {
        String text = waitElement(locator).getText();
        if (text.length() > 28) {
            text = text.substring(0, text.length() - 28);
        }
        return text;
    }



    //Pauses execution for the specified time.
    public static void delay(int millisecond){
        try {
            Thread.sleep(millisecond);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



}
