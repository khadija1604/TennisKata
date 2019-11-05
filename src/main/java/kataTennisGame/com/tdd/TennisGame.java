/**
 * 
 */
package kataTennisGame.com.tdd;

/**
 * @author p099426
 *
 */
public class TennisGame {
	/** Every game is composed of two players */
	private Player p1;
	private Player p2;

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

	/**
	 * get players scores
	 * 
	 * 
	 */
	public String getScore() {
		if (p1.getScore() >= 3 && p2.getScore() >= 3) {
			if (isDeuce(p1, p2))
				return "DEUCE";
			if (isAdvantage()) {
				float scoresDiff = p1.getScore() - p2.getScore();
				if (scoresDiff == 1)
					return p1.getAdvantage();
				if (scoresDiff == -1)
					return p2.getAdvantage();
				if(isGameWin()){
				if (scoresDiff >= 2)
					return p1.getWinner();
				else
					return p2.getWinner();
			}
			}
		}
		return p1.getCorrespondingScoreValue() + "-" + p2.getCorrespondingScoreValue();
	}

	private boolean isDeuce(Player p1, Player p2) {
		return p1.getScore() == p2.getScore();
	}

	private boolean isAdvantage() {
		return p1.getScore() >= 4 || p2.getScore() >= 4;
	}

	private boolean isGameWin() {
		return p1.getScore()-p2.getScore()>=2 || p2.getScore()-p1.getScore()>=2;
	}
}
