package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.Endereco;
import Bin.Funcionario.Funcionario;
import Persistence.Dao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class JFrmCadFuncionario extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtFone1;
	private JTextField txtLougradouro;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtFone2;
	private JComboBox boxUF;
	String[] uf = { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE",
			"PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO" };
	private JLabel msn;
	private Dao banco = new Dao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadFuncionario dialog = new JFrmCadFuncionario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadFuncionario() {
		setTitle("Cadastro de Funcionario");
		setBounds(100, 100, 327, 473);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel = new JLabel("Codigo");
			lblNewLabel.setBounds(10, 11, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtId = new JTextField();
			txtId.setEnabled(false);
			txtId.setBounds(10, 31, 86, 20);
			contentPanel.add(txtId);
			txtId.setBackground(new Color(255, 250, 205));
			txtId.setColumns(10);
		}
		{
			JLabel lblNome = new JLabel("Nome ");
			lblNome.setBounds(10, 62, 133, 14);
			contentPanel.add(lblNome);
		}
		{
			txtNome = new JTextField();
			txtNome.setColumns(10);
			txtNome.setBounds(10, 82, 277, 20);
			contentPanel.add(txtNome);
		}
		{
			JLabel lblSobrenome = new JLabel("Sobrenome");
			lblSobrenome.setBounds(10, 113, 133, 14);
			contentPanel.add(lblSobrenome);
		}
		{
			txtSobrenome = new JTextField();
			txtSobrenome.setColumns(10);
			txtSobrenome.setBounds(10, 133, 277, 20);
			contentPanel.add(txtSobrenome);
		}
		{
			JLabel lblTelefone = new JLabel("Telefone ");
			lblTelefone.setBounds(10, 160, 133, 14);
			contentPanel.add(lblTelefone);
		}
		{
			txtFone1 = new JTextField();
			txtFone1.setColumns(10);
			txtFone1.setBounds(10, 180, 133, 20);
			contentPanel.add(txtFone1);
		}
		{
			JLabel lblTelefone_1 = new JLabel("Telefone");
			lblTelefone_1.setBounds(154, 160, 115, 14);
			contentPanel.add(lblTelefone_1);
		}
		{
			txtLougradouro = new JTextField();
			txtLougradouro.setColumns(10);
			txtLougradouro.setBounds(10, 231, 277, 20);
			contentPanel.add(txtLougradouro);
		}
		{
			JLabel lblLougradouro = new JLabel("Lougradouro");
			lblLougradouro.setBounds(10, 211, 133, 14);
			contentPanel.add(lblLougradouro);
		}
		{
			txtBairro = new JTextField();
			txtBairro.setColumns(10);
			txtBairro.setBounds(10, 282, 168, 20);
			contentPanel.add(txtBairro);
		}
		{
			JLabel lblBairro = new JLabel("Bairro");
			lblBairro.setBounds(10, 262, 133, 14);
			contentPanel.add(lblBairro);
		}
		{
			txtNumero = new JTextField();
			txtNumero.setColumns(10);
			txtNumero.setBounds(201, 282, 86, 20);
			contentPanel.add(txtNumero);
		}
		{
			JLabel lblNumero = new JLabel("Numero");
			lblNumero.setBounds(201, 262, 68, 14);
			contentPanel.add(lblNumero);
		}
		{
			txtCidade = new JTextField();
			txtCidade.setColumns(10);
			txtCidade.setBounds(10, 333, 168, 20);
			contentPanel.add(txtCidade);
		}
		{
			JLabel lblCidade = new JLabel("Cidade");
			lblCidade.setBounds(10, 313, 133, 14);
			contentPanel.add(lblCidade);
		}
		{
			JLabel lblUf = new JLabel("UF");
			lblUf.setBounds(201, 313, 68, 14);
			contentPanel.add(lblUf);
		}
		{
			txtFone2 = new JTextField();
			txtFone2.setColumns(10);
			txtFone2.setBounds(153, 180, 134, 20);
			contentPanel.add(txtFone2);
		}

		boxUF = new JComboBox(uf);
		boxUF.setBounds(201, 333, 86, 20);
		contentPanel.add(boxUF);
		boxUF.setSelectedIndex(5);
		{
			msn = new JLabel("Todos os Campos s\u00E3o Obrigatorios");
			msn.setVisible(false);
			msn.setForeground(Color.RED);
			msn.setBounds(10, 377, 277, 14);
			contentPanel.add(msn);
		}
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
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
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

			String nome = txtNome.getText();
			String sobrenome = txtSobrenome.getText();
			String numero = txtNumero.getText();
			String lougradouro = txtLougradouro.getText();
			String cidade = txtCidade.getText();
			String bairro = txtBairro.getText();
			String ufEndereco = (String) boxUF.getSelectedItem();
			String cep = txtCidade.getText();
			Endereco endereco = new Endereco();
			endereco.setNumero(numero);
			endereco.setCep(cep);
			endereco.setCidade(cidade);
			endereco.setLougradouro(lougradouro);
			endereco.setBairro(bairro);
			endereco.setUfEndereco(ufEndereco);
			long telefone1 = Long.parseLong(txtFone1.getText());
			long telefone2 = Long.parseLong(txtFone2.getText());
		
			String[] lista = { numero, lougradouro, cidade, bairro, ufEndereco, cep, nome, sobrenome };
			// verifica a existencia de campos vazios
			boolean liberado = verificaValoresVazios(lista);
			if (String.valueOf(telefone1).length()<10||String.valueOf(telefone2).length()<10) {
				JOptionPane.showMessageDialog(contentPanel, "Digite Pelomenos 10 digitos no telefone incluindo o DDD.");
				liberado=false;
			}

			if (liberado) {
				boolean salvou = false;
				Funcionario funcionario = new Funcionario(nome, sobrenome, endereco, telefone1, telefone2);
				System.out.println(txtId.getText().length());
				if (txtId.getText().length() > 0) {
					funcionario.setId(Integer.parseInt(txtId.getText()));
					salvou = (banco.salvarOuAtualizarObjeto(funcionario));
				} else {
					System.out.println("ENTROU AQUI");
					salvou = (banco.salvarObjeto(funcionario));
				}
				if (!salvou) {
					JOptionPane.showMessageDialog(contentPanel, "Sistema Não Conseguiu salvar Funcionario no banco.");
				}
				if (salvou) {
					JOptionPane.showMessageDialog(contentPanel, "Funcionario Criado no banco com sucesso.");
					dispose();
				}

			} else {
				msn.setVisible(true);
			}

		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Preencha os campos de telefone e coloque somente numeros");
		}

	}

	private boolean verificaValoresVazios(String[] lista) {
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
			if (lista[i].length() <= 0) {
				msn.setVisible(true);
				return false;

			}
		}

		return true;
	}
	
	//função utilizada de fora da classe para inserir produtos que serão alterados 
	public boolean inserir(Funcionario funcionario) {
		try {
			setTitle("Alteração de dados Funcionario");
			txtId.setText(String.valueOf(funcionario.getId()));
			txtBairro.setText(String.valueOf(funcionario.getEndereco().getBairro()));
			txtCidade.setText(String.valueOf(funcionario.getEndereco().getCep()));
			txtFone1.setText(String.valueOf(funcionario.getTelefone1()));
			txtFone2.setText(String.valueOf(funcionario.getTelefone2()));
			txtLougradouro.setText(String.valueOf(funcionario.getEndereco().getLougradouro()));
			txtNome.setText(String.valueOf(funcionario.getNome()));
			txtSobrenome.setText(String.valueOf(funcionario.getSobrenome()));
			txtNumero.setText(String.valueOf(funcionario.getEndereco().getNumero()));
			txtBairro.setText(String.valueOf(funcionario.getEndereco().getBairro()));
			boxUF.setSelectedItem(funcionario.getEndereco().getUfEndereco());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, "Erro no sistema");
			dispose();
			return false;
		}
		
		
	}
}
