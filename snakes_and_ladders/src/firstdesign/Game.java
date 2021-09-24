package firstdesign;

import java.util.ArrayList;
import java.util.LinkedList;


public class Game {
	private LinkedList<Player> players = new LinkedList<Player>();
	private ArrayList<ISquare> squares = new ArrayList<ISquare>();
	private Player winner;
	
	public Game(String[] playerNames,
			int numSquares, int[][] ladders, int[][] snakes,int death) {
		createPlayers(playerNames);
		createGame(numSquares, ladders, snakes, death);
		play();
	}

	private void createPlayers(String[] playerNames) {
		System.out.println("Players are : ");
		int i=1;
		for (String str : playerNames) {
			Player player = new Player(str);
			players.add(player);
			System.out.println(i + ". " + str);
			i++;
		}		
	}
	
	private int numberOfSquares() {
		return squares.size();
	}
	
	private void createGame(int numSquares, int[][] ladders, int[][] snakes, int death) {
		System.out.println("There are " + numSquares + " squares");
		squares.add(new FirstSquare(0,this));

		for (int position=1 ; position<numSquares-1 ; position++) {
			Square square = new Square(position, this);
			squares.add(square);
		}

		squares.add(new LastSquare(numSquares-1,this));

		setSquares(snakes);
		setSquares(ladders);

	}

	private void setSquares(int[][] squareType) {
		for (int i = 0; i< squareType.length ; i++) {
			assert squareType[i].length == 2;
			
			int fromPosition = squareType[i][0]-1;
			int toPosition = squareType[i][1]-1;
			int transport = toPosition - fromPosition;
			
			assert transport<0 : "In snake, destination after origin";
			assert (toPosition > 0) && (toPosition<numberOfSquares()-1);
			assert (fromPosition < numberOfSquares()-1) && (fromPosition>0);
			
			System.out.println("snake from " + (fromPosition+1) 
					+ " to " + (toPosition+1));
			
			squares.set(fromPosition, new LadderOrSnake(fromPosition,this, transport));
		}
	}

	public ISquare firstSquare() {
		return squares.get(0);
	}

	Player currentPlayer() {
		assert players.size()>=0;
		return players.peek();
	}
	
	private boolean notOver() {
		return winner == null || players.size() == 0;
	}

	private void movePlayer(int roll) {
		Player currentPlayer = players.remove();
		currentPlayer.moveForward(roll);
		players.add(currentPlayer);
		if (currentPlayer.wins()) {
			winner = currentPlayer;
		}
	}

	public void play() {
		Dice dice = new Dice();
		
		for (Player player : players) {
			firstSquare().enter(player);
		}
		winner = null;		

		System.out.println("Initial state : \n" + this);
		while (notOver()) {
			int roll = dice.roll();
			System.out.println("Current player is " + currentPlayer() 
					+ " and rolls " + roll);
			movePlayer(roll);
			System.out.println("State : \n" + this);
		}


		System.out.println(winner + " has won.");
	}
	
	public ISquare findSquare(int position) {
		assert position>=0 && position<this.numberOfSquares() : "bad position";
		return squares.get(position);
	}
	
	@Override
	public String toString() {
		String str = new String();
		for (Player player : players) {
			str += player.getName() + " is at square " + (player.position()+1) + "\n"; 
		}
		return str;
	}
	
	public ISquare findLastSquare() {
		return squares.get(squares.size()-1);
	}
}
