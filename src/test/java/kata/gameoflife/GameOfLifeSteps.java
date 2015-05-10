package kata.gameoflife;

import cucumber.api.java.en.*;
import kata.gameoflife.support.*;

public class GameOfLifeSteps {

	KnowsGameOfLifeDomain gameOfLifeDomain;

	public GameOfLifeSteps(KnowsGameOfLifeDomain gameOfLifeDomain) {
		this.gameOfLifeDomain = gameOfLifeDomain;
	}

	@Given("^a live cell$")
	public void givenLiveCell() {
		// TODO implement or write some other step
	}

	@When("^having (\\d+) life neighbour\\(s\\)$")
	public void whenHavingLifeNeighbours(int numberOfLiveNeighbours) throws Throwable {
		// TODO implement or write some other step
	}

	@Then("^the cell dies$")
	public void thenCellDies() {
		// TODO implement or write some other step
	}
}
