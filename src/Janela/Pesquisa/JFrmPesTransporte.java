package Janela.Pesquisa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bin.Transporte.Transporte;
import Janela.Cadastro.JFrmCadTransporte;
import Model.Tabela.ModelTabelaTransporte;
import Persistence.Dao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Component;

public class JFrmPesTransporte extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ModelTabelaTransporte model = new ModelTabelaTransporte();
	private JTextField txtBusca;
	private Dao banco = new Dao();
	private JButton btnAlterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmPesTransporte dialog = new JFrmPesTransporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmPesTransporte() {
		setTitle("Pesquisa Transporte");
		setBounds(100, 100, 557, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 541, 229);
		contentPanel.add(scrollPane);

		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				txtBusca = new JTextField();
				txtBusca.setAlignmentX(Component.RIGHT_ALIGNMENT);
				buttonPane.add(txtBusca);
				txtBusca.setColumns(20);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				buttonPane.add(btnBuscar);
				btnBuscar.addActionListener(this);
			}
			{
				btnAlterar = new JButton("Alterar");
				btnAlterar.setActionCommand("Alterar");
				buttonPane.add(btnAlterar);
				getRootPane().setDefaultButton(btnAlterar);
				btnAlterar.addActionListener(this);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
		buscar();
	}

	void buscar() {
		try {
			model.removeTudo();
			List<?> lista = banco.BuscaNome(Transporte.class, txtBusca.getText(), "placa");
			int tamanho=lista.size();
			if (lista.size()>=30) {
				tamanho=30;
			}
			for (int i = 0; i < tamanho; i++) {
				Transporte classif = (Transporte) lista.get(i);
				model.addRow(classif);
				btnAlterar.setEnabled(true);
			}
		} catch (Exception e) {
			btnAlterar.setEnabled(false);
			JOptionPane.showMessageDialog(contentPanel, "ERRO ao buscar um Transporte.");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		switch (acao) {
		case "Cancel":
			dispose();
			break;
		case "Buscar":
			buscar();
			break;
		case "Alterar":
			alterar();
			break;

		default:
			break;
		}

	}

	private void alterar() {
		Transporte transporte = (Transporte) banco.buscarPorId(
				Transporte.class,
				(Integer) table.getValueAt(
						table.getSelectedRow(), 0));
		JFrmCadTransporte c = new JFrmCadTransporte();
		c.inserir(transporte);
		c.setVisible(true);
	}
}
