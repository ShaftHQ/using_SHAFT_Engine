Feature: SHAFT Web GUI Template
    Scenario: Open Google Home, Search for "SHAFT_Engine", then validate that the result stats is not empty
      Given I Open the target browser
      When I Navigate to Google Homepage
      And I Search for "SHAFT_Engine"
      Then the result stats will show some data (will not be empty)
