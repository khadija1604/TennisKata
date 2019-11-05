package kataTennisGame.com.tdd;

import static org.junit.Assert.*;

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
	}

	@Test
	public void ZeroShouldBeThePlayersScoreWhenStarting() {
		assertEquals("0-0", tennis.getScore());

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

	@Test
	public void scoreShouldBeDeuce() {
		for(int i=0;i<3;i++){
			p1.winPoint();
			p2.winPoint();
		}
		assertEquals("DEUCE", tennis.getScore());
	}

	@Test
	public void player2ShouldTakeTheAdvantage() {
		for(int i=0;i<3;i++){
			p1.winPoint();
			p2.winPoint();
		}
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());

	}

	@Test
	public void player2ShouldBeTheWinner() {
		for(int i=0;i<3;i++){
			p1.winPoint();
			p2.winPoint();
		}
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 is the winner", tennis.getScore());
	}
	@Test
	public void scoreSouldBeDeuceAfterAdvantageifPlayer2LosePoint(){
		for(int i=0;i<3;i++){
			p1.winPoint();
			p2.winPoint();
		}
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p1.winPoint();
		assertEquals("DEUCE", tennis.getScore());
	}
	@Test
	public void player2ShouldWonSetifHeIstheW(){
		for(int i=0;i<3;i++){
			p1.winPoint();
			p2.winPoint();
		}
		assertEquals("DEUCE", tennis.getScore());
		p2.winPoint();
		assertEquals("player2 take the advantage", tennis.getScore());
		p1.winPoint();
		assertEquals("DEUCE", tennis.getScore());
	}
}
