package test;

import firstdesign.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.LinkedList;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DeathTest {
  private String[] playerNames = {"Maria", "Abel","Nuria","Joan"};
  private int numSquares = 12;
  private LinkedList<Player> players = new LinkedList<Player>();
  private ArrayList<ISquare> squares = new ArrayList<ISquare>();
  // for the user first square is at position 1 but internally is at 0
  /*int[][] snakesFromTo = { {11,5} };
  int[][] laddersFromTo = { {2,6} , {7,9} };*/
  private final int DEATH = 5;

  @Mock
  Game game;

  @Before
  public void before() throws Exception {
    createPlayers();
    setSquares();

    for (Player player : players) {
      squares.get(0).enter(player);
    }
  }

  @Test
  public void DeathSquareEnter() throws Exception {
    Assert.assertNotNull(game);
    when(game.findLastSquare()).thenReturn(squares.get(numSquares - 1));
    when(game.findSquare(DEATH)).thenReturn(squares.get(DEATH));

    Player playerToDie = players.get(0);
    boolean isDeath = playerToDie.moveForward(DEATH);

    Assert.assertEquals(DEATH,squares.get(DEATH).getPosition());
    Assert.assertTrue(isDeath);
  }


  private void createPlayers() {
    for (String str : playerNames) {
      Player player = new Player(str);
      players.add(player);
    }
  }

  private void setSquares() {
    squares.add(new FirstSquare(0,game));

    for (int position=1 ; position<numSquares-1 ; position++) {
      Square square = position != DEATH ? new Square(position, game) : new DeathSquare(position,game);
      squares.add(square);
    }

    squares.add(new LastSquare(numSquares-1,game));
  }
}
