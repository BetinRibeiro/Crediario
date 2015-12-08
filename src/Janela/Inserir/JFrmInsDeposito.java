package Janela.Inserir;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

import Bin.Equipe.Deposito;
import Bin.Equipe.Equipe;
import Persistence.Dao;
import com.toedter.calendar.JDateChooser;
import java.util.Date;

public class JFrmInsDeposito extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtValor;
	private JTextField txtBanco;
	private Equipe equipe;
	private Dao banco = new Dao();
	private JDateChooser datedeposito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmInsDeposito dialog = new JFrmInsDeposito(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmInsDeposito(Equipe equipe) {
		this.equipe = equipe;
		setTitle("Deposito");
		setBounds(100, 100, 261, 241);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 12, 90, 14);
		contentPanel.add(lblCodigo);

		txtId = new JTextField();
		txtId.setDisabledTextColor(Color.BLACK);
		txtId.setEnabled(false);
		txtId.setColumns(10);
		txtId.setBounds(10, 30, 90, 20);
		contentPanel.add(txtId);

		txtValor = new JTextField();
		txtValor.setText("0,00");
		txtValor.setDisabledTextColor(Color.BLACK);
		txtValor.setColumns(10);
		txtValor.setBounds(10, 79, 90, 20);
		contentPanel.add(txtValor);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 61, 90, 14);
		contentPanel.add(lblValor);

		txtBanco = new JTextField();
		txtBanco.setText("7");
		txtBanco.setDisabledTextColor(Color.BLACK);
		txtBanco.setColumns(10);
		txtBanco.setBounds(10, 128, 222, 20);
		contentPanel.add(txtBanco);

		JLabel lblVenda = new JLabel("Banco");
		lblVenda.setBounds(10, 110, 63, 14);
		contentPanel.add(lblVenda);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(110, 61, 63, 14);
		contentPanel.add(lblData);

		datedeposito = new JDateChooser(new Date());
		datedeposito.setBounds(110, 79, 122, 20);
		contentPanel.add(datedeposito);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("OK");
				btnOk.setActionCommand("OK");
				btnOk.addActionListener(this);
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(this);
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
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
		case "Cancelar":
			dispose();
			break;
		default:
			break;
		}

	}

	private void salvar() {
		try {

			float valor = Float.parseFloat(txtValor.getText().replace(",", "."));
			Date data = datedeposito.getDate();
			String bancoDeposito = txtBanco.getText();
			Bin.Equipe.Deposito deposito = new Bin.Equipe.Deposito(valor, data, bancoDeposito, equipe);

			if (!txtId.getText().equals("")) {
				deposito.setId(Integer.parseInt(txtId.getText()));
			}
			boolean a = banco.salvarOuAtualizarObjeto(deposito);
			if (a) {
				JOptionPane.showMessageDialog(contentPanel, "Salvo com sucesso");
			}
			dispose();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
		}

	}

	public boolean inserirDeposito(Deposito deposito) {
		try {

			txtId.setText(String.valueOf(deposito.getId()));
			datedeposito.setDate(deposito.getData());
			txtBanco.setText(String.valueOf(deposito.getBanco()));
			txtValor.setText(String.valueOf(deposito.getValor()));
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}
	}
}
