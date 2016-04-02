package maze.test;


import static org.junit.Assert.*;

import org.junit.Test;

import maze.cli.*;
import maze.logic.*;

public class test {
	
	char [][] m1 = {
			{'X', 'X', 'X', 'X', 'X'},
			{'X', ' ', ' ', ' ', 'S'},
			{'X', ' ', 'X', ' ', 'X'},
			{'X', ' ', ' ', ' ', 'X'},
			{'X', 'X', 'X', 'X', 'X'}
			};

	@Test
	public void testMoveHerotoFreeCell_a() {
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(3,1);
		dragon dragao = new dragon(3,3);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
		
		heroi.moveHero(lab, "O", espada, g1.getDragons());
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(2, heroi.getPos_y());
	}
	
	@Test
	public void testMoveHeroAgainstWall_b(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(3,1);
		dragon dragao = new dragon(3,3);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
		
		heroi.moveHero(lab, "N", espada, g1.getDragons());
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
	}

	@Test
	public void testHerogetsSword_c(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		
		lab.printSword(espada);
		
		heroi.moveHero(lab, "O", espada, g1.getDragons());
		
		assertEquals('A', heroi.getName());
	}
	
	@Test
	public void testHerogetsKilledbyDragon_d(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		
		lab.printDragon(dragao);
		lab.printHero(heroi);
		
		heroi.moveHero(lab, "S", espada, g1.getDragons());
		
		assertEquals(false, g1.check(heroi));
	}
	
	@Test
	public void testHeroKillsDragon_e(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(2,3);
		
		lab.printHero(heroi);
		lab.printDragon(dragao);
		
		heroi.equipHero();
		
		heroi.moveHero(lab, "S", espada, g1.getDragons());
		
		assertEquals(false, dragao.isAlive());
	}
	
	@Test
	public void testHerogetsToExitandWins_f(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		
		heroi.equipHero();
		dragao.changeState();
		
		heroi.moveHero(lab, "E", espada, g1.getDragons());
		
		assertEquals(true, g1.win(heroi, lab));
	}
	
	@Test
	public void testHerogetsToExitbutCantWin_g(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		
		heroi.equipHero();
		
		heroi.moveHero(lab, "E", espada, g1.getDragons());
		
		assertEquals(false, g1.win(heroi, lab));
	}
	
	/*@Test (timeout = 10000)
	public void testSomeRandomBehaviour(){
		boolean dragonsleeps = false, dragonwakesup = false, dragonmoves = false, dragoninsword = false;
		
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,1);
		sword espada = new sword(2,3);
		dragon dragao = new dragon(3,3);
		
		while(!dragonsleeps || !dragonwakesup || !dragonmoves || !dragoninsword){
			dragao.randomSleep();
			dragao.randomPosition(espada);
			lab.printDragon(dragao);
			
			if (dragao.getName() == 'd')
			{
				dragonsleeps = true;
				assertEquals(true, dragonsleeps);
			}
			
			else if(dragao.getName() == 'D')
			{
				dragonwakesup = false;
				assertEquals(false, dragonwakesup);
			}
			
			else if (dragao.getPos_x() != 3 || dragao.getPos_y() != 3)
			{
				dragonmoves = true;
				assertEquals(true, dragonmoves);
			}
			
			if (dragao.getName() == 'F')
			{
				dragoninsword = true;
				assertEquals(true, dragoninsword);
			}
		}
	}*/
}
