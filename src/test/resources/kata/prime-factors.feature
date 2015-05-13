Feature: Prime Factor Generator

  Scenario: The generator should return no primes for an input value of 1.
    Given I have an integer value of 1
    When generating the prime factors of the integer value
    Then the generator should return no prime factors

  Scenario Outline: The generator should return the prime factors of an integer value.
    Given I have an integer value of <n>
    When generating the prime factors of the integer value
    Then the resulting prime factors should be <factors>
    Examples:
      | n | factors |
