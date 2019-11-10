/**
 * 
 */
package kataTennisGame.com.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * @author khadija
 *
 */
public class TennisGame {
	/** Every game is composed of two players */
	private Player p1;
	private Player p2;
	private Player theSetWinner;
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
		int currentGameScore = p.getSetScore();
		Player theOpenent = getTheOpenent(p.getPlayerName());
		int newSetScore = nextScore(currentGameScore);
		System.out.println(newSetScore);
		if (newSetScore >= 6) {
			if (theOpenent.getSetScore() <= 4) {
				setTheSetWinner(p);
				System.out.println(theSetWinner);
				p.setSetScore(newSetScore);
			} else if (theOpenent.getSetScore() == 5) {
				if (newSetScore >= 7) {
					setTheSetWinner(p);
					p.setSetScore(newSetScore);
					System.out.println(theSetWinner);
				} else
					p.setSetScore(newSetScore);
			} else
				p.setSetScore(newSetScore);

		} else
			p.setSetScore(newSetScore);
		System.out.println("set score" + p.getSetScore());

	}

	private boolean isDeuce(Player p1, Player p2) {
		return p1.getScore() == p2.getScore();
	}

	private boolean isAdvantage() {
		return p1.getScore() >= 4 || p2.getScore() >= 4;
	}

	private boolean isGameWin() {
		return p1.getScore() - p2.getScore() >= 2 || p2.getScore() - p1.getScore() >= 2;
	}

	private void resetGameScore() {
		this.p1.resetScore();
		this.p2.resetScore();
	}

	private int nextScore(int score) {
		score = score + 1;
		return score;
	}

	private Player getTheOpenent(String name) {
		for (String playerName : playersArray.keySet().toArray(new String[0])) {
			if (!playerName.equals(name))
				return playersArray.get(playerName);
		}
		return null;
	}

	public void joinThegame(Player player) {
		if (playersArray.size() < 2) playersArray.put(player.getPlayerName(), player);
		else throw new RuntimeException("The game is between two players");
	}

	private void clearMatch() {
		setTheSetWinner(null);
	}
}
