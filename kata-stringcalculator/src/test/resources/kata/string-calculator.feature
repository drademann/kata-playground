Feature: String Calculator

  Scenario: The calculator should return 0 if given an empty input string.
    Given the input string is empty
    When calculating the sum
    Then the result should be 0