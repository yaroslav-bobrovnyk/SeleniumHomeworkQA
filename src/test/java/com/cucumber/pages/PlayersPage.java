package com.cucumber.pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;


import java.util.List;

public class PlayersPage {
    private static Logger logger = LogManager.getLogger(PlayersPage.class);
    WebDriver driver;

    @FindBy(css = ".directory-search .input-field")
    WebElement searchField;

    @FindBy(css = "div#searchResults .player-card")
    WebElement playerCard;

    @FindBy(css = "#searchResults .no-results")
    WebElement noResultMessage;

    @FindBy(css = "div#searchResults .hidden-small .player-firstname")
    WebElement playerFirstName;

    @FindBy(css = "div#searchResults .hidden-small .player-surname")
    WebElement playerSurname;

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

    private String getPlayerName(){
        return playerFirstName.getText()+" "+playerSurname.getText();
    }

    public void jsonPathUsage()
    {
        RestAssured.baseURI = "https://www.pgatour.com/players/jcr:content/mainParsys/players_directory.players.json";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> allBooks = jsonPathEvaluator.getList("players.name");
        assertThat(allBooks.toString(), containsStringIgnoringCase(getPlayerName()));
    }

    
}
