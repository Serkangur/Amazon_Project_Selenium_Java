package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;


import static constants.ConstantsHomePage.*;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }




    //Clicks the button to accept cookies.
    public void clickCookieAcceptButton(){
        clickToWebElement(cookieAcceptButton);
    }

    //Enters the given text into the search box.
    public void inputSearchBoxElement(String txt) {
        inputTextMethod(txt,searchInput);
    }

    //Clicks the search button to initiate the search process.
    public void clickSearchSubmitButton() {
        clickToWebElement(searchSubmitButton);
    }

    //Retrieves the title of the current page.
    public String getHomePageTitle(){
     return  driver.getTitle();
    }


}
