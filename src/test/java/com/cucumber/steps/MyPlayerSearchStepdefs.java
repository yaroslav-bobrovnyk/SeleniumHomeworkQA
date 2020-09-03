package com.cucumber.steps;

import static com.cucumber.driver.DriverManager.getWebDriver;

import com.cucumber.pages.HomePage;
import com.cucumber.pages.PlayersPage;
import config.ServerConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aeonbits.owner.ConfigFactory;

public class MyPlayerSearchStepdefs {

    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
    HomePage homePage=new HomePage(getWebDriver());
    PlayersPage playersPage=new PlayersPage(getWebDriver());

    @Given("I navigate to the PGA Tour main page")
    public void iNavigateToThePGATourMainPage() {
        getWebDriver().navigate().to(cfg.url());
    }

    @When("I click on the Players button on the Global Navigation menu")
    public void iClickOnThePlayersButtonOnTheGlobalNavigationMenu() {
        homePage.playersButtonClick();
    }

    @And("Type the {string} in the search field")
    public void typeThePlayerNameInTheSearchField(String playerName) {
        playersPage.searchPlayer(playerName);
    }

    @Then("I should see the players with result matching {string}")
    public void iShouldSeeThePlayerAvatar(String playerName) {
        if (playersPage.playerCardSearchResult()){
            playersPage.searchResult(playerName);
        }else {
            playersPage.noResultMessageValidation();
        }
    }
}
