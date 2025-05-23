package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static constants.ConstantsProductPage.*;
import static constants.ConstantsSearchResultsPage.cartCountValue;


public class ProductPage extends BasePage {
    public String cartCount = "1"; //Expected cart item count after adding a product
    public String savedProductName; //Stores the name of the selected product for later verification

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Locates the "Add to Cart" button to verify that we are on the product page.
    public WebElement isAddToCartPresent() {
        return find(addToCart);
    }

    // Clicks the "Add to Cart" button and saves the product name for later verification.
    // Waits until "nav-cart-1" appears in the cart count class.
    public void clickAddToCart() {
        saveProductTitle();
        clickToWebElement(addToCart);
        wait.until(ExpectedConditions.attributeContains(find(cartCountValue), "class", "nav-cart-1"));
        delay(3);
    }

    //Retrieves the current cart item count to verify if the product was added.
    public String isProductAdded() {
        return getTextMethod(cartCountValue);
    }


    //Retrieves the product title text.
    public String getProductTitle() {
        return getTextMethod(productTitle);
    }

    //Saves the product title for later validation (e.g., on the cart page)
    public void saveProductTitle(){
        this.savedProductName = getProductTitle();
    }

    //Clicks on the cart icon to navigate to the cart page.
    public void clickCartIcon(){
        clickToWebElement(cartCountValue);
    }


}
