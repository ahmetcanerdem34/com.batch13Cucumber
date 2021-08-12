package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\cucumber-raporlar2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml"},
        // 1- bu notasyonun gorevi feature dosyalarim ile stepdefinition dosyalarini birlestirmek
        features="src/test/resources/features",
        glue="stepdefinitions",
        // boylece package'lari birbirine bagliyoruz
        // bu iki paket altinda kactane class olursa olsun,
        // herhangi bir class'da yazilan her adim diger class'lardaki adimlarla uyusursa yeni adim olusturmaya gerek kalmaz

         tags="@rapor2", // work in progress
        // 2-  @ testNG'degi group gibi calisir
        // eger sadece 1 Feature veya 1 Scenario calistiracaksak, gidip feature dosyasindan calistirabiliriz
        // birden fazla Feature veya Scenario calistirmak istedigimizde
        // calistiracagimiz F veya S 'lara ortak bir tag atamamiz ve bu tag'i
        // runner'da belirtmemiz gerekir
        // and dendiginde yazilan taglarin tamamina sahip olanlar calistirilir
        // or dedigimde yazilan taglardan herhangi birine veya daha fazlasina sahip olanlar calisir
        // eger tum test case'leri calistirmak isterseniz tag'i yorum haline getirmeniz yeterli olur

        dryRun=false
        // true oldugunda test case'leri calistirmayi denemeden sadece eksik olan step'leri bana verir
        // false oldugunda test case'leri calistirmayi dener eksik step' bulursa onu rapor eder
        //
)
public class TestRunner2 {


// Parallel Testing yapilirken ;
// Diger runner ile lokasyonlar ayni olursa , alacagimiz raporlari replace edeceginden ismini degistirdik.
    // cucumber-reports2.html" gibi
// Testleri esit sekilde bolup iki farkli browser'dan calistirmak icin , tag isimlerini runner class'larinda
// farkli yazip feature dosyalarini esit bolmemiz gerekecek.


    //paralel testing icin 2 runner classi olusturdum ve isim olarak TestRunner yazmaliyim
//html:target\cucumber2-raporlar.html gibi olanlar dosya, dosya isimlerini degistirmemiz lazim
//cunku ayri ayri rapor olmaz testrunnerla ayni oldugundan hangisi once biterse oburunun ustune katar
//o yuzden isimleri degistirelim
//taglari da boluyorum,paylastiriyorum yarisini rapor1 bunu rapor 2 yapiyorum
//pom umuza 2 tane eklenti ekliyoruz
//dependencylerin disina plugins ekledik(failsafe surefile)
//sonra terminal kismina mvn clean verify yaz ve enter a bas
//daha sonra daha guzel olasi icin hocanin plugin i ekle ve bukadar:
    /*
1- Paralel testin tum testlerimizi hep birlikte execute etmek istedigiimizde zamani azaltmak icin kullanilir. Paralel testing’de istedigimiz kadar browser’i ayni anda calistirabiliriz
2-  Ilk yapmam gereken paralel calismasini istedigim browser sayisinca runner olusturmak
3- Runner class’larinin ismi TestRunner icermelidir. Farkli bir isim istiyorsak sureFire plugin’inden calistirilacak runner’larin isminde gecen ortak kismi yazmaliyiz
4- Calistirmak istedigimiz tum testleri paralel calistiracagimiz browser sayisina gore tag’larla gruplandiririz.
5- pom.xml’de dependencies tagi bittikten sonra icice build, plugins taglarini acalim. Plugins taglari icinde 2 tane plugin ekleriz
    - failsafe plugini testimiz basarisiz olsa da paralel testing devam ettirir
    - sureFire bu plugin de paralel calistirma ayarlari yapilir
6- Daha guzel ve gelismis bir rapor almak icin pom.xml’e maven-cucumber-reporting plugini eklenir
7- Plugin’lerin devreye girebilmesi icin, testlerimiz runner class’dan degil, IntelliJ terminal’den calistirilmalidir.
8- Terminal’den runnerlari calistirmak icin mvn clean verify yazmaliyiz
     */



}