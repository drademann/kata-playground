Feature: Conways Game of Life

  Rules:
  1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
  2. Any live cell with two or three live neighbours lives on to the next generation.
  3. Any live cell with more than three live neighbours dies, as if by overcrowding.
  4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

  Scenario: Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    Given a live cell
    When having 1 life neighbour(s)
    Then the cell dies
