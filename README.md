#kata tennis
 
-GIT worflow:
Please check all commits to interstand the way i proceeded fro this test
Github project link:
https://github.com/khadija1604/TennisKata  

 -The projet requires JAVA8
 -Project description:
          -The project is a maven project, It contains two packages:
		     -kataTennisGame.com.tdd.domain :contains Player.java class.
			 -kataTennisGame.com.tdd.score  : contains TennisGame.java class that manages the score.
		  -kataTennisGame.com.tdd test part holds test classes acheived using JUnit4 : TennisGameTest.java class includes all project test cases according to the specifications.
          -The project contains 15 test cases, Every test respondes to a specific game role. 
		  -The project is developped using TDD method (write test, make it pass, refactor).
          -All tests cases are documented (check the documentation details of evey one)
 -Setup project:
          1-clone or download the last project version from github (https://github.com/khadija1604/TennisKata.git)
          2-Import project into the workspace as an existing maven project.
          3-Build project with the maven "clean install". 
          4-Run Junit tests.
		  

#Game roles and specifications:

SPRINT1 : manage a tennis GAME within a set of a tennis match
User Story 1 :
                As a tennis referee
I want to manage the score of a game of a set of a tennis match between 2 players with simple Game rules
In order to display the current Game score of each player
 
                Rules details:
·         The game starts with a score of 0 point for each player
·         Each time a player win a point, the Game score changes as follow:
0 -> 15 -> 30 -> 40-> Win game
 
                                Example:
GAME SCORE
 	Start the game	Player 1 wins 1 point	Player 1 wins 1 point	Player 2 wins 1 point	Player 1 wins 1 point	Player 2 wins 1 point	Player 2 wins 1 point	Player 2 wins 1 point
Player 1	0	15	30	30	40	40	40	0
Player 2	0	0	0	15	15	30	40	0
 	 	 	 	 	 	 	 	Player 2 win the game

 
User Story 2 :
                As a tennis referee
I want to manage the specific of the rule DEUCE at the end of a Game
In order to display the current Game score of each player
 
                Rules details:
·         If the 2 players reach the score 40, the DEUCE rule is activated
·         If the score is DEUCE , the player who  win the point take the ADVANTAGE
·         If the player who has the ADVANTAGE win the  point, he win the game
·         If the player who has the ADVANTAGE looses the point, the score is DEUCE
 
                                Example:
GAME SCORE
 	Start the game	Player 1 wins 1 point	Player 1 wins 1 point	Player 2 wins 1 point	Player 1 wins 1 point	Player 2 wins 1 point	Player 2 wins 1 point	Player 2 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point
Player 1	0	15	30	30	40	40	40	40	DEUCE	ADV	0
Player 2	0	0	0	15	15	30	40	ADV	DEUCE	40	0
 	 	 	 	 	 	 	 	 	 	 	Player 1 win the game
								

									
									
									
											

 
 
SPRINT2 : manage a Tennis SET within a tennis match
User Story 1 :
              As a tennis referee
I want to manage the score of a set of a tennis match between 2 players
In order to display the current Game (SPRINT 1) & Set score of each player
 
                Rules details:
·         The set starts with a score of 0 Game for each player
·         Each time a player win a Game (see SPRINT 1), the Set score changes as follow:
1 -> 2 -> 3 -> 4 -> 5 -> 6 (-> 7)
·         If a player reach the Set score of 6 and the other player has a Set score of 4 or lower, the player win the Set
·         If a player wins a Game and reach the Set score of 6 and the other player has a Set score of 5, a new Game must be played and the first player who reach the score of 7 wins the match
 
                                Example:
SET SCORE
 	Start the game & Set	Player 1 wins 1 point	Player 1 wins 1 point	Player 2 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point	Player 2 wins 1 Game	Player 2 1 Game	Player 2 wins 1 Game	Player 2 wins 1 Game	Player 2 wins 1 Game	Player 2 wins 1 Game
 	Game Score	Set score	Game Score	Set score	Game Score	Set score	Game Score	Set score	Game Score	Set score	Game Score	Set score	Game Score	Set score	Game wins Score	Set score	Game Score	Set score	Game Score	Set score	Game Score	Set score	Game Score	Set score
Player 1	0	0	15	0	30	0	30	0	40	0	0	1	0	1	0	1	0	1	0	1	0	1	0	1
Player 2	0	0	0	0	0	0	15	0	15	0	0	0	0	1	0	2	0	3	0	4	0	5	0	6
 	 	 	 	 	 	 	 	 	 	 	 	Player 1 wins the 1st game of the set	 	 	 	 	 	 	 	 	 	 	 	Player 2 wins the set

 
User Story 2 :
                As a tennis referee
I want to manage the specific of the rule of Tie-Break at the end of the Set
In order to display the current Game, Set score & Tie-Break score of each player
 
                Rules details:
·         If the 2 players reach the score of 6 Games , the Tie-Break rule is activated
·         Each time a player win a point, the score changes as follow:
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 (-> 8-> 9-> 10-> …)
·         The Tie-Break ends as soon as a player gets a least 7 points and 2 points more than his opponent
·         The player who wins the Tie-Break wins the Set and the match
 
                                Example:
SET SCORE
 	Initial Score of the Set	Player 1 wins 1 point	Player 1 wins 1 point	Player 2 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point	Player 1 wins 1 point
 	Game Score	Set score	Game Score	Set score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score	Game Score	Set score	Tie Break score
Player 1	40	5	0	6	0	6	1	0	6	1	0	6	2	0	6	3	0	6	3	0	6	4	0	6	5	0	6	6	0	7	0
Player 2	15	6	0	6	0	6	0	0	6	1	0	6	1	0	6	1	0	6	2	0	6	2	0	6	2	0	6	2	0	6	0
 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	 	Player 1 wins the set and match

 
 

		  
