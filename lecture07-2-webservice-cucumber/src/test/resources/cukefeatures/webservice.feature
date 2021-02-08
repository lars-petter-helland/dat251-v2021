Feature: WebService for Norwegian postal addresses
  As an eager writer of post cards
  I want a service that gives me postal addresses
  So that I don't need to look it up manually each time

  @first-scenario
  Scenario: Get a postal address
    Given the service is up and running
    When I request the postal addresses with the postal number 5353
    Then the poststed should be STRAUME
    And the kommune should be FJELL
   
  Scenario: Get a postal address
    Given the service is up and running
    When I request the postal addresses with the postal number 7010
    Then the poststed should be TRONDHEIM
    And the kommune should be TRONDHEIM
   
  @last-scenario
  Scenario: Get another postal address
    Given the service is up and running
    When I request the postal addresses with the postal number 5005
    Then the poststed should be BERGEN
    And the kommune should be BERGEN