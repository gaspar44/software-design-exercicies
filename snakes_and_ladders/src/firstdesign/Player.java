package firstdesign;

public class Player {

	private ISquare square = null;
	public ISquare getSquare() {
		return square;
	}
	public void setSquare(ISquare square) {
		this.square = square;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Player(String strname) {
		name = strname;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean wins() {
		return square.isLastSquare();
	}
	
	public void moveForward(int moves) {
		assert moves>0 : "non-positive moves";
		square.leave(this);
		square = square.moveAndLand(moves);
		square.enter(this);
	}
	
	public int position() {
		return square.getPosition();
	}
}
