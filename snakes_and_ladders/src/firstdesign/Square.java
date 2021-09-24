package firstdesign;


public class Square implements ISquare {

	private Player player;
	private int position;
	private Game game;

	public Square(int pos, Game g) {
		position = pos;
		game = g;
	}
	
	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public boolean isFirstSquare() {
		return false;
	}

	@Override
	public boolean isLastSquare() {
		return false;
	}

	@Override
	public void enter(Player p) {
		player = p;
		player.setSquare(this);
	}

	@Override
	public void leave(Player p) {
		player = null;
	}

	@Override
	public boolean isOccupied() {
		return player!=null;
	}

	private ISquare findRelativeSquare(int moves) {
		return game.findSquare(moves+position);
	}

	private ISquare findRelativeSquareFromLast(int moves){
		ISquare lastSquare = game.findLastSquare();
		return game.findSquare( lastSquare.getPosition()+ moves);
	}
	
	@Override
	public ISquare moveAndLand(int moves) {
		int lastPosition = game.findLastSquare().getPosition();

		if (position+moves>lastPosition) {
			int movesToDo = lastPosition - (position + moves) ;
			System.out.println("Should go to " + (position+movesToDo)
					+ " beyond last square " + (lastPosition+1) 
					+ " so you will move back " + (-1 * movesToDo));

			return findRelativeSquareFromLast(movesToDo).landHereOrGoHome();
		}

		System.out.println("move from " + (position+1) + " to "
					+ (findRelativeSquare(moves).getPosition()+1));

		return findRelativeSquare(moves).landHereOrGoHome();
	}

	private ISquare findFirstSquare() {
		return game.firstSquare();
	}
	
	@Override
	public ISquare landHereOrGoHome() {
		if (isOccupied()) {
			System.out.println("square " + (position+1) + " is occupied");
		} else {
			System.out.println("land at " + (position+1));
		}
		return isOccupied() ? findFirstSquare() : this;
	}

	@Override
	public int getPosition() {
		return position;
	}

	@Override
	public Game getGame() {
		return game;
	}

}
