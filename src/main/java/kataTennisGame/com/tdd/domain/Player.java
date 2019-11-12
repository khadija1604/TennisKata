package kataTennisGame.com.tdd.domain;

import java.util.Arrays;
import java.util.List;

public class Player {
	private String playerName;
	//game score
	private int score;
	private int setScore;
	private int tieBreakScore;
	
	public static final List<String> possibleScores = Arrays.asList("0", "15", "30", "40");

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}
	// we need just getter to get player name
	public String getPlayerName() {
		return playerName;
	}
	
	public int getSetScore() {
		return setScore;
	}

	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}
	
	public int getTieBreakScore() {
		return tieBreakScore;
	}

	public void setTieBreakScore(int tieBreakScore) {
		this.tieBreakScore = tieBreakScore;
	}

	// the score change when player win a point
	public void winPoint() {
		this.score++;
	}
	public String getCorrespondingScoreValue() {
		return this.possibleScores.get(score);
	}
    //get game winner
	public String getWinner() {
		return this.playerName + " is the winner";
	}

	public String getAdvantage() {
		return this.playerName + " take the advantage";
	}
   public void resetScore(){
	   this.score=0;
   }
   public String getSetWinner(){
	   return this.playerName + " is the winner of the set";
   }
   public int nextSetScore(){
	   return this.setScore++;
   }
}
