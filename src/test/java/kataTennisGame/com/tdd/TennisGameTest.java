package kataTennisGame.com.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import kataTennisGame.com.tdd.domain.Player;
import kataTennisGame.com.tdd.score.TennisGame;

public class TennisGameTest {
	Player p1;
	Player p2;
	TennisGame tennis;

	@Before
	public void setUpGame() {
		p1 = new Player("player1");
		p2 = new Player("player2");
		tennis = new TennisGame(p1, p2);
		tennis.joinThegame(p1);
		tennis.joinThegame(p2);
	}

	/**
	 * test score in the begining of the game
	 */
	@Test
	public void ZeroShouldBeThePlayersScoreWhenStarting() {
		Player p1 = new Player("player1");
		Player p2 = new Player("player2");
		TennisGame game = new TennisGame(p1, p2);
		assertEquals("0-0", game.getScore());

	}

	/**
	 * test game score evolution
	 */
	@Test
	public void scoreShouldBefefteenZeroifplayerWin3PointsAndPlayer2Win0point() {
		for (int i = 1; i <= 3; i++) {
			p1.winPoint();
		}
		assertEquals("40-0", tennis.getScore());

	}

	@Test
	public void scoreShouldBethirtyfefteenifplayen2WinPoint() {
		p1.winPoint();
		p1.winPoint();
		p2.winPoint();
		assertEquals("30-15", tennis.getScore());

	}

	@Test
	public void scoreShouldBefourtyfefteenifplayen1WinPoint() {
		p1.winPoint();
		p1.winPoint();
		p2.winPoint();
		p1.winPoint();
		assertEquals("40-15", tennis.getScore());

	}

	@Test
	public void scoreShouldBefourtythirtyifplayen2WinPoint() {
		p1.winPoint();
		p1.winPoint();
		p2.winPoint();
		p1.winPoint();
		p2.winPoint();
		assertEquals("40-30", tennis.getScore());

	}

	private void playersWinThreePoints() {
		for (int i = 0; i < 3; i++) {
			p1.winPoint();
			p2.winPoint();
		}
	}

