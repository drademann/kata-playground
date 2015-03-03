Feature: Calculating the sum of numbers contained in string.

  Scenario: The calculator should return 0 if given an empty input string.
    Given a string calculator
    When getting an empty string
    Then it should return 0
