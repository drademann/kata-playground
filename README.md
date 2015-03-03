# kata-stringcalc
Template to start with the test driven development
of [Roy Osherove's String Calculator Code Kata](http://osherove.com/tdd-kata-1/)
using Cucumber and Java.

- Do one task at a time. 
- Do it incrementally. 
- Solve requirements as simple as possible.
- Refactor after each successful test.
- This is about to learn TDD/BDD *"red, green, repeat"*

## String Calculator 

Implement a calculator method that takes a string and returns a number. 

1. Given an empty string when calculating then the result is 0.
2. Given a single number when calculating then the result is the number as integer.
3. Given two comma separated numbers when calculating then the result is the sum of the numbers.
4. Given an unknown amount of comma separated numbers when calculating then the result is the sum of all numbers.
5. Given an input string contains a line break instead of comma as delimiter when calculating then the result is the sum of all numbers.
6. Given a delimiter is optionally defined on the first line like `//;` when calculating then the result is the sum of all numbers. (e.g. `//;\n1;2` should return 3)
7. Given a negative number when calculating then throws an exception “negatives not allowed” - and the negative(s) that was passed.
8. Given numbers bigger than 1000 when calculating then such numbers should be ignored in the calculation.
9. Given delimiters of any length (`“//[delimiter]\n”`) when calculating then the result is the sum of the numbers. (e.g.  `“//[xx]\n1xx2xx3”` should return 6)
10. Given multiple delimiters (`“//[delim1][delim2]\n”`) when calculating then the result is the sum of the numbers. (e.g. `“//[x][y]\n1x2y3”` should return 6)
11. Given multiple delimiters with variable length when calculating then the result is the sum of the numbers.
 
The repeating pattern of *Given When Then* should help a little to get into Cucumber and to find reusable steps. 
