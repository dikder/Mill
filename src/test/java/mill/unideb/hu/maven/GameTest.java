package mill.unideb.hu.maven;

import static org.junit.Assert.*;

import java.util.Random;

import mill.unideb.hu.maven.Game.GameState;

import org.junit.Before;
import org.junit.Test;
import org.jmock.*;

public class GameTest {
	Player light;
	Player dark;
	Game game;
	
	@Before
	public void setUp() {
		light=new Player("asd");
		dark=new Player("fsdf");
		game=new Game(light,dark);
		GUImill gui=new GUImill();
		game.guiservice(gui);
		
	}
	
	@Test
	public void GameTest(){
		int db=0;
		for(int j=0;j<3;j++){
			for(int i=0;i<8;i++){
				if(game.stones[j][i]==0){
					db++;
				}
			}
		}
		
		assertEquals(24, db);
	}
	
	@Test
	public void testIsMoveable(){
		game.stones[0][0]=Game.WHITE;
		game.stones[0][1]=Game.BLACK;
		game.stones[0][7]=Game.BLACK;
		assertFalse(game.isMoveable(0, 0));
	}
	
	@Test
	public void TestIsMoveable2(){
		game.stones[0][0]=Game.WHITE;
		game.stones[0][1]=Game.BLACK;
		game.stones[0][7]=Game.BLACK;
		assertTrue(game.isMoveable(0, 1));
	}
	
	@Test
	public void TestIsMoveable3(){
		game.stones[0][0]=Game.WHITE;
		game.stones[0][1]=Game.BLACK;
		game.stones[0][2]=Game.BLACK;
		game.stones[1][1]=Game.WHITE;
		assertFalse(game.isMoveable(0, 1));
	}
	
	@Test
	public void TestIsMoveable4(){
		game.stones[1][0]=Game.WHITE;
		game.stones[0][7]=Game.BLACK;
		game.stones[1][1]=Game.BLACK;
		game.stones[1][7]=Game.WHITE;
		assertFalse(game.isMoveable(1, 0));
		assertTrue(game.isMoveable(1, 7));
	}
	
	@Test
	public void TestIsMoveable5(){
		game.stones[2][0]=Game.WHITE;
		game.stones[2][7]=Game.BLACK;
		game.stones[2][2]=Game.BLACK;
		game.stones[1][7]=Game.WHITE;
		assertTrue(game.isMoveable(2, 0));
		assertTrue(game.isMoveable(2, 2));
	}
	
	@Test
	public void TestIsMoveable6(){
		game.stones[0][3]=Game.WHITE;
		game.stones[0][5]=Game.BLACK;
		game.stones[1][6]=Game.BLACK;
		game.stones[2][5]=Game.WHITE;
		game.stones[1][2]=Game.BLACK;
		game.stones[0][4]=Game.WHITE;
		game.stones[1][5]=Game.BLACK;
		
		assertFalse(game.isMoveable(0, 4));
		assertTrue(game.isMoveable(2, 5));
		assertTrue(game.isMoveable(2, 2));
	}
	
	@Test
	public void TestIsMoveable7(){
		game.stones[1][3]=Game.WHITE;
		game.stones[1][5]=Game.BLACK;
		game.stones[1][6]=Game.BLACK;
		game.stones[1][2]=Game.BLACK;
		
		assertTrue(game.isMoveable(1, 3));
		assertTrue(game.isMoveable(1, 5));
	}
	
	@Test
	public void TestIsMoveable8(){
		game.stones[2][7]=Game.WHITE;
		game.stones[1][5]=Game.BLACK;
		game.stones[1][6]=Game.BLACK;
		game.stones[1][7]=Game.BLACK;
		
		assertTrue(game.isMoveable(2, 7));
		assertTrue(game.isMoveable(1, 7));
	}
	
	
	
	@Test
	public void testAcceptMove(){
		game.stones[0][0]=Game.BLACK;
		
		boolean t1=game.acceptMove(0, 0, 0, 1);
		boolean t2=game.acceptMove(0, 0, 2, 1);
		assertTrue(t1);
		assertFalse(t2);
	}
	
	@Test
	public void testAcceptMove2(){
		game.stones[1][1]=Game.BLACK;
		game.stones[0][1]=Game.WHITE;
		game.stones[1][2]=Game.WHITE;
		game.stones[1][0]=Game.WHITE;
		game.stones[2][1]=Game.BLACK;
		assertTrue(game.acceptMove(2, 1, 2, 2));
	}
	
	@Test
	public void testAcceptMove3(){
		game.stones[1][1]=Game.BLACK;
		game.stones[0][1]=Game.WHITE;
		game.stones[1][2]=Game.WHITE;
		game.stones[1][0]=Game.WHITE;
		game.stones[2][1]=Game.BLACK;
		assertFalse(game.acceptMove(2, 1, 1, 1));
	}
	
	@Test
	public void testAcceptMove4(){
		game.stones[1][1]=Game.BLACK;
		game.stones[0][1]=Game.WHITE;
		game.stones[1][2]=Game.WHITE;
		game.stones[1][0]=Game.WHITE;
		game.stones[2][1]=Game.BLACK;
		assertFalse(game.acceptMove(1, 1, 1, 2));
	}
	
	@Test
	public void testAcceptMove5(){
		game.stones[1][1]=Game.BLACK;
		game.stones[0][1]=Game.WHITE;
		game.stones[1][2]=Game.WHITE;
		game.stones[1][0]=Game.WHITE;
		game.stones[2][1]=Game.BLACK;
		assertFalse(game.acceptMove(1, 1, 2, 5));
	}
	
