package pack;

import javax.swing.*;
import java.awt.*;

public class VictoriaSudoku extends JDialog {

    private static final long serialVersionUID = 1L;

    /**
     * Create the dialog.
     */
    public VictoriaSudoku(JFrame propietario, String tituloDifSelecc) {
        super(propietario, tituloDifSelecc, true); // Hacer que el diálogo sea modal
        initComponents();
        setLocationRelativeTo(propietario); // Centrar el diálogo en relación con su propietario
		setVisible(true);
    }

    private void initComponents() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("¡Enhorabuena! VICTORIA");
        setSize(450, 150);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        JLabel lblMessage = new JLabel("¡Enhorabuena! Has ganado.");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPanel.add(lblMessage, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(e -> dispose()); // Cerrar el diálogo al hacer clic en el botón "OK"
        buttonPanel.add(btnOk);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(contentPanel);
    }
}
