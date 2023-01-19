Feature:  Calling search API


  Scenario: Searching for company . happy flow

    Given I search for for company I expect this result
      | id   | name  | description |
      | 1223 | test  | iets        |
      | 1234 | test1 | iets anders |