package kata.tennis;

public class TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame(String player1, String player2) {
        this.player1 = new Player(player1);
        this.player2 = new Player(player2);
    }

    public Player player(String name) {
        if (player1.name.equals(name))
            return player1;
        else if (player2.name.equals(name))
            return player2;
        else
            throw new IllegalArgumentException("unknown player first and surname " + name);
    }

    public String score() {
        if (player1.score >= 4) {
            if (player1.score - player2.score >= 2) {
                return player1.name + " wins.";
            } else if (player1.score == player2.score) {
                return "Deuce.";
            } else {
                return "Advantage, " + player1.name + ".";
            }
        }
        if (player2.score >= 4) {
            if (player2.score - player1.score >= 2) {
                return player2.name + " wins.";
            } else {
                return "Advantage, " + player2.name + ".";
            }
        }
        if (player1.score == 3 && player2.score == 3) {
            return "Deuce.";
        }
        if (player1.score == player2.score) {
            return translate(player1.score) + " all.";
        }
        return translate(player1.score) + ", " + translate(player2.score) + ".";
    }

    private String translate(int score) {
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalArgumentException("unexpected score " + score);
        };
    }

    static class Player {

        private String name;
        private int score;

        Player(String name) {
            this.name = name;
        }

        void scores() {
            score++;
        }

    }

}