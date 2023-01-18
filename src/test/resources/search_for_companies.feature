Feature:  Calling search API


  Scenario: Searching for company . happy flow

    Given I search for for company I expect this result
      | type | value  | allowedOperations | description                      |
      | name | string | CONTAINS,EXACT    | Name of the company or freelance |