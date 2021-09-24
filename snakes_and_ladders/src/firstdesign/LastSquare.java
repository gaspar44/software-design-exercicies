package firstdesign;


public class LastSquare extends Square {

	public LastSquare(int pos, Game g) {
		super(pos, g);
	}

	@Override
	public boolean isLastSquare() {
		return true;
	}
}
