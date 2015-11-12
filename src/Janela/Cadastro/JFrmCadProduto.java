package Janela.Cadastro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.Produto.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class JFrmCadProduto extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField txtEstMin;
	private JLabel msn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmCadProduto dialog = new JFrmCadProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmCadProduto() {
		setTitle("Cadastro de Produto");
		setBounds(100, 100, 308, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("C\u00F3digo");
			lblNewLabel.setBounds(10, 10, 86, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtID = new JTextField();
			txtID.setEnabled(false);
			txtID.setBounds(10, 30, 86, 20);
			contentPanel.add(txtID);
			txtID.setColumns(10);
		}
		{
			JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
			lblDescrio.setBounds(10, 60, 144, 14);
			contentPanel.add(lblDescrio);
		}
		{
			txtDescricao = new JTextField();
			txtDescricao.setColumns(10);
			txtDescricao.setBounds(10, 80, 237, 20);
			contentPanel.add(txtDescricao);
		}
		{
			JLabel lblPreo = new JLabel("Pre\u00E7o");
			lblPreo.setBounds(10, 110, 115, 14);
			contentPanel.add(lblPreo);
		}
		{
			txtPreco = new JTextField();
			txtPreco.setColumns(10);
			txtPreco.setBounds(10, 130, 86, 20);
			contentPanel.add(txtPreco);
		}
		{
			txtEstMin = new JTextField();
			txtEstMin.setColumns(10);
			txtEstMin.setBounds(10, 181, 86, 20);
			contentPanel.add(txtEstMin);
		}
		{
			JLabel lblEstoqueMin = new JLabel("Estoque Min");
			lblEstoqueMin.setBounds(10, 161, 115, 14);
			contentPanel.add(lblEstoqueMin);
		}
		{
			 msn = new JLabel("Preenchimento Obrigatorio em Todos Campos");
			msn.setVisible(false);
			msn.setForeground(Color.RED);
			msn.setBounds(10, 234, 271, 14);
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
		
		System.out.println(acao);
		switch (acao) {
		case "OK":
			salvar();
			break;
			
		case"Cancel":
			dispose();
			break;

		default:
			break;
		}
		
	}

	private void salvar() {
		try {
			
		
		String descricao=txtDescricao.getText();
		float estoqueMin=Float.parseFloat(txtEstMin.getText());
		float preco=Float.parseFloat(txtPreco.getText());
		
		if (descricao.length()>0) {
			Produto produto = new Produto(descricao, estoqueMin, preco);
			if (txtID.getText().length() > 0) {
				produto.setId(Integer.parseInt(txtID.getText()));
				// quando entrar nesse caso temos que fazer uma alteração
			}
			// TODO verifique quando colocar no banco se a quantidade de
			// caracteres realmente bate com o que esta espeficicado no
			// banco
		}else {
			msn.setVisible(true);
		}
		
		
		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Inserir valores validos nos campos numericos");
		}
		
	}

}
