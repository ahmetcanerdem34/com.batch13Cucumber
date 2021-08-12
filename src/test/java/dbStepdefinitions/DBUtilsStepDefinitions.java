package dbStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class DBUtilsStepDefinitions {

    @Given("user DBU Koala Resort Hotels veritabanina baglanir")
    public void user_dbu_koala_resort_hotels_veritabanina_baglanir() {
        DBUtils.getConnection();
        //DBUtilis clası içindeki getConnection methodu içinde statement kısmını oluşturacak;
        //ondan yazmıyoruz

    }
    @Given("user DBU {string} tablosundaki {string} verilerini alir")
    public void user_dbu_tablosundaki_verilerini_alir(String table, String field) {

        String readQuery= "SELECT "+field+" FROM dbo."+table;//select name from table anlamında
        DBUtils.executeQuery(readQuery);

    }
    @Given("user DBU {string} sutunundaki verileri okur")
    public void user_dbu_sutunundaki_verileri_okur(String field) throws SQLException {
        //her şeyi DBUtils ten aldığımız için resultSet i de ordan alacağız
        DBUtils.getResultset().first();
        //1. satırdakini yazdıralım
        Object ilkSatirdakiObje=DBUtils.getResultset().getObject(field);
        System.out.println(ilkSatirdakiObje.toString());//225.0000

    }
    @And("user DBU {string} tablosundaki {string} verilerini listeler")
    public void userDBUTablosundakiVerileriniListeler(String tablo, String field) throws Exception {

        //DBUtils deki birkaç methodu daha çağırıp kullanallım


        int satirSayisi= DBUtils.getRowCount();
        DBUtils.getResultset().first();
        int satirNo=DBUtils.getResultset().getRow(); // bu method calistiginda resultset'in nerede oldugunu bilmemiz lazim
        // supriz olmamasi icin 1.satira yolladim

        //supriz olmaması iççin ilk satıra gönderiyoruz

        //tum listeyi getirelim while ile
        Object SatirdakiObje=null;
        while (satirNo<=satirSayisi){
            SatirdakiObje=DBUtils.getResultset().getObject(field);
            System.out.println(satirNo+". satirdaki email : " + SatirdakiObje.toString());
            DBUtils.getResultset().next();
            satirNo++;


        }


        //iteratır ı bir yere göndermem gerekir, boşlukta şuan




    }

    @Then("DBU IDHotel degeri {int} olan kaydin Email bilgisinin {string} oldugunu test eder")
    public void dbuIDHotelDegeriOlanKaydinEmailBilgisininOldugunuTestEder(int satirNo, String expectedDeger) throws SQLException {

        DBUtils.getResultset().absolute(2);
        String actualDeger=DBUtils.getResultset().getObject("Email").toString();

        Assert.assertEquals(expectedDeger,actualDeger);

    }

    @Then("DBU IDHotel degeri {int} olan kaydin Email degerini {string} yapar")
    public void dbuIDHotelDegeriOlanKaydinEmailDegeriniYapar(int satirNo, String yeniEmail) {

        String updateQuery="UPDATE dbo.tHOTELROOM SET Email='"+yeniEmail+"' WHERE IDHotel="+satirNo;
        DBUtils.executeQuery(updateQuery);
    }
}