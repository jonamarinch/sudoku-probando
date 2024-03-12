package pack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MAIN_SUDOKU extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Dificultad> comboBox;
	private Dificultad selectedEnum;
	private VentanaSudoku sudoku;
	private final int FRAME_WIDTH = 600;
	private final int FRAME_HEIGHT = 600;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN_SUDOKU frame = new MAIN_SUDOKU();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MAIN_SUDOKU() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Empezar a jugar");
		int buttonWidth = 200;
		int buttonHeight = 23;
		btnNewButton.setBounds((FRAME_WIDTH-buttonWidth)/2, (FRAME_HEIGHT-buttonHeight)/2, buttonWidth, buttonHeight);
		btnNewButton.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox<>(Dificultad.values());
		int comboWidth = 200;
		int comboHeight = 35;
		comboBox.setBounds((FRAME_WIDTH-comboWidth)/2, FRAME_HEIGHT-comboHeight*7, comboWidth, comboHeight);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("SUDOKU");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 62));
		int labelWidth = 430;
		int labelHeight = 190;
		lblNewLabel.setBounds((FRAME_WIDTH-labelWidth)/2, (FRAME_HEIGHT-labelHeight*3)/2, labelWidth, labelHeight);
		contentPane.add(lblNewLabel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (sudoku == null || !sudoku.isVisible())
		{
			selectedEnum = (Dificultad) comboBox.getSelectedItem();
			JFrame propietario = new JFrame();
			propietario.setResizable(false);
			sudoku = new VentanaSudoku(propietario, "Juego - Sudoku - "+selectedEnum, selectedEnum);
		}
		
	}

}
