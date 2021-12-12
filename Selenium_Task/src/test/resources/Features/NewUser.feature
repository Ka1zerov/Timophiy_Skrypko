Feature:
  Background:
    Given user is on login page
    When user enters the username and password
    And clicks on login button
    Then user is navigated to the homepage

  Scenario: adding new user
    Given user is on Users page
    When user clicks on add
    And enters <Name> <Username> <Password> <Confirmed Password>
    And clicks save
    Then user sees his new data on Users page

    When user clicks on [Username] field
    And click on Search button
    Then user sees his new data on Users page

    When user ticks his <Username>
    And clicks Delete button
    And clicks ok
    Then user sees his field is deleted on Users page






