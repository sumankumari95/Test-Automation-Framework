@SearchCars
Feature: Acceptance testing to validate search new and used cars page is working

  Scenario: Validate search new and used cars page
    Given I launch the home page "https://www.carsguide.com.au/" of CarsGuide website
    When I navigate to search newandused cars page
    And I provide new and used car details to find my next car
    Then I get list of new and used cars as per the search
