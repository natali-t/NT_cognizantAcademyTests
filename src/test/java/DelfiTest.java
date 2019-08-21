//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//public class DelfiTest {
//
//    private final By ACCEPT_COOKIE = By.xpath(".//button[@id = 'cookiePolicyAccept']"));
//    private final String URL = ("https://www.delfi.lv");
//    private final By ARTICLES = By.xpath("")
//
//
//    @Test
//    public void firstDelfiTest() {
//        System.setProperty("webdriver.chrome.driver", "/Users/natali/Development/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
////DELFI
//        driver.get(URL);
//        driver.findElement(ACCEPT_COOKIE).click();
//
//        List<WebElement> articles = driver.findElements(TABS);
//
////        List<WebElement> articles = driver.findElements(ARTICLES);
////        for (int i = 0; i < articles.size(); i++) {
////            String articleText = articles.get(i).getText();
////            System.out.println(articleText);
//
//        }
//
//        String text = driver.findElement(By.xpath(".//span[contains(text(), 'Modeļu jaunumi')]")).getText();
//        Assertions.assertEquals(text, "Modeļu jaunumi", "Text is not equal");
//
////        String text = driver.findElement(By.xpath("(.//h1[contains(text(), 'Valsts austrumos')])[1]")).getText();
////        //String text = driver.findElement(By.xpath(".//*[@class='text-size-19 text-size-md-22 mb-0 mt-2 headline__title']")).getText();
////
////        driver.findElement(By.xpath("(.//h1[contains(text(), 'Valsts austrumos')])[1]")).click();
////        //Assertions.assertTrue(text.contains("Valsts austrumos"), "Text is not equal");
//////        Assertions.assertEquals(text, "Valsts austrumos", "Text is not equal");
//
//
//////        PRESS.LV
////        driver.get("https://www.press.lv");
////
////        driver.findElement(By.xpath(".//button[@class='banner--close']")).click();
////
////        //driver.findElement(By.xpath("")).click();
////        //a[@href='http://www.press.lv/post/eto-zhe-astronomicheskaya-summa-gosti-iz-anglii-udivilis-rastsenkam-v-latvijskom-taksi/']
////        //String text = driver.findElement(By.xpath(""))
//
//        driver.quit();
//
//    }
//}
//


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiTest {
    private final Logger LOGGER = (Logger) LogManager.getLogger(DelfiTest.class);
    private final By COOKIE_POLICY = By.xpath(".//button[@id = 'cookiePolicyAccept']");
    private final By ARTICLES = By.xpath(".//h1[@class = 'text-size-16 text-size-md-19 mb-0 mt-2 headline__title']");

    @Test
    public void firstDelfiTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/natali/Development/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening chrome browser");
        driver.get("https://www.delfi.lv");

        LOGGER.info("Clicking on cookie btn");
        driver.findElement(COOKIE_POLICY).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfAllElements());

        List<WebElement> articleList = driver.findElements(ARTICLES);
        for (int i = 0; i < articleList.size(); i++) {
            String article = articleList.get(i).getText();
            System.out.println(article);
        }

//        String text = driver.findElement(By.xpath(".//span[contains(text(), 'Modeļu jaunumi')]")).getText();
//        Assertions.assertEquals(text, "Modeļu jaunumi", "Text is not equal");

        driver.quit();
    }
}