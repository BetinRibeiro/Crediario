package Painel.Dinamico.Mercadoria;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;

public class JPnlMercadoriaRetorno extends JPanel {
	private JTextField textField;

	/**
	 * Create the 
	 */
	public JPnlMercadoriaRetorno() {
		setLayout(null);
		setBounds(0, 0, 1055, 250);
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel("Valor dos Retornos");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(10, 210, 148, 20);
		add(label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setDisabledTextColor(Color.BLACK);
		textField.setColumns(10);
		textField.setBounds(170, 210, 93, 20);
		add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 160);
		add(scrollPane);
		
		JLabel label_1 = new JLabel("RETORNOS RECEBIDOS");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 11, 216, 25);
		add(label_1);
		
		JButton button = new JButton("Adicionar");
		button.setBounds(925, 10, 120, 25);
		add(button);

	}

}
