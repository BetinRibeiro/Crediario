package Janela.Inserir;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class JFrmInsVendedorEquipe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtId;
	private JTextField txtPromissoaria;
	private JTextField txtVale;
	private JTextField txtVenda;
	private JTextField txtPercentual;
	private JTextField txtEntrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmInsVendedorEquipe dialog = new JFrmInsVendedorEquipe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmInsVendedorEquipe() {
		setTitle("Inserir Vendedor na Equipe");
		setBounds(100, 100, 450, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(10, 11, 46, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Nome ");
		label_1.setBounds(90, 11, 46, 14);
		contentPanel.add(label_1);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(255, 250, 205));
		txtNome.setBounds(86, 31, 237, 20);
		contentPanel.add(txtNome);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBackground(new Color(255, 250, 205));
		txtId.setBounds(10, 31, 63, 20);
		contentPanel.add(txtId);
		
		JLabel label_2 = new JLabel("Promissoria");
		label_2.setBounds(10, 63, 90, 14);
		contentPanel.add(label_2);
		
		txtPromissoaria = new JTextField();
		txtPromissoaria.setColumns(10);
		txtPromissoaria.setBounds(10, 81, 90, 20);
		contentPanel.add(txtPromissoaria);
		
		txtVale = new JTextField();
		txtVale.setColumns(10);
		txtVale.setBounds(115, 81, 90, 20);
		contentPanel.add(txtVale);
		
		JLabel label_3 = new JLabel("Vale");
		label_3.setBounds(115, 63, 90, 14);
		contentPanel.add(label_3);
		
		txtVenda = new JTextField();
		txtVenda.setColumns(10);
		txtVenda.setBounds(10, 125, 90, 20);
		contentPanel.add(txtVenda);
		
		JLabel label_4 = new JLabel("Venda");
		label_4.setBounds(10, 107, 90, 14);
		contentPanel.add(label_4);
		
		txtPercentual = new JTextField();
		txtPercentual.setColumns(10);
		txtPercentual.setBounds(233, 81, 90, 20);
		contentPanel.add(txtPercentual);
		
		JLabel label_5 = new JLabel("% Comiss\u00E3o");
		label_5.setBounds(233, 63, 90, 14);
		contentPanel.add(label_5);
		
		JButton button_1 = new JButton("Buscar");
		button_1.setBounds(333, 30, 89, 23);
		contentPanel.add(button_1);
		
		txtEntrada = new JTextField();
		txtEntrada.setColumns(10);
		txtEntrada.setBounds(115, 125, 90, 20);
		contentPanel.add(txtEntrada);
		
		JLabel label_6 = new JLabel("Entradas");
		label_6.setBounds(115, 107, 90, 14);
		contentPanel.add(label_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
