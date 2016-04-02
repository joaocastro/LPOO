package maze.gui;

/*import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;*/

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import maze.cli.Game;

import java.awt.event.*;
import java.io.File;

public class GraphicsPanel extends JPanel implements KeyListener {

	private Game jogo;
	private Image wall, floor, dragon, sword, exit, hero, herowithsword;
	//private int x;
	//private int y;
	private int size;
	
	public GraphicsPanel(Game jogo) {
		super();
		//this.x=x;
		//this.y=y;
		this.jogo=jogo;
		
		wall = new ImageIcon("C:\\Users\\ASUS\\Desktop\\LPOO\\src\\parede.png").getImage();
		floor = new ImageIcon("C:\\Users\\ASUS\\Desktop\\LPOO\\src\\chao.png").getImage();
		dragon = new ImageIcon("C:\\Users\\ASUS\\Desktop\\LPOO\\src\\dragao.png").getImage();
		sword = new ImageIcon("C:\\Users\\ASUS\\Desktop\\LPOO\\src\\espada.png").getImage();
		exit = new ImageIcon("C:\\Users\\ASUS\\Desktop\\LPOO\\src\\saida.png").getImage();
		hero = new ImageIcon("C:\\Users\\ASUS\\Desktop\\LPOO\\src\\heroi.png").getImage();
		herowithsword = new ImageIcon("C:\\Users\\ASUS\\Desktop\\LPOO\\src\\heroicomespada.png").getImage();
		size = wall.getWidth(null);
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i=0; i<jogo.getMaze().getLines(); i++){
			
			for (int j=0; j<jogo.getMaze().getColumns(); j++)
			{
				if(jogo.getMaze().getTable()[i][j]==' ')
				{
					g.drawImage(floor, (i+1)*size, (j+1)*size, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='X')
				{
					g.drawImage(wall, (i+1)*size, (j+1)*size, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='D')
				{
					g.drawImage(dragon, (i+1)*size, (j+1)*size, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='E')
				{
					g.drawImage(sword, (i+1)*size, (j+1)*size, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='S')
				{
					g.drawImage(exit, (i+1)*size, (j+1)*size, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='H')
				{
					g.drawImage(hero, (i+1)*size, (j+1)*size, null);
				}
				if (jogo.getMaze().getTable()[i][j]=='A')
				{
					g.drawImage(herowithsword, (i+1)*size, (j+1)*size, null);
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
	

}