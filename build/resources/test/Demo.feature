@Demo1
Feature: Notepad App Actions

  Scenario: Open the Notepad App
    Given user opens the Notepad application

  Scenario: Create and Modify Text Notes
    When user creates five text notes
    And user change the color of each note
    And user print the creation time of each note

  Scenario: Change the Day of the Week
    When user change the first day of the week


  Scenario: Search for a Text Note
    When user search for the text note Text3
    Then user verify the search result

  Scenario: Delete Text Notes and Archive Text Note
    And user delete text notes 2 and 4
    And user archive the first text note


  Scenario: Verify Delete and Archive Notes
    Then user verifies the deleted notes
    Then user verify the archived note




