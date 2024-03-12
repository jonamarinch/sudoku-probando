package pack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainSudoku extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<Dificultad> comboBox;
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
                    MainSudoku frame = new MainSudoku();
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
    public MainSudoku() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Sudoku");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton startButton = new JButton("Empezar a jugar");
        int buttonWidth = 200;
        int buttonHeight = 40;
        startButton.setBounds((FRAME_WIDTH - buttonWidth) / 2, (FRAME_HEIGHT - buttonHeight) / 2, buttonWidth, buttonHeight);
        startButton.addActionListener(this);
        contentPane.add(startButton);

        comboBox = new JComboBox<>(Dificultad.values());
        int comboWidth = 200;
        int comboHeight = 35;
        comboBox.setBounds((FRAME_WIDTH - comboWidth) / 2, FRAME_HEIGHT - comboHeight * 7, comboWidth, comboHeight);
        contentPane.add(comboBox);

        JLabel titleLabel = new JLabel("SUDOKU");
        titleLabel.setForeground(Color.RED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 62));
        int labelWidth = 430;
        int labelHeight = 190;
        titleLabel.setBounds((FRAME_WIDTH - labelWidth) / 2, (FRAME_HEIGHT - labelHeight * 3) / 2, labelWidth, labelHeight);
        contentPane.add(titleLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (sudoku == null || !sudoku.isVisible()) {
            Dificultad selectedEnum = (Dificultad) comboBox.getSelectedItem();
            sudoku = new VentanaSudoku(this, "Juego - Sudoku - " + selectedEnum, selectedEnum);
        }
    }

}