	/**
	 * test DEUCE case
	 */
	@Test
	public void scoreShouldBeDeuce() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
	}

	/**
	 * test ADVANTAGE after DEUCE case
	 */
	@Test
	public void player2ShouldTakeTheAdvantage() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());

	}

	/**
	 * test win game
	 */
	@Test
	public void player2ShouldBeTheWinner() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 is the winner", tennis.getScore());
	}

	/**
	 * test DEUCE after ADVANTAGE case
	 */
	@Test
	public void scoreSouldBeDeuceAfterAdvantageifPlayer2LosePoint() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p1.winPoint();
		assertEquals("DEUCE", tennis.getScore());
	}

	/**
	 * test initializing score after win
	 */

	@Test
	public void GameScoreShouldBeZeroAfterWin() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 is the winner", tennis.getScore());
		assertEquals(0, p1.getScore());
		assertEquals(0, p2.getScore());
		assertEquals("0-0", tennis.getScore());
	}

	/**
	 * test the evolution of SET score
	 */
	@Test
	public void setScoreOfPlayer2shouldIncreaseByOneEveryTimeHeWinsAGame() {
		for (int i = 1; i <= 5; i++) {
			playersWinThreePoints();
			assertEquals("DEUCE", tennis.getScore());
			p2.winPoint();
			assertEquals("player2 take the advantage", tennis.getScore());
			p2.winPoint();
			assertEquals("player2 is the winner", tennis.getScore());
			assertEquals(0, p1.getScore());
			assertEquals(0, p2.getScore());
			assertEquals("0-0", tennis.getScore());
			assertEquals(0, p1.getSetScore());
			assertEquals(i, p2.getSetScore());
		}

	}

	private void winGame(Player p) {
		playersWinThreePoints();
		p.winPoint();
		p.winPoint();
		tennis.getScore();
	}

	/**
	 * test the win case (player reach a set score of 6 and the openent have a
	 * score lower than 4
	 */
	@Test
	public void Player2_ShouldBeTheWinnerOfTheSetIfHeReachScoreSetOf_6_AtLeastAnd_Player1_HaveSetscoreOf_4_OrLower() {
		for (int i = 1; i <= 5; i++) {
			winGame(p2);
			assertEquals(0, p1.getSetScore());
			assertEquals(i, p2.getSetScore());
		}
		for (int i = 1; i <= 4; i++) {
			winGame(p1);
			assertEquals(i, p1.getSetScore());
			assertEquals(5, p2.getSetScore());
		}
		assertEquals(4, p1.getSetScore());
		assertEquals(5, p2.getSetScore());
		winGame(p2);
		assertEquals(p2, tennis.getTheSetWinner());
	}

	/**
	 * test the win case for player 2 (player reach a set score of 6 and the
	 * openent have 5 as set score => the player should reach a least 7 points
	 * to win the SET
	 */
	@Test
	public void ifPlayer2Reach_6_andPlayer1Has_5_player2_must_reach_7_pointsToWinTheSet() {
		for (int i = 1; i <= 5; i++) {
			winGame(p2);
			assertEquals(0, p1.getSetScore());
			assertEquals(i, p2.getSetScore());
		}
		for (int i = 1; i <= 4; i++) {
			winGame(p1);
			assertEquals(i, p1.getSetScore());
			assertEquals(5, p2.getSetScore());
		}
		assertEquals(4, p1.getSetScore());
		assertEquals(5, p2.getSetScore());
		winGame(p2);
		assertEquals(p2, tennis.getTheSetWinner());
		winGame(p1);
		assertEquals(null, tennis.getTheSetWinner());
		winGame(p2);
		assertEquals(p2, tennis.getTheSetWinner());

	}

	/**
	 * test the win case for player 1(player reach a set score of 6 and the
	 * openent have 5 as set score => the player should reach a least 7 points
	 * to win the SET
	 */
	@Test
	public void ifPlayer1Reach_6_andPlayer2Has_5_player1_must_reach_7_pointsToWinTheSet() {
		for (int i = 1; i <= 5; i++) {
			winGame(p1);
			assertEquals(0, p2.getSetScore());
			assertEquals(i, p1.getSetScore());
		}
		for (int i = 1; i <= 4; i++) {
			winGame(p2);
			assertEquals(i, p2.getSetScore());
			assertEquals(5, p1.getSetScore());
		}
		assertEquals(4, p2.getSetScore());
		assertEquals(5, p1.getSetScore());
		winGame(p1);
		assertEquals(p1, tennis.getTheSetWinner());
		winGame(p2);
		assertEquals(null, tennis.getTheSetWinner());
		winGame(p1);
		assertEquals(p1, tennis.getTheSetWinner());

	}

	/**
	 * Tie-break test cases
	 */
	@Test
	public void the_2_players_reach_the_score_of_6_Games_the_TieBreak_role_should_be_activated() {
		for (int i = 1; i <= 6; i++) {
			winGame(p1);
			assertEquals(i, p1.getSetScore());
			assertEquals(0, p2.getSetScore());
		}
		for (int i = 1; i <= 6; i++) {
			winGame(p2);
			assertEquals(6, p1.getSetScore());
			assertEquals(i, p2.getSetScore());
		}
		assertEquals(6, p2.getSetScore());
		assertEquals(6, p1.getSetScore());
		assertEquals(null, tennis.getTheSetWinner());
		assertEquals(0, p1.getTieBreakScore());
		assertEquals(0, p2.getTieBreakScore());
		for (int i = 1; i <= 7; i++) {
			winGame(p1);
			assertEquals(i, p1.getTieBreakScore());
			assertEquals(6, p1.getSetScore());
			if (i > 7) {
				assertEquals(null, tennis.getTheSetWinner());
				assertEquals(null, tennis.getTheMatchWinner());
			}

		}
		assertEquals(p1, tennis.getTheSetWinner());
		assertEquals(p1, tennis.getTheMatchWinner());

	}

}
