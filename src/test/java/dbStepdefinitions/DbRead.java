package dbStepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;

public class DbRead {
    //5- Database baglanmak icin stepdefinition class’inda connection olusturmamiz
    //gerekli. Ilk olarak instance olarak gerekli dediskenleri ve objeleri olusturalim
    //buradaki bilgilerin verilmesi gerekir
    //con

    //stat

    //Resultset
    //bu 3 adımda gerçekleşi sorgu
    String url= "jdbc:sqlserver://184.168.194.58:1433;databaseName=" +
            "ph17934033561_fhctripdb; user=fhctipdb_user;password=P2s@rt65";
    String username="fhctipdb_user";
    String password="P2s@rt65";
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @Given("kullanici Koala Resort Hotels veritabanina baglanir")
    public void kullanici_koala_resort_hotels_veritabanina_baglanir() throws SQLException {
        //6- Veritabanina baglanmak icin stepdefinition icinde connection’a deger atayalim
        connection= DriverManager.getConnection(url, username, password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

    }
    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        //7- QUERY leri calistirmak ve verileri almak icin statement’a deger atayalim

        //String olarak sql deki gibi query mizi yazalım
        String readQuery= "SELECT "+field+" FROM dbo."+table;//dinamik yapmak için bunu yaptık;
        // select name from table anlamında
        //database olusturan develeoperlar bazen
        //FROM YANINA dbo. koymuşlardır güvenlik için, dbo. olmazsa sorgu olmaz
        //bunu da devops veya developer ekibinin bize vermesi gerekir
        resultSet=statement.executeQuery(readQuery);
        //bu şekilde sorgu ile price sutunundaki sonuçlar resultSet e atandı

    }
    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String field) throws SQLException {
        //8- olusturdugumuz ve deger atadigimiz statement objesini kullanarak sorgumuzu yapalim

        //tum price verileri resultSet e eklendi
        resultSet.first();//resultSet i 1. row a (dataya) götürür önünde bekler
        //object olusturalım
        Object ilkSatirdakiObje=resultSet.getObject(field);//getObject te String seciyoruz cunku Price string
        System.out.println(ilkSatirdakiObje.toString());

        //bir sonraki veriyi görmek çin
        resultSet.next();
        Object ikinciSatirdakiObje=resultSet.getObject(field);
        System.out.println(ikinciSatirdakiObje.toString());

        //5. satıra gitmek için
        resultSet.absolute(5);//5 . satıra git
        Object besinciSatirdakiObje=resultSet.getObject(field);
        System.out.println(besinciSatirdakiObje.toString());

        //burdan next dersek 6. ya gider

        //tum listeyi yazdırmak istersek
        //once başa dönmem lazım hepsini yazdırmak istiyorsak, yoksa 5. den sonrakini yazdırır

        resultSet.absolute(0);//ilk satıra git

        System.out.println("*****Tum Liste*******");
        Object satirdakiObject=null;//local verable lara ilk atamayı yapmazsak kullanamayız
        while (resultSet.next()){//bir sonrakine geçer(71. 0 a gider burdan 1 den başlar) ve while ile bize true döndürür
            satirdakiObject=resultSet.getObject(field);//field index olarak geliyor
            System.out.println(satirdakiObject.toString());

        }

    }

}
