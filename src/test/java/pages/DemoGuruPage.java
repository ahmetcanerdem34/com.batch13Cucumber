package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoGuruPage {

    public DemoGuruPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
   //Find by ile locate yaparsam sabit olur, dinamik yapmak için method olmalı
    //return ile step definition a değer döndürelim, oda string olamalı
    //parametresi de satır ve sutun sayısı olduğu ıçin int olmalı
    public String istenenHucreBilgisiniDondur(int satirNo,int sutunNo){

        String istenenHucredekiYazi="";
        //dinamik olmayan xpath //tbody//tr[2]//td[2]
        //dinamik olması için aldığımız xpath de 2 olan yerleri satırno ve sutunno parametreleriyle aynı olmalı
        //sabit ve değişken olan yerleri iyi belirlemeiyiz
        String dinamikXpath="//tbody//tr["+ satirNo+"]//td["+sutunNo+"]";

        //locate edelim
        istenenHucredekiYazi=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();

        //int gönderdik return ile bize string göndermiş olacak
        return istenenHucredekiYazi;
    }

}
