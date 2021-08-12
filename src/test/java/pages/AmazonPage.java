package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElementi;

    @FindBy(partialLinkText = "Today")
    public WebElement todaysDealsButonu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-none']/h2/a/span")
    public WebElement aramaSonucuIlkUrunIsmiElementi;

}