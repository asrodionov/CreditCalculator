package com.simbirsoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InitialDataPage {
    private final WebDriver driver;

    public InitialDataPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//tbody/tr[1]/td[2]/input[1]")
    private WebElement sumInput;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/input[1]")
    private WebElement rateInput;

    @FindBy(xpath = "//tbody/tr[3]/td[2]/input[1]")
    private WebElement yearsInput;

    @FindBy(xpath = "//tbody/tr[4]/td[2]/input[1]")
    private WebElement dateInput;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")
    private WebElement buttonCalculate;

    public ResultPage calculateCredit(String sum, String rate, String years, String date){
        sumInput.clear();
        sumInput.sendKeys(sum);
        rateInput.clear();
        rateInput.sendKeys(rate);
        yearsInput.clear();
        yearsInput.sendKeys(years);
        dateInput.clear();
        dateInput.sendKeys(date);
        buttonCalculate.click();
        return new ResultPage(driver);
    }
}
