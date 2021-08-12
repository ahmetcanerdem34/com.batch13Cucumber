package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGridStepDefinitons {
    WebDriver driver;
    @Given("Kullanici Google anasayfaya Selenium Grid Chrome kullanarak gidiyor")
    public void kullaniciGoogleAnasayfayaSeleniumGridChromeKullanarakGidiyor() throws MalformedURLException {
        // DesiredCapabilities Class'ından bir obje üretin
        // Node'umuzun isletim sistemi ve browser ayarini yapmak icin DesiredCapabilities kullaniyoruz.
        DesiredCapabilities cap = new DesiredCapabilities();
        // cap objesinden browser ve isletim sistemi ayarlamalarini yapin
        //cap.setPlatform(Platform.MAC); // Mac kullanicilari icin
        //cap.setPlatform(Platform.WINDOWS); // Windows kullanicilari icin
        cap.setPlatform(Platform.ANY); // Hepsi icin calisir.
        cap.setBrowserName("chrome"); // Browser'imizi ayarlar
        // DesiredCapabilities ayarlarini ChromeOptions ile merge edin
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        // Driver'a RemoteWebDriver Class'ından atama yapın ve Hub url olusturun
        // Hub url olusturma url / wd / hub
        String hubUrl = "http://192.168.2.56:4444/wd/hub";
        URL a = new URL(hubUrl);
        driver = new RemoteWebDriver(a, options);

        //driver = new RemoteWebDriver(new URL(hubUrl), options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }
    @And("Kullanici Google title dogrulamasini chrome node undan yapar")
    public void kullaniciGoogleTitleDogrulamasiniChromeNodeUndanYapar() {
    }
    @Given("Kullanici Google anasayfaya Selenium Grid Firefox kullanarak gidiyor")
    public void kullaniciGoogleAnasayfayaSeleniumGridFirefoxKullanarakGidiyor() {
    }
    @And("Kullanici Google title dogrulamasini firefox node undan yapar")
    public void kullaniciGoogleTitleDogrulamasiniFirefoxNodeUndanYapar() {
    }
}