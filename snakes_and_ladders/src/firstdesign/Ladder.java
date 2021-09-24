package firstdesign;


public class Ladder extends Square {
	private int transport;
	
	public Ladder(int pos, Game g, int trans) {
		super(pos, g);
		transport = trans;
	}

}
