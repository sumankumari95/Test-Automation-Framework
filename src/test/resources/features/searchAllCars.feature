@SearchCars
Feature: Acceptance testing to validate search new and used cars page is working

  Scenario Outline: Validate search new and used cars page
    Given I launch the home page "https://www.carsguide.com.au/" of CarsGuide website
    When I navigate to search newandused cars page
    And I provide new and used car details to find my next car "<make>" "<model>" "<location>" "<price>"
    Then I get list of new and used cars as per the search

    @testdata1
    Examples: 
      | make | model | location  | price |
      | Audi | A4    | ACT - All | 35000 |

    @testdata2
    Examples: 
      | make | model     | location | price |
      | Jeep | Any Model | NT - All | 30000 |

    @testdata3
    Examples: 
      | make | model | location  | price |
      | BMW  | 116I  | NSW - All | 25000 |
