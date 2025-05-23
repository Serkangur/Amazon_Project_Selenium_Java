package pages;

import base.BasePage;

import org.openqa.selenium.WebDriver;


import static constants.ConstantsSearchResultsPage.*;

public class SearchResultsPage extends BasePage {
    public String searchWord = "samsung";
    public String pageCount = "page=2";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    //Retrieves the breadcrumb text from the search results page.
    public String getBreadcrumbText() {
        return getTextMethod(breadCrumbText);
    }

    //Clicks on the second page in the pagination.
    public void goToSecondPage() {
        clickToWebElement(secondPage);
    }

    //Clicks on the third product in the search results.
    public void selectThirdProduct() {
        clickToWebElement(thirdProduct);
    }

}




