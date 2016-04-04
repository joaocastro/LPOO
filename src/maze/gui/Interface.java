package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import maze.logic.Labirinto;
import maze.logic.hero;
import maze.logic.sword;
import maze.logic.dragon;

import maze.cli.Game;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import maze.gui.GraphicsPanel;

import javax.imageio.ImageIO;
import javax.swing.DropMode;

public class Interface extends JFrame implements MouseListener{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea Labirinto;
	private ManualMaze manual;
	private JPanel panel;
	private JTextField textField_2;
	private boolean random_maze = false;
	private boolean created_maze = false;
	private Game g1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public Interface() throws IOException {
		initialize();
		addMouseListener(this);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {

		g1 = new Game();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setPreferredSize(new Dimension(700, 700));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setVisible(true);

		JButton btnNewButton_13 = new JButton("Terminar programa");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnNewButton_13.setBounds(146, 201, 164, 36);
		frame.getContentPane().add(btnNewButton_13);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setText("11");
		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			boolean got = false;	
				try {
					g1.validMaze(Integer.parseInt(textField.getText()));
					}
				catch (IllegalArgumentException a){
					textField_2.setText("Argumento Inválido");
					got = true;
					
					}
				if (!got)	
					g1.addMaze(Integer.parseInt(textField.getText()));
			}
		});
		textField.setBounds(227, 17, 106, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(264, 20, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		//g1.updateBoard();

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setText("1");
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean got = false;
				try {
				g1.validDragons(Integer.parseInt(textField_1.getText()));
				}
				catch (IllegalArgumentException a){
					textField_2.setText("Argumento Inválido");
					got = true;
				}
				if (!got)
					g1.createDragons(Integer.parseInt(textField_1.getText()));
			}
		});
		
		JButton btnGerarLabirintoManual = new JButton("Gerar Labirinto Manual");
		btnGerarLabirintoManual.setBounds(146, 159, 164, 36);
		frame.getContentPane().add(btnGerarLabirintoManual);

		textField_1.setBounds(227, 51, 106, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		//g1.updateBoard();

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(237, 51, 46, 20);
		frame.getContentPane().add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(227, 83, 106, 20);
		comboBox.addItem("Estáticos");
		comboBox.addItem("Móveis");
		comboBox.addItem("Móveis com sono");
		frame.getContentPane().add(comboBox);
				
		JLabel lblTipoDeDrages = new JLabel("Tipo de drag\u00F5es");
		lblTipoDeDrages.setBounds(100, 86, 95, 14);
		frame.getContentPane().add(lblTipoDeDrages);

		JLabel lblDimensoDoLabirinto = new JLabel("Dimens\u00E3o do Labirinto");
		lblDimensoDoLabirinto.setBounds(100, 20, 117, 14);
		frame.getContentPane().add(lblDimensoDoLabirinto);

		JLabel lblNmeroDeDrages = new JLabel("N\u00FAmero de drag\u00F5es");
		lblNmeroDeDrages.setBounds(100, 54, 106, 14);
		frame.getContentPane().add(lblNmeroDeDrages);


		JButton Cima = new JButton("Cima");
		Cima.setEnabled(false);
		Cima.setVisible(false);
		Cima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.updateBoard();
				g1.makePlay("N");
				g1.updateBoard();
				if (!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else if (g1.win())
					Labirinto.setText("Parabens, ganhou o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
				
				g1.Strategy(g1.getStrat());
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());

				if (random_maze && !created_maze)
					panel.repaint();
				else
					manual.repaint();
			}
		});
		Cima.setBounds(293, 114, 90, 40);
		frame.getContentPane().add(Cima);

		JButton Esquerda = new JButton("Esquerda");
		Esquerda.setEnabled(false);
		Esquerda.setVisible(false);
		Esquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.updateBoard();
				g1.makePlay("O");
				g1.updateBoard();
				if (!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else if (g1.win())
					Labirinto.setText("Parabens, ganhou o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
				
				g1.Strategy(g1.getStrat());
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
				

				if (random_maze && !created_maze)
					panel.repaint();
				else
					manual.repaint();
			}
		});
		Esquerda.setBounds(237, 157, 90, 40);
		frame.getContentPane().add(Esquerda);

		JButton Direita = new JButton("Direita");
		Direita.setEnabled(false);
		Direita.setVisible(false);
		Direita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.updateBoard();
				g1.makePlay("E");
				g1.updateBoard();
				if (!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else if (g1.win())
					Labirinto.setText("Parabens, ganhou o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
				
				g1.Strategy(g1.getStrat());
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
				

				if (random_maze && !created_maze)
					panel.repaint();
				else
					manual.repaint();
			}
		});
		Direita.setBounds(335, 157, 90, 40);
		frame.getContentPane().add(Direita);

		JButton Baixo = new JButton("Baixo");
		Baixo.setEnabled(false);
		Baixo.setVisible(false);
		Baixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.updateBoard();
				g1.makePlay("S");
				g1.updateBoard();
				if (!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else if (g1.win())
					Labirinto.setText("Parabens, ganhou o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
				
				g1.Strategy(g1.getStrat());
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
				

				if (random_maze && !created_maze)
					panel.repaint();
				else
					manual.repaint();
			}
		});
		Baixo.setBounds(293, 199, 90, 40);
		frame.getContentPane().add(Baixo);

		JButton btnNewButton = new JButton("Gerar Novo Labirinto");

		btnNewButton.setBounds(146, 116, 164, 36);
		frame.getContentPane().add(btnNewButton);

		Labirinto = new JTextArea();
		Labirinto.setFont(new Font("Courier New", Font.PLAIN, 11));
		Labirinto.setAlignmentY(Component.TOP_ALIGNMENT);
		Labirinto.setAlignmentX(Component.LEFT_ALIGNMENT);
		Labirinto.setEditable(false);
		Labirinto.setBounds(10, 114, 217, 137);
		frame.getContentPane().add(Labirinto);
		Labirinto.setColumns(10);
		Labirinto.setVisible(false);

		Labirinto.setEnabled(true);
		
		JComboBox objetos = new JComboBox();
		objetos.setBounds(700, 20, 106, 20);
		objetos.addItem("Parede");
		objetos.addItem("Saida");
		objetos.addItem("Espada");
		objetos.addItem("Heroi");
		objetos.addItem("Dragao");
		objetos.addItem("Caminho");
		frame.getContentPane().add(objetos);
		objetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manual.setSelectedItem((String)objetos.getSelectedItem());
			}
		});
		
		JButton playCreated = new JButton("Jogar!");
		playCreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				btnNewButton.setVisible(false);
				comboBox.setVisible(false);
				objetos.setVisible(false);
				lblTipoDeDrages.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lblDimensoDoLabirinto.setVisible(false);
				lblNmeroDeDrages.setVisible(false);
				btnNewButton_13.setVisible(false);
				Cima.setVisible(true);
				Baixo.setVisible(true);
				Direita.setVisible(true);
				Esquerda.setVisible(true);
				Cima.setEnabled(true);
				Baixo.setEnabled(true);
				Direita.setEnabled(true);
				Esquerda.setEnabled(true);
				playCreated.setVisible(false);
				btnGerarLabirintoManual.setVisible(false);
				frame.setPreferredSize(new Dimension (700, 700));
				//Labirinto.setText(g1.getMaze().toString());
				Labirinto.setVisible(false);
				
				created_maze = true;
				random_maze = false;
				
				String s = (String)comboBox.getSelectedItem();
				String strat  = "";
				
				switch(s){
				case "Estáticos":
					strat = "1";
					break;
				case "Móveis":
					strat = "2";
					break;
				case "Móveis com sono":
					strat = "3";
					break;	
				}

				g1 = manual.getGame();
				g1.setStrat(strat);
				panel = new GraphicsPanel(g1);
				panel.setBounds(20, 20, 700, 700);
				frame.getContentPane().add(panel);
				frame.pack();
				
				panel.setFocusable(true);
				panel.requestFocus();
				panel.repaint();

			}
		});
		playCreated.setBounds(700, 80, 164, 36);
		frame.getContentPane().add(playCreated);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(100, 2, 233, 14);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnGerarLabirintoManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				btnNewButton.setVisible(false);
				comboBox.setBounds(700, 50, 106, 20);
				lblTipoDeDrages.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lblDimensoDoLabirinto.setVisible(false);
				lblNmeroDeDrages.setVisible(false);
				btnNewButton_13.setVisible(false);

				btnGerarLabirintoManual.setVisible(false);
				Labirinto.setText(g1.getMaze().toString());
				Labirinto.setVisible(false);
				
				random_maze = true;
				created_maze = false;
				
				manual = new ManualMaze(Integer.parseInt(textField.getText()));
				frame.getContentPane().add(manual);
				frame.setPreferredSize(new Dimension (1200, 700));
				manual.setBounds(20, 20, 650, 650);
				frame.pack();
				manual.setFocusable(true);
				manual.requestFocus();
				manual.repaint();
			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				btnNewButton.setVisible(false);
				comboBox.setVisible(false);
				objetos.setVisible(false);
				lblTipoDeDrages.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				textField_2.setVisible(false);
				lblDimensoDoLabirinto.setVisible(false);
				lblNmeroDeDrages.setVisible(false);
				btnNewButton_13.setVisible(false);
				Cima.setVisible(true);
				Baixo.setVisible(true);
				Direita.setVisible(true);
				Esquerda.setVisible(true);
				Cima.setEnabled(true);
				Baixo.setEnabled(true);
				Direita.setEnabled(true);
				Esquerda.setEnabled(true);
				btnGerarLabirintoManual.setVisible(false);
				//Labirinto.setText(g1.getMaze().toString());
				Labirinto.setVisible(false);
				String s = (String)comboBox.getSelectedItem();
				String strat  = "";

				switch(s){
				case "Estáticos":
					strat = "1";
					break;
				case "Móveis":
					strat = "2";
					break;
				case "Móveis com sono":
					strat = "3";
					break;	
				}
				g1.setStrat(strat);
				panel = new GraphicsPanel(g1);
				panel.setBounds(20, 20, 700, 700);
				frame.getContentPane().add(panel);
				frame.pack();
				panel.setFocusable(true);
				panel.requestFocus();
				panel.repaint();
			}
		});

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
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}