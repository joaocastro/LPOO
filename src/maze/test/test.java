package maze.test;


import static org.junit.Assert.*;

import org.junit.Test;
import Proj.*;
import maze.cli.*;

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
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(3,1);
		dragon dragao = new dragon(3,3);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
		
		heroi.moveHero(lab, "O", espada, dragao);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(2, heroi.getPos_y());
	}
	
	@Test
	public void testMoveHeroAgainstWall_b(){
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(3,1);
		dragon dragao = new dragon(3,3);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
		
		heroi.moveHero(lab, "N", espada, dragao);
		
		assertEquals(1, heroi.getPos_x());
		assertEquals(3, heroi.getPos_y());
	}

	@Test
	public void testHerogetsSword_c(){
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		
		lab.printSword(espada);
		
		heroi.moveHero(lab, "O", espada, dragao);
		
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
		
		heroi.moveHero(lab, "S", espada, dragao);
		
		assertEquals(false, g1.check(heroi, dragao));
	}
	
	@Test
	public void testHeroKillsDragon_e(){
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(2,3);
		
		lab.printHero(heroi);
		lab.printDragon(dragao);
		
		heroi.equipHero();
		
		heroi.moveHero(lab, "S", espada, dragao);
		
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
		
		heroi.moveHero(lab, "E", espada, dragao);
		
		assertEquals(true, g1.win(heroi, dragao, lab));
	}
	
	@Test
	public void testHerogetsToExitbutCantWin_g(){
		Game g1 = new Game();
		Labirinto lab = new Labirinto(m1, 5, 5);
		hero heroi = new hero(1,3);
		sword espada = new sword(1,2);
		dragon dragao = new dragon(3,3);
		
		heroi.equipHero();
		
		heroi.moveHero(lab, "E", espada, dragao);
		
		assertEquals(false, g1.win(heroi, dragao, lab));
	}
}
