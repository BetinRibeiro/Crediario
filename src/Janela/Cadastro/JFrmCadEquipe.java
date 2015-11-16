package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFrmCadEquipe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadEquipe dialog = new JFrmCadEquipe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadEquipe() {
		setTitle("Cadastro de Equipe de Venda");
		setBounds(100, 100, 596, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 10, 46, 14);
		contentPanel.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 75, 343, 20);
		contentPanel.add(textField_1);
		
		JLabel lblDescrio = new JLabel("Titulo da Forma\u00E7\u00E3o da Equipe");
		lblDescrio.setBounds(10, 55, 343, 14);
		contentPanel.add(lblDescrio);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 121, 86, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(106, 121, 247, 20);
		contentPanel.add(textField_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(363, 120, 89, 23);
		contentPanel.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 560, 108);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 165, 86, 20);
		contentPanel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(106, 165, 247, 20);
		contentPanel.add(textField_5);
		
		JButton button = new JButton("Buscar");
		button.setBounds(363, 164, 89, 23);
		contentPanel.add(button);
		
		textField_6 = new JTextField();
		textField_6.setBounds(10, 210, 86, 20);
		contentPanel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblValorDoVale = new JLabel("Valor do Vale");
		lblValorDoVale.setBounds(10, 190, 86, 14);
		contentPanel.add(lblValorDoVale);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 100, 86, 14);
		contentPanel.add(lblCodigo);
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(10, 145, 86, 14);
		contentPanel.add(lblCodigo_1);
		
		JLabel lblVendedorParaInserir = new JLabel("Vendedor para inserir");
		lblVendedorParaInserir.setBounds(106, 145, 206, 14);
		contentPanel.add(lblVendedorParaInserir);
		
		JLabel lblResponsavelPelaEquipe = new JLabel("Responsavel pela Equipe");
		lblResponsavelPelaEquipe.setBounds(106, 100, 247, 14);
		contentPanel.add(lblResponsavelPelaEquipe);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.setBounds(106, 209, 89, 23);
		contentPanel.add(btnInserir);
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
