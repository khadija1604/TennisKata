/**
 * 
 */
package kataTennisGame.com.tdd;

/**
 * @author p099426
 *
 */
public class TennisGame {
	/** Every game is composed of  two players*/
	private Player p1;
	private Player p2;
	
  public TennisGame(Player p1, Player p2) {
		this.p1=p1;
		this.p2=p2;
	}

public String getScore(){
	  if(p1.getScore()>=3 && p2.getScore()>=3) {
		  if(Math.abs(p1.getScore()-p2.getScore())>0){
			  if(p1.getScore()>p2.getScore()) return p1.getWinner();
			  return p2.getWinner();
		  }
	  }
	  return p1.getCorrespondingScoreValue()+"-"+p2.getCorrespondingScoreValue();
  }
}
