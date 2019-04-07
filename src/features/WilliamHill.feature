Feature: William Hill game search - William Hill Vegas
  Background:
    Given user has navigated to William Hill Vegas
    When searching for Mayfair Roulette
    Then details of Mayfair Roulette are shown after hovering on the widget

  Scenario: User has to login to play:
    When Play Now button is clicked
    Then Login modal window is displayed to the user