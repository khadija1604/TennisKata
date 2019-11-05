package kataTennisGame.com.tdd;

import java.util.Arrays;
import java.util.List;

public class Player {
	private String playerName;
	private int score;
	public static final List<String> possibleScores = Arrays.asList("0", "15", "30", "40");

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	// wen need just getter to get player name
	public String getPlayerName() {
		return playerName;
	}

	// the score change when player win a point
	public void winPoint() {
		this.score = this.score + 1;
	}

	public String getCorrespondingScoreValue() {
		return this.possibleScores.get(score);
	}

	public String getWinner() {
		return this.playerName + " is the winner";
	}

	public String getAdvantage() {
		return this.playerName + " take the advantage";
	}
}
