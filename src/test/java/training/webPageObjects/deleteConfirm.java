package training.webPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class deleteConfirm {

    protected WebDriver driver;
    public deleteConfirm(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, 10), this);
    }
    @FindBy(xpath = "//a[text()[contains(.,'Booked Itinerary')]]")
    public WebElement ItineraryLink;


    @FindBy(xpath ="//*[@id=\"search_result_error\"]")
    public WebElement DeleteConfirmation;
}
