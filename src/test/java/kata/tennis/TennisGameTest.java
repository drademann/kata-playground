package kata.tennis;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Requirements
 *
 * Write a game scorer for tennis. The implementation should provide
 * readable output like
 * "Love all."
 * "Fifteen, Love."
 * "Thirty, Forty."
 * "<Player Name> wins."
 * "Deuce."
 * "Advantage, <Player Name>."
 */
public class TennisGameTest {

    private String gameAtScore(int scorePlayer1, int scorePlayer2) {
        var game = new TennisGame("Steffi", "Boris");
        for (int i = 0; i < scorePlayer1; i++) game.player("Steffi").scores();
        for (int i = 0; i < scorePlayer2; i++) game.player("Boris").scores();
        return game.score();
    }

    @Test
    public void givenNewGame_shouldScoreBe_Deuce() {
        assertThat(gameAtScore(0, 0)).isEqualTo("Love all.");
    }

    @Test
    public void givenPlayer1Scores_shouldScoreBe_FifteenLove() {
        assertThat(gameAtScore(1, 0)).isEqualTo("Fifteen, Love.");
    }

    @Test
    public void givenPlayer2Scores_shouldScoreBe_LoveFifteen() {
        assertThat(gameAtScore(0, 1)).isEqualTo("Love, Fifteen.");
    }

    @Test
    public void givenBothScoreOnce_shouldScoreBe_FifteenAll() {
        assertThat(gameAtScore(1, 1)).isEqualTo("Fifteen all.");
    }

    @Test
    public void givenPlayer1ScoresTwice_shouldScoreBe_ThirtyLove() {
        assertThat(gameAtScore(2, 0)).isEqualTo("Thirty, Love.");
    }

    @Test
    public void givenPlayer1ScoresThreeTimes_shouldScoreBe_Player1Wins() {
        assertThat(gameAtScore(4, 0)).isEqualTo("Steffi wins.");
    }

    @Test
    public void givenPlayer2ScoresThreeTimes_shouldScoreBe_Player2Wins() {
        assertThat(gameAtScore(0, 4)).isEqualTo("Boris wins.");
    }

    @Test
    public void givenBothAt40_shouldScoreBe_Deuce() {
        assertThat(gameAtScore(3, 3)).isEqualTo("Deuce.");
    }

    @Test
    public void givenPlayer1Advantage_shouldScoreBe_AdvantagePlayer1() {
        assertThat(gameAtScore(4, 3)).isEqualTo("Advantage, Steffi.");
    }

    @Test
    public void givenPlayer2Advantage_shouldScoreBe_AdvantagePlayer2() {
        assertThat(gameAtScore(3, 4)).isEqualTo("Advantage, Boris.");
    }

    @Test
    public void givenPlayer1ScoresAfterAdvantage_shouldWin() {
        assertThat(gameAtScore(5, 3)).isEqualTo("Steffi wins.");
    }

    @Test
    public void givenPlayer2ScoresAfterAdvantage_shouldWin() {
        assertThat(gameAtScore(3, 5)).isEqualTo("Boris wins.");
    }

    @Test
    public void givenPlayer1and2_meetAfterAdvantage_shouldScoreBeDeuceAgain() {
        assertThat(gameAtScore(5, 5)).isEqualTo("Deuce.");
    }

}
