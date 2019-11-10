package kataTennisGame.com.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TennisGameTest {
	Player p1;
	Player p2;
	TennisGame tennis;

	@Before
	public void setupGame() {
		p1 = new Player("player1");
		p2 = new Player("player2");
		tennis = new TennisGame(p1, p2);
		tennis.joinThegame(p1);
		tennis.joinThegame(p2);
	}

	@Test
	public void ZeroShouldBeThePlayersScoreWhenStarting() {
		Player p1 = new Player("player1");
		Player p2 = new Player("player2");
		TennisGame game = new TennisGame(p1, p2);
		assertEquals("0-0", game.getScore());

	}

	@Test
	public void scoreShouldBefefteenZeroifplayen1WinPoint() {
		p1.winPoint();
		assertEquals("15-0", tennis.getScore());

	}

	@Test
	public void scoreShouldBethirtyZeroifplayen1WinPoint() {
		p1.winPoint();
		p1.winPoint();
		assertEquals("30-0", tennis.getScore());

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

	@Test
	public void scoreShouldBeDeuce() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
	}

	@Test
	public void player2ShouldTakeTheAdvantage() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());

	}

	@Test
	public void player2ShouldBeTheWinner() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 is the winner", tennis.getScore());
	}

	@Test
	public void scoreSouldBeDeuceAfterAdvantageifPlayer2LosePoint() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p1.winPoint();
		assertEquals("DEUCE", tennis.getScore());
	}

	@Test
	public void player2ShouldWonSetifHeIstheW() {
		playersWinThreePoints();
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p1.winPoint();
		assertEquals("DEUCE", tennis.getScore());
	}

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

}
