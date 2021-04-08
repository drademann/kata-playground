package kata.tennis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * Requirements
 *
 * Write a game scorer for tennis. The implementation should provide
 * readable output like
 * “Love all.”
 * “Fifteen, Love.”
 * “Thirty, Forty.”
 * “<Player> wins.”
 * “Deuce.”
 * “Advantage, <Player>.”
 */
final class TennisGameTest {

    private String gameAtScore(int scorePlayer1, int scorePlayer2) {
        var game = new TennisGame("Steffi", "Boris");
        for (int i = 0; i < scorePlayer1; i++) game.player("Steffi").scores();
        for (int i = 0; i < scorePlayer2; i++) game.player("Boris").scores();
        return game.score();
    }

    @Test
    void givenNewGame_shouldScoreBe_Deuce() {
        assertThat(gameAtScore(0, 0)).isEqualTo("Love all.");
    }

    @Test
    void givenPlayer1Scores_shouldScoreBe_FifteenLove() {
        assertThat(gameAtScore(1, 0)).isEqualTo("Fifteen, Love.");
    }

    @Test
    void givenPlayer2Scores_shouldScoreBe_LoveFifteen() {
        assertThat(gameAtScore(0, 1)).isEqualTo("Love, Fifteen.");
    }

    @Test
    void givenBothScoreOnce_shouldScoreBe_FifteenAll() {
        assertThat(gameAtScore(1, 1)).isEqualTo("Fifteen all.");
    }

    @Test
    void givenPlayer1ScoresTwice_shouldScoreBe_ThirtyLove() {
        assertThat(gameAtScore(2, 0)).isEqualTo("Thirty, Love.");
    }

    @Test
    void givenPlayer1ScoresThreeTimes_shouldScoreBe_Player1Wins() {
        assertThat(gameAtScore(4, 0)).isEqualTo("Steffi wins.");
    }

    @Test
    void givenPlayer2ScoresThreeTimes_shouldScoreBe_Player2Wins() {
        assertThat(gameAtScore(0, 4)).isEqualTo("Boris wins.");
    }

    @Test
    void givenBothAt40_shouldScoreBe_Deuce() {
        assertThat(gameAtScore(3, 3)).isEqualTo("Deuce.");
    }

    @Test
    void givenPlayer1Advantage_shouldScoreBe_AdvantagePlayer1() {
        assertThat(gameAtScore(4, 3)).isEqualTo("Advantage, Steffi.");
    }

    @Test
    void givenPlayer2Advantage_shouldScoreBe_AdvantagePlayer2() {
        assertThat(gameAtScore(3, 4)).isEqualTo("Advantage, Boris.");
    }

    @Test
    void givenPlayer1ScoresAfterAdvantage_shouldWin() {
        assertThat(gameAtScore(5, 3)).isEqualTo("Steffi wins.");
    }

    @Test
    void givenPlayer2ScoresAfterAdvantage_shouldWin() {
        assertThat(gameAtScore(3, 5)).isEqualTo("Boris wins.");
    }

    @Test
    void givenPlayer1and2_meetAfterAdvantage_shouldScoreBeDeuceAgain() {
        assertThat(gameAtScore(5, 5)).isEqualTo("Deuce.");
    }

}
