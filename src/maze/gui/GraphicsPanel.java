package maze.gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class GraphicsPanel extends JPanel {

	private int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
	private static final long serialVersionUID = 1L;
	Image wall;
	
	public GraphicsPanel() {
		wall = new ImageIcon("chao.png").getImage();
		/*addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);*/
	}

	public void paintComponent(Graphics g) {
		
		/*Image background;
		ImageIcon ii;
		ii= new ImageIcon(this.getClass().getResource("chao.png"));
		background = ii.getImage();*/
		
		super.paintComponent(g); // limpa fundo …
		g.setColor(Color.BLUE);
		
		g.drawImage(wall, 20, 20, 300, 300, this);
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
