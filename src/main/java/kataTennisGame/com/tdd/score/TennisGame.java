/**
 * 
 */
package kataTennisGame.com.tdd.score;

import java.util.HashMap;
import java.util.Map;

import kataTennisGame.com.tdd.domain.Player;

/**
 * @author khadija
 *
 */
public class TennisGame {
	/** Every game is composed of two players */
	private Player p1;
	private Player p2;
	private Player theSetWinner;
	private Player theMatchWinner;
	private final Map<String, Player> playersArray = new HashMap<String, Player>();

	/**
	 * @param player
	 *            p1
	 * @param player
	 *            p2
	 * 
	 */
	public TennisGame(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Player getTheSetWinner() {
		return theSetWinner;
	}

	public void setTheSetWinner(Player theSetWinner) {
		this.theSetWinner = theSetWinner;
	}

	public Player getTheMatchWinner() {
		return theMatchWinner;
	}

	public void setTheMatchWinner(Player theMatchWinner) {
		this.theMatchWinner = theMatchWinner;
	}

	/**
	 * get game scores
	 * 
	 * 
	 */
	public String getScore() {
		clearMatch();
		if (p1.getScore() >= 3 && p2.getScore() >= 3) {
			if (isDeuce(p1, p2))
				return "DEUCE";
			if (isAdvantage()) {
				float scoresDiff = p1.getScore() - p2.getScore();
				if (scoresDiff == 1)
					return p1.getAdvantage();
				if (scoresDiff == -1)
					return p2.getAdvantage();
				if (isGameWin()) {
					resetGameScore();
					if (scoresDiff >= 2) {
						manageSetScore(p1);
						return p1.getWinner();
					} else {
						manageSetScore(p2);
						return p2.getWinner();
					}
				}
			}
		}
		return p1.getCorrespondingScoreValue() + "-" + p2.getCorrespondingScoreValue();
	}

	/**
	 * manage set score
	 * 
	 * @param player
	 */
	private void manageSetScore(Player p) {
		int currentsetScore = p.getSetScore();
		Player theOpenent = getTheOpenent(p.getPlayerName());
		int currentTieBreakScore = p.getTieBreakScore();
		int newSetScore = nextScore(currentsetScore);
		int newTieBreakScore = nextScore(currentTieBreakScore);
		if (newSetScore >= 6) {
			if (theOpenent.getSetScore() <= 4) {
				setTheSetWinner(p);
				p.setSetScore(newSetScore);
			} else if (theOpenent.getSetScore() == 5) {
				if (newSetScore >= 7) {
					setTheSetWinner(p);
					p.setSetScore(newSetScore);
				}
			} else if (currentsetScore >= 6 && theOpenent.getSetScore() >= 6) {
				System.out.println("Tie break score activated " + newTieBreakScore);
				p.setTieBreakScore(newTieBreakScore);
				if (p.getTieBreakScore() >= 7 && p.getTieBreakScore() - theOpenent.getTieBreakScore() > 2) {
					setTheSetWinner(p);
					setTheMatchWinner(p);
				}
			} else
				p.setSetScore(newSetScore);
		} else
			p.setSetScore(newSetScore);
		System.out.println("player " + p.getSetScore());
		System.out.println("openent " + theOpenent.getSetScore());

	}

	/**
	 * the DEUCE case
	 * 
	 * @param p1
	 * @param p2
	 */
	private boolean isDeuce(Player p1, Player p2) {
		return p1.getScore() == p2.getScore();
	}

	/**
	 * the advantage case
	 */
	private boolean isAdvantage() {
		return p1.getScore() >= 4 || p2.getScore() >= 4;
	}

	/**
	 * the win game case
	 * 
	 */
	private boolean isGameWin() {
		return p1.getScore() - p2.getScore() >= 2 || p2.getScore() - p1.getScore() >= 2;
	}

	/**
	 * reset game scores
	 * 
	 */
	private void resetGameScore() {
		this.p1.resetScore();
		this.p2.resetScore();
	}

	/**
	 * the insrease score
	 * 
	 * @param score
	 */
	private int nextScore(int score) {
		score = score + 1;
		return score;
	}

	/**
	 * get the current player oponent
	 * 
	 * @param name
	 */
	private Player getTheOpenent(String name) {
		for (String playerName : playersArray.keySet().toArray(new String[0])) {
			if (!playerName.equals(name))
				return playersArray.get(playerName);
		}
		return null;
	}

	/**
	 * make a player join the game
	 * 
	 * @param player
	 */
	public void joinThegame(Player player) {
		if (playersArray.size() < 2)
			playersArray.put(player.getPlayerName(), player);
		else
			throw new RuntimeException("The game is between two players");
	}

	/**
	 * clear SET & MATCH winner
	 * 
	 */
	private void clearMatch() {
		setTheSetWinner(null);
		setTheSetWinner(null);
	}

}
