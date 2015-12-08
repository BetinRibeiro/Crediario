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

import Bin.Equipe.Equipe;
import Bin.Transporte.Transporte;
import Bin.Transporte.TransporteViagem;
import Janela.Pesquisa.JFrmPesTransporte;
import Persistence.Dao;

public class JFrmTransporteEquipe extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescricaoTransporte;
	private JTextField txtIdTransporte;
	private JTextField txtKmInicial;
	private JTextField txtKmFinal;
	private JTextField txtValrManutencao;
	private Dao banco = new Dao();
	private Equipe equipe;
	private TransporteViagem transporteViagem=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JFrmTransporteEquipe dialog = new JFrmTransporteEquipe(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JFrmTransporteEquipe(Equipe equipe) {
		this.equipe = equipe;
		setTitle("Inserss\u00E3o de transporte");
		setBounds(100, 100, 450, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);

		JLabel label = new JLabel("C\u00F3digo");
		label.setBounds(10, 11, 46, 14);
		contentPanel.add(label);

		JLabel lblNomeDotransporte = new JLabel("Transporte");
		lblNomeDotransporte.setBounds(80, 11, 246, 14);
		contentPanel.add(lblNomeDotransporte);

		txtDescricaoTransporte = new JTextField();
		txtDescricaoTransporte.setEnabled(false);
		txtDescricaoTransporte.setColumns(10);
		txtDescricaoTransporte.setBackground(new Color(255, 250, 205));
		txtDescricaoTransporte.setBounds(80, 30, 246, 20);
		contentPanel.add(txtDescricaoTransporte);

		txtIdTransporte = new JTextField();
		txtIdTransporte.setEnabled(false);
		txtIdTransporte.setColumns(10);
		txtIdTransporte.setBackground(new Color(255, 250, 205));
		txtIdTransporte.setBounds(10, 30, 65, 20);
		contentPanel.add(txtIdTransporte);

		JLabel lblKmInicial = new JLabel("Km Inicial");
		lblKmInicial.setBounds(10, 63, 90, 14);
		contentPanel.add(lblKmInicial);

		txtKmInicial = new JTextField();
		txtKmInicial.setText("0");
		txtKmInicial.setDisabledTextColor(Color.BLACK);
		txtKmInicial.setColumns(10);
		txtKmInicial.setBounds(10, 81, 90, 20);
		contentPanel.add(txtKmInicial);

		txtKmFinal = new JTextField();
		txtKmFinal.setText("0");
		txtKmFinal.setDisabledTextColor(Color.BLACK);
		txtKmFinal.setColumns(10);
		txtKmFinal.setBounds(105, 81, 90, 20);
		contentPanel.add(txtKmFinal);

		JLabel lblKmFinal = new JLabel("Km Final");
		lblKmFinal.setBounds(105, 63, 90, 14);
		contentPanel.add(lblKmFinal);

		txtValrManutencao = new JTextField();
		txtValrManutencao.setText("0");
		txtValrManutencao.setDisabledTextColor(Color.BLACK);
		txtValrManutencao.setColumns(10);
		txtValrManutencao.setBounds(205, 81, 90, 20);
		contentPanel.add(txtValrManutencao);

		JLabel lblValorManuteno = new JLabel("Valor Manuten\u00E7\u00E3o");
		lblValorManuteno.setBounds(205, 63, 90, 14);
		contentPanel.add(lblValorManuteno);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(333, 30, 89, 23);
		contentPanel.add(btnBuscar);
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
		case "Buscar":
			buscar();
			break;
		default:
			break;
		}

	}

	private void salvar() {
		try {

			Transporte transporte = (Transporte) banco.buscarPorId(Transporte.class,
					Integer.parseInt(txtIdTransporte.getText()));
			Integer kminicial=Integer.parseInt(txtKmInicial.getText());
			Integer kmfinal=Integer.parseInt(txtKmFinal.getText());
			float manutencao=Float.parseFloat(txtValrManutencao.getText().replace(",","."));
			TransporteViagem transporteIns = new TransporteViagem(kminicial, kmfinal, manutencao, equipe,transporte);

			if (transporteViagem!=null) {
				transporteIns.setId(transporteViagem.getId());
			}
			banco.salvarOuAtualizarObjeto(transporteIns);
			JOptionPane.showMessageDialog(contentPanel, "Salvo com sucesso");
			dispose();
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(contentPanel,  e.getMessage());
		}

	}

	private void buscar() {
		try {

			JFrmPesTransporte func = new JFrmPesTransporte();
			func.moduloEscolher();
			func.setModal(true);
			func.setVisible(true);
			Transporte p = (Transporte) func.getObj();
			txtIdTransporte.setText(String.valueOf(p.getId()));
			txtDescricaoTransporte.setText(String.valueOf(p.getModelo() + " " + String.valueOf(p.getPlaca())));
			func.dispose();
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(contentPanel, "Escolha um transporte para inserir");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			dispose();
		}

	}

	public boolean inserir(TransporteViagem transporte) {
		try {
			this.transporteViagem = transporte;
			txtIdTransporte.setText(String.valueOf(transporte.getTransporte().getId()));
			txtValrManutencao.setText(String.valueOf(transporte.getManutencao()));
			txtDescricaoTransporte.setText(String.valueOf(transporte.getTransporte().getModelo()+" "+transporte.getTransporte().getPlaca()));
		
			txtKmInicial.setText(String.valueOf(transporte.getKminicial()));
			txtKmFinal.setText(String.valueOf(transporte.getKmfinal()));
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage());
			return false;
		}

	}

	


}
