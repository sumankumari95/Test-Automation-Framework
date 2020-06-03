@SearchUsedCars
Feature: Acceptance testing to validate search used cars page is working

  Scenario Outline: Validate search used cars page
    Given I launch the home page "https://www.carsguide.com.au/" of CarsGuide website
    When I navigate to search used cars page
    And I provide used car details to find my next car "<make>" "<model>" "<location>" "<price>"
    Then I get list of used cars as per the search

    @testdata1
    Examples: 
      | make | model | location  | price |
      | Audi | A4    | ACT - All | 50000 |

    @testdata2
    Examples: 
      | make | model     | location | price |
      | Jeep | Any Model | NT - All | 30000 |
