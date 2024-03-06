package pack;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class VentanaSudoku extends JDialog {
	
	private JPanel sudokuPanel;
	private static final int SCREEN_SIZE = 900;
	private final int GRID = 9;
	private Random random;
	private Dificultad difSelecc;
	private int[][] numerosSudoku;
	private JPanel[][] tableroSudoku;
	private JTextField[][] rellenoSudoku;
	private JPanel[][] panelRellenoSudoku;
	
	VentanaSudoku(JFrame propietario, String tituloDifSelecc, Dificultad difSelecc)
	{
		super(propietario, tituloDifSelecc);
		this.difSelecc = difSelecc;
//		this.setTitle("Juego - Sudoku - "+ difSelecc);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(SCREEN_SIZE,SCREEN_SIZE);
		this.setResizable(false);

		sudokuPanel = new JPanel();
		sudokuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(sudokuPanel);
		sudokuPanel.setLayout(new GridLayout(GRID, GRID));
		sudokuPanel.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
		
		tableroSudoku = new JPanel[GRID][GRID];
		
		panelRellenoSudoku = new JPanel[GRID][GRID];
		
		rellenoSudoku = new JTextField[GRID][GRID];
		
		numerosSudoku = new int[][] {
			{5, 3, 4, 6, 7, 8, 9, 1, 2},
			{6, 7, 2, 1, 9, 5, 3, 4, 8},
			{1, 9, 8, 3, 4, 2, 5, 6, 7},
			{8, 5, 9, 7, 6, 1, 4, 2, 3},
			{4, 2, 6, 8, 5, 3, 7, 9, 1},
			{7, 1, 3, 9, 2, 4, 8, 5, 6},
			{9, 6, 1, 5, 3, 7, 2, 8, 4},
			{2, 8, 7, 4, 1, 9, 6, 3, 5},
			{3, 4, 5, 2, 8, 6, 1, 7, 9}
		};
		
		for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
            	tableroSudoku[i][j] = new JPanel();
            	panelRellenoSudoku[i][j] = new JPanel();
            	JPanel panel = tableroSudoku[i][j];
            	JPanel panel2 = panelRellenoSudoku[i][j];
            	panel.setPreferredSize(new Dimension(SCREEN_SIZE/9, SCREEN_SIZE/9));
            	Color miColor = new Color(255, 204, 153);
            	panel.setBackground(miColor);
            	panel2.setPreferredSize(new Dimension(SCREEN_SIZE/10, SCREEN_SIZE/10));
            	panel2.setBackground(new Color(0, 0, 0, 0));
            	panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            	// 1 borde rojo:
            	// ***
            	if ((i==2 && j!=2 && j!=3 && j!=5 && j!=6) || (i==5 && j!=2 && j!=3 && j!=5 && j!=6))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,0,1,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	} 
            	else if ((i==3 && j!=2 && j!=3 && j!=5 && j!=6) || (i==6 && j!=2 && j!=3 && j!=5 && j!=6))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(1,0,0,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	} 
            	else if ((j==2 && i!=2 && i!=3 && i!=5 && i!=6) || (j==5 && i!=2 && i!=3 && i!=5 && i!=6))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,0,0,1,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	} 
            	else if ((j==3 && i!=2 && i!=3 && i!=5 && i!=6) || (j==6 && i!=2 && i!=3 && i!=5 && i!=6))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,1,0,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	// 2 bordes rojos:
            	// ***
            	else if ((i==2 && j==2) || (j==5 && i==2) || (j==2 && i==5) || (j==5 && i==5))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,0,1,1,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	else if ((i==3 && j==2) || (j==5 && i==3) || (j==2 && i==6) || (j==5 && i==6))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(1,0,0,1,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	else if ((i==2 && j==3) || (j==3 && i==5) || (j==6 && i==2) || (j==6 && i==5))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,1,1,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	else if ((i==3 && j==3) || (j==3 && i==6) || (j==6 && i==3) || (j==6 && i==6))
            	{
            		panel.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(1,1,0,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	// Ningún borde rojo:
            	// ***
            	else
            	{
            		panel.setBorder(new LineBorder(Color.BLACK, 1));
            	}
            	panel.add(panel2);
            	sudokuPanel.add(panel);
            }
		}
		
		for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
            	rellenoSudoku[i][j] = new JTextField();
            	JTextField tField = rellenoSudoku[i][j];
            	tField.setPreferredSize(new Dimension(16, 16));
            	tField.setOpaque(false);
            	tField.setEditable(false);
            	tField.getDocument().addDocumentListener(new MyDocumentListener());
            	panelRellenoSudoku[i][j].add(tField);
            }
		}
		
		for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
            	rellenoSudoku[i][j].setText(String.valueOf(numerosSudoku[i][j]));
            }
        }
		
		this.pack();
        this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		eliminarNumeros(this.difSelecc);
	}
	
	public void eliminarNumeros(Dificultad dificultad)
	{
		int numHuecos = -1;
		random = new Random();
		
		if (dificultad == Dificultad.FACIL)
		{
			numHuecos = 30;
		}
		else if (dificultad == Dificultad.MEDIO)
		{
			numHuecos = 40;
		}
		else if (dificultad == Dificultad.DIFICIL)
		{
			numHuecos = 50;
		}
		
		for (int i = 0; i < numHuecos;)
		{
			int numAzarX = random.nextInt(GRID);
			int numAzarY= random.nextInt(GRID);
			
			if (!rellenoSudoku[numAzarX][numAzarY].isEditable())
			{
				tableroSudoku[numAzarX][numAzarY].setBackground(Color.WHITE);
				rellenoSudoku[numAzarX][numAzarY].setText(" ");
				rellenoSudoku[numAzarX][numAzarY].setEditable(true);
				i++;
			}
		}
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
	}

}

	class MyDocumentListener implements DocumentListener
	{
		@Override
		public void insertUpdate(DocumentEvent e) 
		{
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
		}
		@Override
		public void changedUpdate(DocumentEvent e) {
			System.out.println("changed");
		}
	}
