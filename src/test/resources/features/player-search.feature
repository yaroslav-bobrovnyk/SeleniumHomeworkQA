Feature: Player search validation

  @chrome
  Scenario Outline: As a user I can find a player
    Given I navigate to the PGA Tour main page
    When I click on the Players button on the Global Navigation menu
    And Type the '<playerName>' in the search field
    Then I should see the players with result matching '<playerName>'
    Examples:
      | playerName |
      | Tiger      |
      | ix.co      |

  @firefox
  Scenario Outline: As a user I can find a player
    Given I navigate to the PGA Tour main page
    When I click on the Players button on the Global Navigation menu
    And Type the '<playerName>' in the search field
    Then I should see the players with result matching '<playerName>'
    Examples:
      | playerName |
      | Tiger      |
      | ix.co      |
  @safari
  Scenario Outline: As a user I can find a player
    Given I navigate to the PGA Tour main page
    When I click on the Players button on the Global Navigation menu
    And Type the '<playerName>' in the search field
    Then I should see the players with result matching '<playerName>'
    Examples:
      | playerName |
      | Tiger      |
      | ix.co      |
  @ie
  Scenario Outline: As a user I can find a player
    Given I navigate to the PGA Tour main page
    When I click on the Players button on the Global Navigation menu
    And Type the '<playerName>' in the search field
    Then I should see the players with result matching '<playerName>'
    Examples:
      | playerName |
      | Tiger      |
      | ix.co      |