package firstdesign;


public interface ISquare {
	public Player getPlayer();
	
	public boolean isFirstSquare();
	
	public boolean isLastSquare();
	
	public void enter(Player p);
	
	public void leave(Player p);
	
	public boolean isOccupied();
	
	public ISquare moveAndLand(int moves);
	
	public ISquare landHereOrGoHome();
	
	public int getPosition();

	public Game getGame();
}
