package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class VictoriaSudoku extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public VictoriaSudoku(JFrame propietario, String tituloDifSelecc) {
		super(propietario, tituloDifSelecc);
		setBounds(100, 100, 450, 300);
		contentPanel.setLayout(new BorderLayout());
		JLabel lblNewLabel = new JLabel("¡Enhorabuena! VICTORIA");
		contentPanel.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(lblNewLabel.WIDTH/2);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void dispose()
	{
		super.dispose();
	}
}
