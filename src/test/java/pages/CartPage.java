package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constants.ConstantsCartPage.*;
import static constants.ConstantsSearchResultsPage.cartCountValue;

public class CartPage extends BasePage {
   public String cart_header = "Alışveriş Sepeti"; //Expected cart header text for verification
    public String cartCount = "0"; //Expected cart item count after deletion
    public CartPage(WebDriver driver) {
        super(driver);
    }

    //Retrieves the cart page header text to verify that the user is on the cart page.
    public String isOnCartPage(){
        return getTextMethod(cartPageHeader);
    }

    //Retrieves the product title text from the cart page.
    public String getCartPageProductTitle(){
        return getTextMethod(cartPageProductTitle);
    }

    // Clicks the delete button and waits until "nav-cart-0" appears in the cart count class.
    public void clickDeleteButton(){
        clickToWebElement(deleteButton);
        wait.until(ExpectedConditions.attributeContains(find(cartCountValue), "class", "nav-cart-0"));
    }

    //Retrieves the cart item count to verify if the product was removed.
    public String isProductDeleted(){
        return getTextMethod(cartCountValue);
    }

    //Clicks the Amazon logo to navigate back to the homepage.
    public void clickHomePageLogo(){
        clickToWebElement(AmazonLogo);
    }


}
