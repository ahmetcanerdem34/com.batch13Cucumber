package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AmazonSeleniumGridStepDefinitions {

    // Bir WebDrivero object'i uret
    WebDriver driver;
    @Given("Kullanici Amazon anasayfaya Selenium Grid Chrome kullanarak gider")
    public void kullaniciAmazonAnasayfayaSeleniumGridChromeKullanarakGider() throws MalformedURLException {
        // 1. Adım DesiredCapabilities Class'ından bir object oluşturun
        DesiredCapabilities cap = new DesiredCapabilities();
        //2. Adım ürettiğiniz object'den gerekli ayarlamaları yapın -> Isletim sistemi, browser
        cap.setBrowserName("chrome");
        //cap.setPlatform(Platform.MAC); // Mac isletim sistemi icin
        cap.setPlatform(Platform.ANY); // Herhangi bir isletim sistemi icin
        //cap.setPlatform(Platform.WINDOWS); // Windows isletim sistemi icin
        // 3.Adım ChromeOptions object'i uretin ve cap ile merge edin
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        // 4. Adım Url olustur. url + /wd + /hub
        String hubUrl = "http://192.168.2.56:4456/wd/hub";
        // 5.Adım  bunun atamasini RemoteWebDriver ile yap
        // URL url = new URL();
        driver = new RemoteWebDriver(new URL(hubUrl), options);
        // Ayarlamalarimiz bitti artik kodlarimzi calistirabiliriz.
        driver.get("http://amazon.com");
    }
    @And("Kullanici Amazondan computer araması yapar")
    public void kullaniciAmazondanComputerAramasiYapar() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer" + Keys.ENTER);
    }
    @And("Kullanici ilk urune tiklar")
    public void kullaniciIlkUruneTiklar() {
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
    }
    @Given("Kullanici Amazon anasayfaya Selenium Grid Chrome kullanarak giderF")
    public void kullaniciAmazonAnasayfayaSeleniumGridChromeKullanarakGiderF() throws MalformedURLException {
        // 1. Adım DesiredCapabilities Class'ından bir object oluşturun
        DesiredCapabilities cap = new DesiredCapabilities();
        //2. Adım ürettiğiniz object'den gerekli ayarlamaları yapın -> Isletim sistemi, browser
        cap.setBrowserName("chrome");
        //cap.setPlatform(Platform.MAC); // Mac isletim sistemi icin
        cap.setPlatform(Platform.ANY); // Herhangi bir isletim sistemi icin
        //cap.setPlatform(Platform.WINDOWS); // Windows isletim sistemi icin
        // 3.Adım ChromeOptions object'i uretin ve cap ile merge edin
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        // 4. Adım Url olustur. url + /wd + /hub
        String hubUrl = "http://192.168.1.100:4456/wd/hub";
        // 5.Adım  bunun atamasini RemoteWebDriver ile yap
        // URL url = new URL();
        driver = new RemoteWebDriver(new URL(hubUrl), options);
        // Ayarlamalarimiz bitti artik kodlarimzi calistirabiliriz.
        driver.get("http://amazon.com");

    }
    @Given("Kullanici Amazondan computer araması yaparF")
    public void kullaniciAmazondanComputerAramasiYaparF() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Computer" + Keys.ENTER);
    }
    @Given("Kullanici ilk urune tiklarF")
    public void kullaniciIlkUruneTiklarF() {
        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
    }
}