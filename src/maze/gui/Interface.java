package maze.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Proj.Labirinto;
import Proj.hero;
import Proj.sword;
import Proj.dragon;

import maze.cli.Game;
import java.awt.Component;
import java.awt.Font;
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
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
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
		textField.setBounds(137, 11, 106, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(159, 14, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setBounds(137, 45, 106, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(159, 48, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(137, 77, 106, 20);
		comboBox.addItem("Estáticos");
		comboBox.addItem("Móveis");
		comboBox.addItem("Móveis com sono");
		frame.getContentPane().add(comboBox);
		
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
			}
		});
		Cima.setBounds(293, 114, 90, 40);
		frame.getContentPane().add(Cima);
		
		JButton Esquerda = new JButton("Esquerda");
		Esquerda.setEnabled(false);
		Esquerda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Esquerda.setBounds(237, 157, 90, 40);
		frame.getContentPane().add(Esquerda);
		
		JButton Direita = new JButton("Direita");
		Direita.setEnabled(false);
		Direita.setBounds(335, 157, 90, 40);
		frame.getContentPane().add(Direita);
		
		JButton Baixo = new JButton("Baixo");
		Baixo.setEnabled(false);
		Baixo.setBounds(293, 199, 90, 40);
		frame.getContentPane().add(Baixo);
		
		JLabel lblTipoDeDrages = new JLabel("Tipo de drag\u00F5es");
		lblTipoDeDrages.setBounds(10, 80, 95, 14);
		frame.getContentPane().add(lblTipoDeDrages);
		
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
			//Game game = new Game();
			//game.playGame();
		Labirinto.setEnabled(true);
			Labirinto lab = new Labirinto();
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cima.setEnabled(true);
					Baixo.setEnabled(true);
					Direita.setEnabled(true);
					Esquerda.setEnabled(true);
					Labirinto.setText(lab.toString());
				}
			});
		
		
	}
	
		
}
