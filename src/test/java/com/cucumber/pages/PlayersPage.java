package com.cucumber.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlayersPage {
    private static Logger logger = LogManager.getLogger(PlayersPage.class);
    WebDriver driver;

    @FindBy(css = ".directory-search .input-field")
    WebElement searchField;

    @FindBy(css = "input.input-field")
    WebElement searchSubmit;

    @FindBy(css = "div#searchResults .player-card")
    WebElement playerCard;

    @FindBy(css = "#searchResults .no-results")
    WebElement noResultMessage;

    public PlayersPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public PlayersPage searchPlayer(String playerName) {
        searchField.sendKeys(playerName);
        searchField.sendKeys(Keys.RETURN);
        return this;
    }

    public boolean playerCardSearchResult(){
       try{
           playerCard.isDisplayed();
           return true;
       }catch (org.openqa.selenium.NoSuchElementException e){
           return false;
       }
    }

    public void searchResult(String playerName){
        logger.info("Was found "+driver.
                findElements(By.cssSelector("div#searchResults .player-card")).
                size()+" result matching "+playerName);
    }

    public void noResultMessageValidation(){
        if (noResultMessage.isDisplayed()) {
            logger.info("'No result' message is displayed");
        }
    }
    
}
