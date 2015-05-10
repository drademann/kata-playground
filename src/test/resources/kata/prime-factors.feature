Feature: Prime Factor Generator

  Scenario Outline: The generator should return the prime factors of an integer value.
    Given I have an integer value of <n>
    When generating the prime factors of the integer value
    Then the resulting prime factors should be <factors>
    Examples:
      | n | factors |
      | 1 |         |