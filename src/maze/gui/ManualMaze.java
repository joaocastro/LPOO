package maze.gui;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import maze.cli.Game;
import maze.logic.Labirinto;

//import com.sun.prism.Graphics;

import maze.logic.dragon;
import maze.logic.hero;
import maze.logic.sword;

public class ManualMaze extends JPanel implements MouseListener{

	private JFrame frame;
	
	private Game jogo;
	private int size;
	private ArrayList<dragon> dragons;
	private hero heroi;
	private sword espada;
	private char[][] lab;
	private Labirinto maze;
	private Image wall, floor, dragon, sword, exit, hero, herowithsword, lost, won, sleepingdragon;
	private String selectedItem;
	private boolean hero_created;
	private boolean sword_created;

	/**
	 * Create the application.
	 */
	public ManualMaze(int siz) {
		super();
	
		wall = new ImageIcon("parede.png").getImage();
		floor = new ImageIcon("chao.png").getImage();
		dragon = new ImageIcon("dragao.png").getImage();
		sword = new ImageIcon("espada.png").getImage();
		exit = new ImageIcon("saida.png").getImage();
		hero = new ImageIcon("heroi.png").getImage();
		herowithsword = new ImageIcon("heroicomespada.png").getImage();
		lost = new ImageIcon("perdeu.png").getImage();
		won = new ImageIcon("ganhou.png").getImage();
		sleepingdragon = new ImageIcon("dragaodormir.png").getImage();
		size = wall.getWidth(null);
		
		size = siz;
		lab = new char[size][size];
		
		for (int i = 0; i< size; i++)
			for (int j = 0; j < size; j++){
					lab[i][j] = ' ';
			}
		
		for (int i = 0; i < size; i++){
			lab[0][i] = 'X';
			lab[i][0] = 'X';
			lab[size - 1][i] = 'X';
			lab[i][size - 1] = 'X';
		}
		maze = new Labirinto(lab, size, size);
		jogo = new Game();
		jogo.setMaze(maze);
		jogo.setHero(heroi);
		jogo.setSword(espada);
		
		selectedItem = "Parede";
		hero_created = false;
		sword_created = false;
		addMouseListener(this);
	}
		
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		int x = 0, y = 0;
		int siz = wall.getWidth(null);
		int MAX_SIZE = 10 * siz;
		int sizeObj_H = (int) MAX_SIZE/jogo.getMaze().getLines();
		int sizeObj_V = (int) MAX_SIZE/jogo.getMaze().getColumns();
		
		for (int i=0; i<jogo.getMaze().getLines(); i++){
			
			for (int j=0; j<jogo.getMaze().getColumns(); j++)
			{
				if(jogo.getMaze().getTable()[i][j]==' ')
				{
					g.drawImage(floor, x, y, sizeObj_H, sizeObj_V, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='X')
				{
					g.drawImage(wall,  x, y, sizeObj_H, sizeObj_V, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='D' || jogo.getMaze().getTable()[i][j]=='F')
				{
					g.drawImage(dragon,  x, y, sizeObj_H, sizeObj_V, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='E')
				{
					g.drawImage(sword,  x, y, sizeObj_H, sizeObj_V, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='S')
				{
					g.drawImage(exit,  x, y, sizeObj_H, sizeObj_V, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='H')
				{
					g.drawImage(hero, x, y, sizeObj_H, sizeObj_V, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='A')
				{
					g.drawImage(herowithsword, x, y, sizeObj_H, sizeObj_V, null);
				}
				if (jogo.getMaze().getTable()[i][j] == 'd')
				{
					g.drawImage(sleepingdragon, x, y, sizeObj_H, sizeObj_V, null);
				}
				
				if (sword_created && hero_created)
					if (jogo.win())
					{
						super.paintComponent(g);
						g.drawImage(won,  0, 0, null);
					}
					if (!jogo.check())
					{
						super.paintComponent(g);
						g.drawImage(lost, 0, 0, null);	
					}
				
				x+=sizeObj_H;
			}
			x = 0;
			y+=sizeObj_V;
		}
	}
	
	public void setSelectedItem(String s){
		selectedItem = s;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		float y = e.getX();
		float x = e.getY();
		
		int siz = wall.getWidth(null);
		int MAX_SIZE = 10 * siz;
		int sizeObj_H = (int) MAX_SIZE/jogo.getMaze().getLines();
		int sizeObj_V = (int) MAX_SIZE/jogo.getMaze().getColumns();
		
		double coord_x = ((float) x/sizeObj_H);
		double coord_y = ((float) y/sizeObj_V);
		
		
		switch (selectedItem){
		case "Parede":
			lab[(int) coord_x][(int) coord_y] = 'X';
			break;
		case "Saida":
			if (((int) coord_x == 0 && (int) coord_y == 0)
					|| ((int) coord_x == 0 && (int) coord_y == size - 1)
					|| ((int) coord_x == size - 1 && (int) coord_y == 0)
					|| ((int) coord_x == size - 1 && (int) coord_y == size - 1)
					|| ((int) coord_x < size - 1 && (int) coord_y < size - 1 && (int) coord_x > 0 && (int) coord_y > 0))
				break;
			else {
				for (int i = 0; i< size; i++)
					for (int j = 0; j < size; j++){
							if (lab[i][j] == 'S')
								lab[i][j] = 'X';
					}
				lab[(int) coord_x][(int) coord_y] = 'S';
				maze.setExit();
				
			}
			
			break;
			
		case "Heroi":
			if ((int) coord_x == 0 || (int) coord_x == size -1 || (int) coord_y == 0 || (int) coord_y == size -1)
				break;
			else {
				for (int i = 0; i< size; i++)
					for (int j = 0; j < size; j++){
							if (lab[i][j] == 'H')
								lab[i][j] = ' ';
					}
				heroi = new hero((int) coord_x, (int) coord_y);
				jogo.setHero(heroi);
				jogo.getMaze().printHero(heroi);
				hero_created = true;
			}
			break;
			
		case "Espada":
			if ((int) coord_x == 0 || (int) coord_x == size -1 || (int) coord_y == 0 || (int) coord_y == size -1)
				break;
			else {
				for (int i = 0; i< size; i++)
					for (int j = 0; j < size; j++){
							if (lab[i][j] == 'E')
								lab[i][j] = ' ';
					}
				espada = new sword((int) coord_x, (int) coord_y);
				jogo.setSword(espada);
				jogo.getMaze().printSword(espada);
				sword_created = true;
			}
			
			break;
			
		case "Dragao":
			if ((int) coord_x == 0 || (int) coord_x == size -1 || (int) coord_y == 0 || (int) coord_y == size -1)
				break;
			else {
				dragon d = new dragon((int) coord_x, (int) coord_y);
				jogo.addDragon(d);
				jogo.getMaze().printDragon(d);
			}
			break;
			
		case "Caminho":
			if ((int) coord_x == 0 || (int) coord_x == size -1 || (int) coord_y == 0 || (int) coord_y == size -1)
				break;
			else {
				lab[(int) coord_x][(int) coord_y] = ' ';
			}
			break;
		}
		
		repaint();
	}
	
	public Game getGame(){
		return jogo;
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
