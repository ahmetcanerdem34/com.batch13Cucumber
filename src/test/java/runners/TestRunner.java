package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target\\cucumber-raporlar.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},
        // 1- bu notasyonun gorevi feature dosyalarim ile stepdefinition dosyalarini birlestirmek
        features="src/test/resources/features",
        glue="stepdefinitions",
        // boylece package'lari birbirine bagliyoruz
        // bu iki paket altinda kactane class olursa olsun,
        // herhangi bir class'da yazilan her adim diger class'lardaki adimlarla uyusursa yeni adim olusturmaya gerek kalmaz

        tags="@smoke", // work in progress
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
public class TestRunner {


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
}