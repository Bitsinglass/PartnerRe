Feature: Open application in browser

  @tag1
  Scenario: open application
    Given user is on login page
    #When user enters username and Password
    When user enters Username and Password
    When user clicks login button
    Then user should be logged in
