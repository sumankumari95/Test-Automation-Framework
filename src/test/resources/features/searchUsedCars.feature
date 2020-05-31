@SearchUsedCars
Feature: Acceptance testing to validate search used cars page is working

  Scenario: Validate search used cars page
    Given I launch the home page "https://www.carsguide.com.au/" of CarsGuide website
    When I navigate to search used cars page
    And I provide used car details to find my next car
    Then I get list of used cars as per the search
