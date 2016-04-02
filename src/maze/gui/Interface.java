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

public class Interface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextArea Labirinto;

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
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {

		Game g1 = new Game();
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
		btnNewButton_13.setBounds(293, 58, 131, 36);
		frame.getContentPane().add(btnNewButton_13);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				g1.addMaze(Integer.parseInt(textField.getText()));
			}
		});
		textField.setBounds(137, 11, 106, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(159, 14, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		//g1.updateBoard();

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g1.createDragons(Integer.parseInt(textField_1.getText()));
			}
		});
		textField_1.setBounds(137, 45, 106, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		//g1.updateBoard();

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(159, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(137, 77, 106, 20);
		comboBox.addItem("Estáticos");
		comboBox.addItem("Móveis");
		comboBox.addItem("Móveis com sono");
		frame.getContentPane().add(comboBox);
		
		String s = comboBox.getActionCommand();
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
		
		JLabel lblTipoDeDrages = new JLabel("Tipo de drag\u00F5es");
		lblTipoDeDrages.setBounds(10, 80, 95, 14);
		frame.getContentPane().add(lblTipoDeDrages);

		JLabel lblDimensoDoLabirinto = new JLabel("Dimens\u00E3o do Labirinto");
		lblDimensoDoLabirinto.setBounds(10, 14, 117, 14);
		frame.getContentPane().add(lblDimensoDoLabirinto);

		JLabel lblNmeroDeDrages = new JLabel("N\u00FAmero de drag\u00F5es");
		lblNmeroDeDrages.setBounds(10, 48, 106, 14);
		frame.getContentPane().add(lblNmeroDeDrages);

		JButton Cima = new JButton("Cima");
		Cima.setEnabled(false);
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
				
				g1.Strategy(s);
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());

			}
		});
		Cima.setBounds(293, 114, 90, 40);
		frame.getContentPane().add(Cima);

		JButton Esquerda = new JButton("Esquerda");
		Esquerda.setEnabled(false);
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
				
				g1.Strategy(s);
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
			}
		});
		Esquerda.setBounds(237, 157, 90, 40);
		frame.getContentPane().add(Esquerda);

		JButton Direita = new JButton("Direita");
		Direita.setEnabled(false);
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
				
				g1.Strategy(s);
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
			}
		});
		Direita.setBounds(335, 157, 90, 40);
		frame.getContentPane().add(Direita);

		JButton Baixo = new JButton("Baixo");
		Baixo.setEnabled(false);
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
				
				g1.Strategy(s);
				g1.updateBoard();
				
				if(!g1.check())
					Labirinto.setText("Perdeu o jogo!");
				else
					Labirinto.setText(g1.getMaze().toString());
			}
		});
		Baixo.setBounds(293, 199, 90, 40);
		frame.getContentPane().add(Baixo);

		JButton btnNewButton = new JButton("Gerar Novo Labirinto");

		btnNewButton.setBounds(293, 11, 131, 36);
		frame.getContentPane().add(btnNewButton);

		Labirinto = new JTextArea();
		Labirinto.setFont(new Font("Courier New", Font.PLAIN, 11));
		Labirinto.setAlignmentY(Component.TOP_ALIGNMENT);
		Labirinto.setAlignmentX(Component.LEFT_ALIGNMENT);
		Labirinto.setEditable(false);
		Labirinto.setBounds(10, 114, 217, 137);
		frame.getContentPane().add(Labirinto);
		Labirinto.setColumns(10);

		Labirinto.setEnabled(true);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setVisible(false);
				lblNewLabel_1.setVisible(false);
				btnNewButton.setVisible(false);
				comboBox.setVisible(false);
				lblTipoDeDrages.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				lblDimensoDoLabirinto.setVisible(false);
				lblNmeroDeDrages.setVisible(false);
				btnNewButton_13.setVisible(false);
				Cima.setVisible(false);
				Baixo.setVisible(false);
				Direita.setVisible(false);
				Esquerda.setVisible(false);
				Labirinto.setText(g1.getMaze().toString());
				Labirinto.setVisible(false);
				JPanel panel = new GraphicsPanel(g1);
				panel.setBounds(20, 20, 700, 700);
				frame.getContentPane().add(panel);
				frame.pack();
				panel.requestFocus();
			}
		});

	}

}