	@Test
	public void testAcceptMove6(){
		game.stones[1][1]=Game.BLACK;
		game.stones[0][1]=Game.WHITE;
		game.stones[1][2]=Game.WHITE;
		game.stones[2][1]=Game.BLACK;
		game.stones[0][0]=Game.BLACK;
		game.stones[1][7]=Game.WHITE;
		assertTrue(game.acceptMove(0, 0, 0, 7));
		assertTrue(game.acceptMove(1, 7, 1, 0));
	}
	
	@Test
	public void testAcceptMove7(){
		game.stones[1][1]=Game.BLACK;
		game.stones[0][1]=Game.WHITE;
		game.stones[1][2]=Game.WHITE;
		game.stones[2][5]=Game.BLACK;
		game.stones[0][0]=Game.BLACK;
		game.stones[1][7]=Game.WHITE;
		assertTrue(game.acceptMove(1, 1, 2, 1));
		assertTrue(game.acceptMove(2, 5, 1, 5));
	}
	
	@Test
	public void testAcceptMove8(){
		game.stones[1][1]=Game.BLACK;
		game.stones[1][3]=Game.WHITE;
		game.stones[1][2]=Game.WHITE;
		game.stones[2][5]=Game.BLACK;
		game.stones[0][0]=Game.BLACK;
		game.stones[1][7]=Game.WHITE;
		assertFalse(game.acceptMove(1, 1, 1, 7));
		assertTrue(game.acceptMove(1, 3, 2, 3));
	}
	
	@Test
	public void testIsWin1(){
		this.light.setNumberOfStones(2);
		this.light.setNumberOfStonesLeftToBoard(7);
		this.dark.setNumberOfStones(4);
		this.dark.setNumberOfStonesLeftToBoard(5);
		game.setDark(dark);
		game.setLight(light);
		assertTrue(game.isWin());
	}
	
	@Test
	public void testIsWin2(){
		this.light.setNumberOfStones(3);
		this.light.setNumberOfStonesLeftToBoard(6);
		this.dark.setNumberOfStones(4);
		this.dark.setNumberOfStonesLeftToBoard(5);
		game.setDark(dark);
		game.setLight(light);
		assertFalse(game.isWin());
	}
	
	@Test
	public void testIsWin3(){
		this.light.setNumberOfStones(4);
		this.light.setNumberOfStonesLeftToBoard(5);
		this.dark.setNumberOfStones(2);
		this.dark.setNumberOfStonesLeftToBoard(7);
		game.setDark(dark);
		game.setLight(light);
		game.setPlayer(false);
		assertTrue(game.isWin());
	}
	
	@Test
	public void testIsWin4(){
		this.light.setNumberOfStones(4);
		this.light.setNumberOfStonesLeftToBoard(5);
		this.dark.setNumberOfStones(9);
		this.dark.setNumberOfStonesLeftToBoard(0);
		game.setDark(dark);
		game.setLight(light);
		game.setPlayer(false);
		assertFalse(game.isWin());
	}
	
	@Test
	public void testPlaceStone1(){
		game.placeStone(1, 1);
		assertEquals(1, game.stones[1][1]);
	}
	
	@Test
	public void testPlaceStone2(){
		game.placeStone(1, 1);
		game.placeStone(1, 1);
		assertEquals(1, game.stones[1][1]);
	}
	
	@Test
	public void testPlaceStone3(){
		game.placeStone(1, 1);
		game.placeStone(1, 4);
		assertEquals(2, game.stones[1][4]);
		assertTrue(game.isPlayer());
	}
	
	private void adjust(int i,int j){
		game.setBesti(i);
		game.setBestj(j);
		game.play();
	}
	
	@Test
	public void testPlay1(){
		adjust(1,1);
		assertEquals(Game.GameState.PLACE, game.getCurrentState());
		assertFalse(game.isPlayer());
	}
	
	@Test
	public void testPlay2(){
		adjust(1,1);
		adjust(0,1);
		adjust(1,0);
		adjust(0,0);
		adjust(1,2);
		
		assertEquals(Game.GameState.TAKE, game.getCurrentState());
		assertTrue(game.isPlayer());
	}
	
	@Test
	public void testPlay3(){
		adjust(1,1);
		adjust(0,1);
		adjust(1,0);
		adjust(0,0);
		adjust(1,2);
		adjust(0,1);
		
		assertEquals(0, game.stones[0][1]);
		assertFalse(game.isPlayer());
	}
	
	@Test
	public void testPlay4(){
		adjust(1,1);
		adjust(0,1);
		adjust(1,0);
		adjust(0,0);
		adjust(1,2);
		adjust(0,1);
		adjust(0,1);
		
		assertEquals(2, game.stones[0][1]);
	}
	
	private void matrixUpload(){
		adjust(0, 0);
		adjust(1,0);
		
		adjust(0,1);
		adjust(1,1);
		
		adjust(0,2);
		
		adjust(1,1);
		adjust(1,1);
		
		adjust(0,3);
		adjust(1,2);
		
		adjust(0,3);
		
		adjust(0,3);
		adjust(0,4);
		
		adjust(2,0);
		adjust(2,1);
		
		adjust(2,2);
		adjust(2,3);
		
		adjust(1,3);
		adjust(1,4);
		
		adjust(1,5);
		adjust(1,6);
		
		
		
	}
	
	@Test
	public void testPlay5(){
		matrixUpload();
		assertEquals(Game.GameState.MOVE,game.getCurrentState());
		assertTrue(game.isPlayer());
	}
	
	
	
	@Test
	public void testPlay6(){
		matrixUpload();
		adjust(1, 5);
		adjust(2,5);
		
		assertEquals(1,game.stones[2][5]);
	}
	
	

}
