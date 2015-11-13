package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.Transporte.Transporte;
import Persistence.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class JFrmCadTransporte extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	// variaveis que não podem ser locais dentro da classe
	private JTextField txtID;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JTextField txtAno;
	private JTextField txtPlaca;
	private JTextField txtRenavan;
	private JTextField txtProprietario;
	private JTextField txtAnoDoc;

	private JLabel msn;

	private Dao banco=new Dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadTransporte dialog = new JFrmCadTransporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadTransporte() {
		setTitle("Cadastro de Transporte");
		setBounds(100, 100, 250, 363);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(10, 10, 100, 14);
		contentPanel.add(lblNewLabel);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setBounds(10, 30, 100, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(10, 81, 100, 20);
		contentPanel.add(txtModelo);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 61, 100, 14);
		contentPanel.add(lblModelo);

		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(120, 81, 100, 20);
		contentPanel.add(txtCor);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(120, 61, 100, 14);
		contentPanel.add(lblCor);

		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(10, 132, 100, 20);
		contentPanel.add(txtAno);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(10, 112, 100, 14);
		contentPanel.add(lblAno);

		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(120, 132, 100, 20);
		contentPanel.add(txtPlaca);

		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(120, 112, 100, 14);
		contentPanel.add(lblPlaca);

		JLabel lblRenavan = new JLabel("Renavan");
		lblRenavan.setBounds(10, 163, 100, 14);
		contentPanel.add(lblRenavan);

		txtRenavan = new JTextField();
		txtRenavan.setColumns(10);
		txtRenavan.setBounds(10, 183, 100, 20);
		contentPanel.add(txtRenavan);

		JLabel lblProprietario = new JLabel("Proprietario");
		lblProprietario.setBounds(10, 214, 100, 14);
		contentPanel.add(lblProprietario);

		txtProprietario = new JTextField();
		txtProprietario.setColumns(10);
		txtProprietario.setBounds(10, 234, 210, 20);
		contentPanel.add(txtProprietario);

		JLabel lblAnoDocumento = new JLabel("Ano Documento");
		lblAnoDocumento.setBounds(120, 163, 100, 14);
		contentPanel.add(lblAnoDocumento);

		txtAnoDoc = new JTextField();
		txtAnoDoc.setColumns(10);
		txtAnoDoc.setBounds(120, 183, 100, 20);
		contentPanel.add(txtAnoDoc);

		msn = new JLabel("Todos os campos S\u00E3o Obrigatorios");
		msn.setVisible(false);
		msn.setForeground(Color.RED);
		msn.setBounds(10, 267, 210, 14);
		contentPanel.add(msn);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent acao) {
		String ac = acao.getActionCommand();

		switch (ac) {
		case "OK":
			salvar();
			break;
		case "Cancel":
			dispose();
			break;

		default:
			break;
		}

	}

	private void salvar() {
		try {

			String modelo = txtModelo.getText();
			String cor = txtCor.getText();
			String ano = txtAno.getText();
			String placa = txtPlaca.getText();
			int renavan = Integer.parseInt(txtRenavan.getText());
			String proprietario = txtProprietario.getText();
			int anoDocumento = Integer.parseInt(txtAnoDoc.getText());
			String[] lista = { modelo, cor, ano, placa, proprietario };
			// verifica a existencia de campos vazios
			boolean liberado = verificaValoresVazios(lista);

				
				if (liberado) {
					boolean salvou = false;
					Transporte transporte = new Transporte(modelo, cor, ano, placa, renavan, proprietario, anoDocumento);
					if (txtID.getText().length() > 0) {
						transporte.setId(Integer.parseInt(txtID.getText()));
						salvou = (banco.salvarOuAtualizarObjeto(transporte));
					} else {
						salvou = (banco.salvarObjeto(transporte));
					}
					if (!salvou) {
						JOptionPane.showMessageDialog(contentPanel, "Sistema Não Conseguiu salvar Transporte no banco.");
					}
					if (salvou) {
						JOptionPane.showMessageDialog(contentPanel, "Transporte Criado no banco com sucesso.");
						dispose();
					}

				} else {
					msn.setVisible(true);
				}

		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Coloque numeros nos locais de numeros");
		}

	}

	private boolean verificaValoresVazios(String[] lista) {
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].length() <= 0) {
				msn.setVisible(true);
				return false;

			}
		}

		return true;

	}

	public boolean inserir(Transporte transporte) {

		try {
			setTitle("Alteração de dados transporte");
			txtAno.setText(transporte.getAno());
			txtAnoDoc.setText(String.valueOf(transporte.getAnoDocumento()));
			txtCor.setText(transporte.getCor());
			txtID.setText(String.valueOf(transporte.getId()));
			txtModelo.setText(transporte.getModelo());
			txtPlaca.setText(transporte.getPlaca());
			txtProprietario.setText(transporte.getProprietario());
			txtRenavan.setText(String.valueOf(transporte.getRenavan()));
			return true;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "ERRO - Abra novamente a aplicação.");
			dispose();
			return false;
		}

	}
}
