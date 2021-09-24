package firstdesign;

public class Main {

	public static void main(String[] args) {
		String[] playerNames = {"Maria", "Abel","Nuria","Joan"};
		int numSquares = 12;
		// for the user first square is at position 1 but internally is at 0
		int[][] snakesFromTo = { {11,5} };
		int[][] laddersFromTo = { {2,6} , {7,9} };
		
		new Game(playerNames, numSquares, laddersFromTo, snakesFromTo);
	}

}
