package firstdesign;


public class Snake extends Square {

	private int transport;
	
	public Snake(int pos, Game g, int trans) {
		super(pos, g);
		transport = trans;
	}
}
