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

public class GraphicsPanel extends JPanel implements MouseListener {

	private Game jogo;
	private Image wall, floor, dragon, sword, exit, hero, herowithsword, lost, won, sleepingdragon;
	private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	private int size;
	
	/**
	 * GraphicsPanel constructor
	 * @param g1
	 */
	public GraphicsPanel(Game g1){
		super();
		//this.x=x;
		//this.y=y;
		jogo = g1;
		
		wall = new ImageIcon("parede.png").getImage();
		floor = new ImageIcon("chao.png").getImage();
		dragon = new ImageIcon("dragao.png").getImage();
		sword = new ImageIcon("espada.png").getImage();
		exit = new ImageIcon("saida.png").getImage();
		hero = new ImageIcon("heroi.png").getImage();
		herowithsword = new ImageIcon("heroicomespada.png").getImage();
		lost = new ImageIcon("perdeu.png").getImage();
		won = new ImageIcon("ganhou.png").getImage();
		sleepingdragon = new ImageIcon("dragao_a_dormir.png").getImage();
		size = wall.getWidth(null);
		
		addKeyListener(new KeyListener() {
			
			@Override
		    public void keyPressed(KeyEvent e) {
		    	
		    	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    		jogo.makePlay("E");		
		    		jogo.updateBoard();
		            repaint();
		            
		      
		            g1.Strategy(g1.getStrat());
					g1.updateBoard();
					repaint();
					g1.updateBoard();
					
		        }
		        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        	jogo.makePlay("O");
		        	jogo.updateBoard();
		        	repaint();
				      
		            g1.Strategy(g1.getStrat());
					g1.updateBoard();
					repaint();
					g1.updateBoard();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_UP) {
		        	jogo.makePlay("N");
		        	jogo.updateBoard();	
		        	repaint();
				      
		            g1.Strategy(g1.getStrat());
					g1.updateBoard();
					repaint();
					g1.updateBoard();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		        	jogo.makePlay("S");
		        	jogo.updateBoard();
		        	repaint();
				      
		            g1.Strategy(g1.getStrat());
					g1.updateBoard();
					repaint();
					g1.updateBoard();
		        }
		        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
		        	System.exit(0); //se experimentares fazer 'ESC', funciona
		        }
		    }


		    @Override
		    public void keyReleased(KeyEvent e) {
		        
		    }

			@Override
			public void keyTyped(KeyEvent arg0) {
			}
		});
		
	}
	
	/**
	 * Overload of the paintComponent function. Prints the game in graphics mode
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x = 0;
		int y = 0;
		int MAX_SIZE = 10 * size;
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
				if (jogo.getMaze().getTable()[i][j]=='D')
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

    
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		this.x1=arg0.getX();
		this.x2=arg0.getY();
		int MAX_SIZE = 10 * size;
				
		x1=x1/MAX_SIZE;
		x2=x2/MAX_SIZE;	
		
		//não estou a perceber como é que agora vou buscar o ponto inicial do "quadrado" para pintar
	
		
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
		
	}
	

}