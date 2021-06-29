package com.simbirsoft.test;

import com.simbirsoft.data.DataHelper;
import com.simbirsoft.pages.InitialDataPage;
import com.simbirsoft.pages.ResultPage;
import io.qameta.allure.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CreditCalculateTest {
    WebDriver driver;
    String nodeURL;

    @BeforeClass()
    public void setUp() throws MalformedURLException {
        nodeURL = "http://192.168.0.102:5559/wd/hub";
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Feature(value = "Ипотечный калькулятор")
    @Story(value = "Проверка расчета ежемесячного платежа")
    @Test(dataProvider = "getRateCredit",dataProviderClass = DataHelper.class)
    void shouldCalculateMonthlyPayment(String rate, String expected) {
        driver.get("https://calculator.ru.com/");
        InitialDataPage initialDataPage = new InitialDataPage(driver);
        ResultPage resultPage = initialDataPage.calculateCredit(DataHelper.getSum(), rate, DataHelper.getYears(), DataHelper.getDate());
        assertEquals(resultPage.getMonthlyPayment(), expected);
    }
}
