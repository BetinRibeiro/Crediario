package Painel.Dinamico.Depositos;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jboss.jandex.Main;

import Bin.Equipe.Deposito;
import Bin.Equipe.Equipe;
import Janela.Inserir.JFrmInsDeposito;
import Model.Tabela.ModelTabelaDepositos;
import Persistence.Dao;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class JPnlDepositos extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTotalDeposito;
	private JTextField txtPercTempo;
	private JTextField txtTotalVenda;
	private JTextField txtTotalDias;
	private JTextField txtDiaAtual;
	private JTextField txtPercCobrador;
	private JTextField txtPercEsperado;
	private JTextField txtValorAtraso;
	private ModelTabelaDepositos model = new ModelTabelaDepositos();
	private JTable table;
	private Equipe equipeLocal;
	private Dao banco = new Dao();
	DecimalFormat df = new DecimalFormat("0.00");
	DecimalFormat dfp = new DecimalFormat("0.0");
	private float percDia = 1;
	private float totalReal = 1;
	private JLabel msn;
	private float diasCobranca;
	private JLabel msn2;

	/**
	 * Create the
	 */
	public JPnlDepositos(Equipe equipe) {
		setLayout(null);
		this.equipeLocal = equipe;
		JPanel panel = new JPanel();
		setLayout(null);
		JLabel foto2 = new JLabel();
		foto2.setBounds(880, 0, 40, 40);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/019.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		add(foto2);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1055, 500);
		add(panel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 1035, 290);
		add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(this);
		popupMenu.add(mntmDeletar);

		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(this);
		popupMenu.add(mntmAlterar);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(this);
		btnInserir.setBounds(925, 11, 120, 25);
		add(btnInserir);

		JLabel label = new JLabel("LISTA DE DEPOSITOS DA COBRAN\u00C7A");
		label.setForeground(new Color(173, 216, 230));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 11, 364, 25);
		add(label);

		JLabel lblTotalDepos = new JLabel("TOTAL DEPOSI.");
		lblTotalDepos.setBounds(10, 387, 110, 20);
		add(lblTotalDepos);

		txtTotalDeposito = new JTextField("0.0");
		txtTotalDeposito.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDeposito.setEnabled(false);
		txtTotalDeposito.setColumns(10);
		txtTotalDeposito.setBounds(120, 387, 122, 20);
		add(txtTotalDeposito);

		JLabel lblTotalDias = new JLabel("PERCEN. TEMPO");
		lblTotalDias.setBounds(10, 418, 110, 20);
		add(lblTotalDias);

		txtPercTempo = new JTextField("0.0");
		txtPercTempo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercTempo.setEnabled(false);
		txtPercTempo.setColumns(10);
		txtPercTempo.setBounds(120, 418, 122, 20);
		add(txtPercTempo);

		JLabel lblTotal = new JLabel("TOTAL COBRAN.");
		lblTotal.setBounds(10, 354, 110, 20);
		add(lblTotal);

		txtTotalVenda = new JTextField("0.0");
		txtTotalVenda.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalVenda.setEnabled(false);
		txtTotalVenda.setColumns(10);
		txtTotalVenda.setBounds(120, 354, 122, 20);
		add(txtTotalVenda);

		JLabel lblCobrancaAtual = new JLabel("TOTAL DIAS");
		lblCobrancaAtual.setBounds(252, 354, 110, 20);
		add(lblCobrancaAtual);

		txtTotalDias = new JTextField("0.0");
		txtTotalDias.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalDias.setEnabled(false);
		txtTotalDias.setColumns(10);
		txtTotalDias.setBounds(362, 354, 122, 20);
		add(txtTotalDias);

		txtDiaAtual = new JTextField("0.0");
		txtDiaAtual.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiaAtual.setEnabled(false);
		txtDiaAtual.setColumns(10);
		txtDiaAtual.setBounds(362, 387, 122, 20);
		add(txtDiaAtual);

		JLabel lblPercAtual = new JLabel("DIA ATUAL");
		lblPercAtual.setBounds(252, 387, 110, 20);
		add(lblPercAtual);

		JLabel lblDiaAtual = new JLabel("PERC. DPOSITADO");
		lblDiaAtual.setBounds(252, 418, 110, 20);
		add(lblDiaAtual);

		txtPercCobrador = new JTextField("0.0");
		txtPercCobrador.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercCobrador.setEnabled(false);
		txtPercCobrador.setColumns(10);
		txtPercCobrador.setBounds(362, 418, 122, 20);
		add(txtPercCobrador);

		JLabel lblPercEsperado = new JLabel("PERC. ESPERADO");
		lblPercEsperado.setBounds(494, 354, 110, 20);
		add(lblPercEsperado);

		txtPercEsperado = new JTextField("0.0");
		txtPercEsperado.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercEsperado.setColumns(10);
		txtPercEsperado.setBounds(604, 354, 122, 20);
		add(txtPercEsperado);

		JLabel lblValorAtraso = new JLabel("VALOR ATRASO");
		lblValorAtraso.setBounds(494, 387, 110, 20);
		add(lblValorAtraso);

		txtValorAtraso = new JTextField("0.0");
		txtValorAtraso.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorAtraso.setEnabled(false);
		txtValorAtraso.setColumns(10);
		txtValorAtraso.setBounds(604, 387, 122, 20);
		add(txtValorAtraso);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(this);
		btnCalcular.setBounds(736, 354, 89, 23);
		add(btnCalcular);

		msn = new JLabel("");
		msn.setBounds(736, 390, 129, 17);
		add(msn);

		msn2 = new JLabel("");
		msn2.setForeground(new Color(173, 216, 230));
		msn2.setBounds(494, 421, 331, 17);
		add(msn2);
		atualizar();

	}

	private void atualizar() {
		model.removeTudo();

		equipeLocal = (Equipe) banco.buscarPorId(Equipe.class, equipeLocal.getId());

		Set<Deposito> listadeposito = equipeLocal.getDeposito();
		float valorTotal = 0;
		for (Deposito deposito : listadeposito) {
			valorTotal = valorTotal + deposito.getValor();
			model.addRow(deposito);
		}
		txtTotalDeposito.setText(String.valueOf(df.format(valorTotal)));
		txtTotalVenda.setText(String.valueOf(df.format(equipeLocal.getVenda().getVendaPraso())));
		equipeLocal.getCobranca().setDepositos(valorTotal);
		equipeLocal.setTotalDepositos(valorTotal);
		caculos();

		boolean a = banco.salvarOuAtualizarObjeto(equipeLocal.getCobranca());
		System.out.println(a);
	}

	private void caculos() {
		calculaDias();

	}

	private void calculaDias() {

		try {

			Date finl = equipeLocal.getVenda().getUltimoDiaCobranca();
			Date inci = equipeLocal.getVenda().getDiaCobranca();
			Date atual = new Date();
			System.out.println(finl + " " + inci + " " + atual);
			diasCobranca = (int) ((finl.getTime() - inci.getTime()) / 86400000L);
			txtTotalDias.setText(String.valueOf(diasCobranca));
			int diaatual = (int) ((atual.getTime() - inci.getTime()) / 86400000L);
			if (diaatual >= diasCobranca|| diaatual <=0 ) {
				diaatual = (int) diasCobranca;
				msn2.setText("Cobrança finalizada.");
				msn.setVisible(true);
			}
			txtDiaAtual.setText(String.valueOf(diaatual));

			percDia = Float.valueOf(diaatual) / Float.valueOf(diasCobranca);
			System.out.println(percDia + " perc dia");
			txtPercTempo.setText(String.valueOf(dfp.format(percDia * 100)) + "%");

			totalReal = ((percDia) * equipeLocal.getVenda().getVendaPraso());

			float percentualReal = equipeLocal.getCobranca().getDepositos() / totalReal;
			System.out.println(equipeLocal.getCobranca().getDepositos() + "/" + totalReal + "=" + percentualReal);

			txtPercCobrador.setText(String.valueOf(df.format(percentualReal * 100)) + "%");
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Você precisa definir a data de inicio e término da cobrança");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		System.out.println(acao);

		switch (acao) {
		case "Inserir":
			JFrmInsDeposito cadCar = new JFrmInsDeposito(equipeLocal);
			cadCar.setModal(true);
			cadCar.setVisible(true);
			atualizar();
			break;

		case "Alterar":
			Deposito deposito = (Deposito) model.getObj(table.getSelectedRow());
			JFrmInsDeposito altCar = new JFrmInsDeposito(equipeLocal);
			altCar.inserirDeposito(deposito);
			altCar.setModal(true);
			altCar.setVisible(true);
			atualizar();
			break;
		case "Deletar":
			Deposito carrad = (Deposito) model.getObj(table.getSelectedRow());
			banco.deletarObjeto(carrad);
			atualizar();
			break;
		case "Calcular":
			calcular();
			break;
		default:
			break;
		}

	}

	private void calcular() {
		float perc = Float.parseFloat(txtPercEsperado.getText().replace(",", ".")) / 100;
		float valorEsperado = perc * totalReal;
		float valorAtraso = equipeLocal.getCobranca().getDepositos() - valorEsperado;
		txtValorAtraso.setText(String.valueOf(df.format(valorAtraso)));

		if (valorAtraso < 0) {
			msn.setText("Falta depositar");
			msn.setForeground(Color.RED);
		} else {
			msn.setForeground(Color.WHITE);
			msn.setForeground(Color.WHITE);
		}

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
