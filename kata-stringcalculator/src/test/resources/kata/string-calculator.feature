Feature: String Calculator

  Requirements:

  Providing an empty string when calculating
  then the result is 0.

  Providing a single number when calculating
  then the result is the number as integer.

  Providing two comma separated numbers when calculating
  then the result is the sum of the numbers.

  Providing an unknown amount of comma separated numbers when calculating
  then the result is the sum of all numbers.

  Providing an input string contains a line break instead of comma as delimiter when calculating
  then the result is the sum of all numbers.

  Providing a delimiter is optionally defined on the first line like //; when calculating
  then the result is the sum of all numbers. (e.g. //;\n1;2 should return 3)

  Providing a negative number when calculating
  then throws an exception “negatives not allowed” - and the negative(s) that was passed.

  Providing numbers bigger than 1000 when calculating
  then such numbers should be ignored in the calculation.

  Providing delimiters of any length (“//[delimiter]\n”) when calculating
  then the result is the sum of the numbers. (e.g. “//[xx]\n1xx2xx3” should return 6)

  Providing multiple delimiters (“//[delim1][delim2]\n”) when calculating
  then the result is the sum of the numbers. (e.g. “//[x][y]\n1x2y3” should return 6)

  Providing multiple delimiters with variable length when calculating
  then the result is the sum of the numbers.

  Scenario: The calculator should return 0 if given an empty input string.
    Given the input string is empty
    When calculating the sum
    Then the result should be 0
