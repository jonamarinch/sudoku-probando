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
import java.awt.Font;

public class VentanaSudoku extends JDialog {
	
	private JPanel sudokuPanel;
	private static final int SCREEN_SIZE = 900;
	private final int GRID = 9;
	private Random random;
	private Dificultad difSelecc;
	private int[][] numerosSudoku;
	private JTextField[][] tableroSudoku;
	private VictoriaSudoku victoria;
	
	VentanaSudoku(JFrame propietario, String tituloDifSelecc, Dificultad difSelecc)
	{
		super(propietario, tituloDifSelecc);	
		
		this.difSelecc = difSelecc;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(SCREEN_SIZE,SCREEN_SIZE);
		this.setResizable(false);

		sudokuPanel = new JPanel();
		sudokuPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(sudokuPanel);
		sudokuPanel.setLayout(new GridLayout(GRID, GRID));
		sudokuPanel.setPreferredSize(new Dimension(SCREEN_SIZE, SCREEN_SIZE));
		
		tableroSudoku = new JTextField[GRID][GRID];
		
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
            	tableroSudoku[i][j] = new JTextField();
            	JTextField tField = tableroSudoku[i][j];
            	tField.setPreferredSize(new Dimension(SCREEN_SIZE/9, SCREEN_SIZE/9));
            	Color miColor = new Color(255, 204, 153);
            	tField.setBackground(miColor);
            	tField.setPreferredSize(new Dimension(16, 16));
            	tField.setEditable(false);
            	tField.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 25));
            	tField.setHorizontalAlignment(tField.getWidth()/2);
            	// 1 borde rojo:
            	// ***
            	if ((i==2 && j!=2 && j!=3 && j!=5 && j!=6) || (i==5 && j!=2 && j!=3 && j!=5 && j!=6))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,0,1,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	} 
            	else if ((i==3 && j!=2 && j!=3 && j!=5 && j!=6) || (i==6 && j!=2 && j!=3 && j!=5 && j!=6))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(1,0,0,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	} 
            	else if ((j==2 && i!=2 && i!=3 && i!=5 && i!=6) || (j==5 && i!=2 && i!=3 && i!=5 && i!=6))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,0,0,1,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	} 
            	else if ((j==3 && i!=2 && i!=3 && i!=5 && i!=6) || (j==6 && i!=2 && i!=3 && i!=5 && i!=6))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,1,0,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	// 2 bordes rojos:
            	// ***
            	else if ((i==2 && j==2) || (j==5 && i==2) || (j==2 && i==5) || (j==5 && i==5))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,0,1,1,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	else if ((i==3 && j==2) || (j==5 && i==3) || (j==2 && i==6) || (j==5 && i==6))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(1,0,0,1,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	else if ((i==2 && j==3) || (j==3 && i==5) || (j==6 && i==2) || (j==6 && i==5))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(0,1,1,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	else if ((i==3 && j==3) || (j==3 && i==6) || (j==6 && i==3) || (j==6 && i==6))
            	{
            		tField.setBorder(new CompoundBorder(
            				BorderFactory.createMatteBorder(1,1,0,0,Color.RED),
            				BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK)));
            	}
            	// Ningún borde rojo:
            	// ***
            	else
            	{
            		tField.setBorder(new LineBorder(Color.BLACK, 1));
            	}
            	sudokuPanel.add(tField);
            }
		}
		
		for (int i = 0; i < GRID; i++) {
            for (int j = 0; j < GRID; j++) {
            	tableroSudoku[i][j].setText(String.valueOf(numerosSudoku[i][j]));
            	tableroSudoku[i][j].getDocument().addDocumentListener(new verificadorSudoku());
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
		
		if (dificultad == Dificultad.REGALO)
		{
			numHuecos = 1;
		}
		else if (dificultad == Dificultad.FÁCIL)
		{
			numHuecos = 30;
		}
		else if (dificultad == Dificultad.MEDIO)
		{
			numHuecos = 40;
		}
		else if (dificultad == Dificultad.DIFÍCIL)
		{
			numHuecos = 50;
		}
		else if (dificultad == Dificultad.VACÍO)
		{
			numHuecos = 81;
		}
		
		for (int i = 0; i < numHuecos;)
		{
			int numAzarX = random.nextInt(GRID);
			int numAzarY= random.nextInt(GRID);
			
			if (!tableroSudoku[numAzarX][numAzarY].isEditable())
			{
				tableroSudoku[numAzarX][numAzarY].setBackground(Color.WHITE);
				tableroSudoku[numAzarX][numAzarY].setText("");
				tableroSudoku[numAzarX][numAzarY].setEditable(true);
				i++;
			}
		}
	}
	
	public int[] regenerarVector(int[] vector)
	{
		for (int i = 0; i < vector.length; i++)
		{
			vector[i] = i+1;
		}
		
		return vector;
	}
	
	public boolean verificarSudoku()
	{
		boolean resultadoVerSud = true;
		int[] vector1_9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		// Verificar FILAS
		// ***
		
		for (int i=0; i < tableroSudoku.length; i++)
		{
			// En cada fila se va regenerando el vector
			vector1_9 = regenerarVector(vector1_9);
			
			// Se va descartando cada casilla de la fila
			for (int l = 0; l < tableroSudoku.length; l++)
			{
				for (int e=0; e < vector1_9.length; e++)
				{
					if (tableroSudoku[i][l].getText().equals(String.valueOf(vector1_9[e])))
					{
						vector1_9[e] = -1;
					}
				}
			}
			
			// Se comprueba si todas las casillas han sido descartadas
			for (int t = 0; t < vector1_9.length; t++)
			{
				if (vector1_9[t] != -1)
				{
					resultadoVerSud = false;
					return resultadoVerSud;
				}
			}
		}
		
		// Verificar COLUMNAS
		// ***
		
		for (int i=0; i < tableroSudoku.length; i++)
		{
			// En cada columna se va regenerando el vector
			vector1_9 = regenerarVector(vector1_9);
			
			// Se va descartando cada casilla de la columna
			for (int l = 0; l < tableroSudoku.length; l++)
			{
				for (int e=0; e < vector1_9.length; e++)
				{
					if (tableroSudoku[l][i].getText().equals(String.valueOf(vector1_9[e])))
					{
						vector1_9[e] = -1;
					}
				}
			}
			
			// Se comprueba si todas las casillas han sido descartadas
			for (int t = 0; t < vector1_9.length; t++)
			{
				if (vector1_9[t] != -1)
				{
					resultadoVerSud = false;
					return resultadoVerSud;
				}
			}
		}
		
		// Verificar SECCIONES
		// ***
		
		for (int i=0; i < tableroSudoku.length; i+=3)
		{
			for (int j=0; j < tableroSudoku.length; j+=3)
			{
				// En cada sección se va regenerando el vector
				vector1_9 = regenerarVector(vector1_9);
				
				// Se van descartando las primeras 3 casillas de la sección
				for (int l=0; l < tableroSudoku.length/3; l++)
				{
					for (int e=0; e < vector1_9.length; e++)
					{
						if (tableroSudoku[i][j+l].getText().equals(String.valueOf(vector1_9[e])))
						{
							vector1_9[e] = -1;
						}
					}
				}
				
				// Se van descartando otras 3 casillas de la sección
				for (int l=0; l < tableroSudoku.length/3; l++)
				{
					for (int e=0; e < vector1_9.length; e++)
					{
						if (tableroSudoku[i+1][j+l].getText().equals(String.valueOf(vector1_9[e])))
						{
							vector1_9[e] = -1;
						}
					}
				}
				
				// Se van descartando las últimas 3 casillas de la sección
				for (int l=0; l < tableroSudoku.length/3; l++)
				{
					for (int e=0; e < vector1_9.length; e++)
					{
						if (tableroSudoku[i+2][j+l].getText().equals(String.valueOf(vector1_9[e])))
						{
							vector1_9[e] = -1;
						}
					}
				}
				
				// Se comprueba si todas las casillas han sido descartadas
				for (int t = 0; t < vector1_9.length; t++)
				{
					if (vector1_9[t] != -1)
					{
						resultadoVerSud = false;
						return resultadoVerSud;
					}
				}
			}
		}
		
		return resultadoVerSud;
	}
	
	public boolean booleanRellenado()
	{
		boolean estaRell = true;
		
		for (int i = 0; i < GRID; i++)
		{
			for (int j = 0; j < GRID; j++)
			{
				
				if (tableroSudoku[i][j].getText().isEmpty())
				{
					estaRell = false;
					return estaRell;
				}
			}
		}
		
		return estaRell;
	}
	
	@Override
	public void dispose()
	{
		super.dispose();
	}
	
	private class verificadorSudoku implements DocumentListener
	{
		@Override
		public void insertUpdate(DocumentEvent e) 
		{
			if ((victoria == null || !victoria.isVisible()) && booleanRellenado() == true && verificarSudoku() == true)
			{
				JFrame propietario = new JFrame();
				propietario.setResizable(false);
				victoria = new VictoriaSudoku(propietario, "VICTORIA");
			}
		}
		@Override
		public void removeUpdate(DocumentEvent e) 
		{
		}
		@Override
		public void changedUpdate(DocumentEvent e) 
		{
		}
	}
}