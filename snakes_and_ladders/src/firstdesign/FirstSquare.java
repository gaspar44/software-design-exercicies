package firstdesign;

import java.util.ArrayList;
import java.util.Collection;


public class FirstSquare extends Square {

	public FirstSquare(int pos, Game g) {
		super(pos, g);
		assert pos==1;
	}

	private Collection<Player> players = new ArrayList<Player>();
	
	@Override
	public void enter(Player p) {
		players.add(p);
		p.setSquare(this);
	}

	@Override
	public void leave(Player p) {
		players.remove(p);
	}

	@Override
	public boolean isOccupied() {
		return !players.isEmpty();
	}
}
