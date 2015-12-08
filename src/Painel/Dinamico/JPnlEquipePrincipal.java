package Painel.Dinamico;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

import Bin.Equipe.Equipe;
import Painel.Dinamico.ReceitasDespesasExtra.JPnlDespesasExtra;
import Painel.Dinamico.ReceitasDespesasExtra.JPnlReceitasExtra;
import Persistence.Dao;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPnlEquipePrincipal extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtReceitaPreso;
	private JTextField txtReceitavista;
	private JTextField txtReceitaTotal;
	private JTextField txtReceitaextra;
	private JTextField txtComissaoChefe;
	private JTextField txtCustoReal;
	private JTextField txtCustoRetorno;
	private JTextField txtCustoCarradas;
	private JTextField txtComissaoVendedor;
	private JTextField txtComissaoCobrador;
	private JTextField txtDespLocal;
	private JTextField txtComissaoTotal;
	private JTextField txtDespTotal;
	private JTextField txtDespExtra;
	private JTextField txtDespCobranca;
	private JTextField txtDespVenda;
	private Equipe equipe;
	private Dao banco = new Dao();
	private JPanel painelEntradasSaidas;
	private JTextField txtLucroBruto;
	private JTextField txtLucroLiquido;

	/**
	 * Create the panel.
	 */
	public JPnlEquipePrincipal(Equipe equipe) {
		this.equipe = equipe;
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1075, 570);
		setLayout(null);

		JLabel lblInformaesDaEquipe = new JLabel("Informa\u00E7\u00F5es da Equipe");
		lblInformaesDaEquipe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInformaesDaEquipe.setBounds(10, 10, 347, 25);
		add(lblInformaesDaEquipe);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 46, 318, 495);
		add(panel);
		panel.setLayout(null);

		JLabel lblPraso = new JLabel("RECEITA. PRASO");
		lblPraso.setBounds(10, 11, 110, 20);
		panel.add(lblPraso);

		txtReceitaPreso = new JTextField("0,00");
		txtReceitaPreso.setHorizontalAlignment(SwingConstants.CENTER);
		txtReceitaPreso.setForeground(new Color(255, 250, 205));
		txtReceitaPreso.setEnabled(false);
		txtReceitaPreso.setDisabledTextColor(Color.BLACK);
		txtReceitaPreso.setColumns(10);
		txtReceitaPreso.setBackground(new Color(255, 250, 205));
		txtReceitaPreso.setBounds(120, 11, 122, 20);
		panel.add(txtReceitaPreso);

		JLabel lblVista = new JLabel("RECEITA. VISTA");
		lblVista.setBounds(10, 37, 110, 20);
		panel.add(lblVista);

		txtReceitavista = new JTextField("0,00");
		txtReceitavista.setHorizontalAlignment(SwingConstants.CENTER);
		txtReceitavista.setForeground(new Color(255, 250, 205));
		txtReceitavista.setEnabled(false);
		txtReceitavista.setDisabledTextColor(Color.BLACK);
		txtReceitavista.setColumns(10);
		txtReceitavista.setBackground(new Color(255, 250, 205));
		txtReceitavista.setBounds(120, 37, 122, 20);
		panel.add(txtReceitavista);

		JLabel lblTotalReceitas = new JLabel("TOTAL RECEITAS");
		lblTotalReceitas.setBounds(20, 88, 110, 20);
		panel.add(lblTotalReceitas);

		txtReceitaTotal = new JTextField("0,00");
		txtReceitaTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtReceitaTotal.setForeground(new Color(255, 250, 205));
		txtReceitaTotal.setEnabled(false);
		txtReceitaTotal.setDisabledTextColor(Color.BLACK);
		txtReceitaTotal.setColumns(10);
		txtReceitaTotal.setBackground(new Color(255, 250, 205));
		txtReceitaTotal.setBounds(150, 88, 122, 20);
		panel.add(txtReceitaTotal);

		txtReceitaextra = new JTextField("0,00");
		txtReceitaextra.setHorizontalAlignment(SwingConstants.CENTER);
		txtReceitaextra.setForeground(new Color(255, 250, 205));
		txtReceitaextra.setEnabled(false);
		txtReceitaextra.setDisabledTextColor(Color.BLACK);
		txtReceitaextra.setColumns(10);
		txtReceitaextra.setBackground(new Color(255, 250, 205));
		txtReceitaextra.setBounds(120, 62, 122, 20);
		panel.add(txtReceitaextra);

		JLabel lblRecebimentos = new JLabel("RECEITA EXTRA");
		lblRecebimentos.setBounds(10, 62, 110, 20);
		panel.add(lblRecebimentos);

		JLabel lblTotalCarradas = new JLabel("COMIS.CHEFE");
		lblTotalCarradas.setBounds(10, 191, 110, 20);
		panel.add(lblTotalCarradas);

		txtComissaoChefe = new JTextField("0,00");
		txtComissaoChefe.setHorizontalAlignment(SwingConstants.CENTER);
		txtComissaoChefe.setForeground(new Color(255, 250, 205));
		txtComissaoChefe.setEnabled(false);
		txtComissaoChefe.setDisabledTextColor(Color.BLACK);
		txtComissaoChefe.setColumns(10);
		txtComissaoChefe.setBackground(new Color(255, 250, 205));
		txtComissaoChefe.setBounds(120, 191, 122, 20);
		panel.add(txtComissaoChefe);

		txtCustoReal = new JTextField("0,00");
		txtCustoReal.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustoReal.setForeground(new Color(255, 250, 205));
		txtCustoReal.setEnabled(false);
		txtCustoReal.setDisabledTextColor(Color.BLACK);
		txtCustoReal.setColumns(10);
		txtCustoReal.setBackground(new Color(255, 250, 205));
		txtCustoReal.setBounds(150, 165, 122, 20);
		panel.add(txtCustoReal);

		JLabel lblTotalCusto = new JLabel("TOTAL CUSTO");
		lblTotalCusto.setBounds(20, 165, 110, 20);
		panel.add(lblTotalCusto);

		txtCustoRetorno = new JTextField("0,00");
		txtCustoRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustoRetorno.setForeground(new Color(255, 250, 205));
		txtCustoRetorno.setEnabled(false);
		txtCustoRetorno.setDisabledTextColor(Color.BLACK);
		txtCustoRetorno.setColumns(10);
		txtCustoRetorno.setBackground(new Color(255, 250, 205));
		txtCustoRetorno.setBounds(120, 140, 122, 20);
		panel.add(txtCustoRetorno);

		JLabel lblCustoRetorno = new JLabel("CUSTO RETORNO");
		lblCustoRetorno.setBounds(10, 140, 110, 20);
		panel.add(lblCustoRetorno);

		JLabel lblCustoTotal = new JLabel("CUSTO TOTAL");
		lblCustoTotal.setBounds(10, 114, 110, 20);
		panel.add(lblCustoTotal);

		txtCustoCarradas = new JTextField("0,00");
		txtCustoCarradas.setHorizontalAlignment(SwingConstants.CENTER);
		txtCustoCarradas.setForeground(new Color(255, 250, 205));
		txtCustoCarradas.setEnabled(false);
		txtCustoCarradas.setDisabledTextColor(Color.BLACK);
		txtCustoCarradas.setColumns(10);
		txtCustoCarradas.setBackground(new Color(255, 250, 205));
		txtCustoCarradas.setBounds(120, 114, 122, 20);
		panel.add(txtCustoCarradas);

		JLabel lblComisVendedor = new JLabel("COMIS. VENDEDOR");
		lblComisVendedor.setBounds(10, 215, 110, 20);
		panel.add(lblComisVendedor);

		txtComissaoVendedor = new JTextField("0,00");
		txtComissaoVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtComissaoVendedor.setForeground(new Color(255, 250, 205));
		txtComissaoVendedor.setEnabled(false);
		txtComissaoVendedor.setDisabledTextColor(Color.BLACK);
		txtComissaoVendedor.setColumns(10);
		txtComissaoVendedor.setBackground(new Color(255, 250, 205));
		txtComissaoVendedor.setBounds(120, 215, 122, 20);
		panel.add(txtComissaoVendedor);

		JLabel lblComisCobrador = new JLabel("COMIS. COBRADOR");
		lblComisCobrador.setBounds(10, 241, 110, 20);
		panel.add(lblComisCobrador);

		txtComissaoCobrador = new JTextField("0,00");
		txtComissaoCobrador.setHorizontalAlignment(SwingConstants.CENTER);
		txtComissaoCobrador.setForeground(new Color(255, 250, 205));
		txtComissaoCobrador.setEnabled(false);
		txtComissaoCobrador.setDisabledTextColor(Color.BLACK);
		txtComissaoCobrador.setColumns(10);
		txtComissaoCobrador.setBackground(new Color(255, 250, 205));
		txtComissaoCobrador.setBounds(120, 241, 122, 20);
		panel.add(txtComissaoCobrador);

		JLabel lblDespesaLocal = new JLabel("DESP. LOCAL");
		lblDespesaLocal.setBounds(10, 315, 110, 20);
		panel.add(lblDespesaLocal);

		txtDespLocal = new JTextField("0,00");
		txtDespLocal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespLocal.setForeground(new Color(255, 250, 205));
		txtDespLocal.setEnabled(false);
		txtDespLocal.setDisabledTextColor(Color.BLACK);
		txtDespLocal.setColumns(10);
		txtDespLocal.setBackground(new Color(255, 250, 205));
		txtDespLocal.setBounds(120, 315, 122, 20);
		panel.add(txtDespLocal);

		txtComissaoTotal = new JTextField("0,00");
		txtComissaoTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtComissaoTotal.setForeground(new Color(255, 250, 205));
		txtComissaoTotal.setEnabled(false);
		txtComissaoTotal.setDisabledTextColor(Color.BLACK);
		txtComissaoTotal.setColumns(10);
		txtComissaoTotal.setBackground(new Color(255, 250, 205));
		txtComissaoTotal.setBounds(150, 266, 122, 20);
		panel.add(txtComissaoTotal);

		JLabel lblTotalComissao = new JLabel("TOTAL COMISSAO");
		lblTotalComissao.setBounds(20, 266, 110, 20);
		panel.add(lblTotalComissao);

		JLabel lblTotalDesp = new JLabel("TOTAL DESP");
		lblTotalDesp.setBounds(20, 418, 110, 20);
		panel.add(lblTotalDesp);

		txtDespTotal = new JTextField("0,00");
		txtDespTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespTotal.setForeground(new Color(255, 250, 205));
		txtDespTotal.setEnabled(false);
		txtDespTotal.setDisabledTextColor(Color.BLACK);
		txtDespTotal.setColumns(10);
		txtDespTotal.setBackground(new Color(255, 250, 205));
		txtDespTotal.setBounds(150, 418, 122, 20);
		panel.add(txtDespTotal);

		txtDespExtra = new JTextField("0,00");
		txtDespExtra.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespExtra.setForeground(new Color(255, 250, 205));
		txtDespExtra.setEnabled(false);
		txtDespExtra.setDisabledTextColor(Color.BLACK);
		txtDespExtra.setColumns(10);
		txtDespExtra.setBackground(new Color(255, 250, 205));
		txtDespExtra.setBounds(120, 392, 122, 20);
		panel.add(txtDespExtra);

		JLabel lblDespLanada = new JLabel("DESP. LAN\u00C7ADA");
		lblDespLanada.setBounds(10, 392, 110, 20);
		panel.add(lblDespLanada);

		txtDespCobranca = new JTextField("0,00");
		txtDespCobranca.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespCobranca.setForeground(new Color(255, 250, 205));
		txtDespCobranca.setEnabled(false);
		txtDespCobranca.setDisabledTextColor(Color.BLACK);
		txtDespCobranca.setColumns(10);
		txtDespCobranca.setBackground(new Color(255, 250, 205));
		txtDespCobranca.setBounds(120, 367, 122, 20);
		panel.add(txtDespCobranca);

		JLabel lblDespCobrana = new JLabel("DESP. COBRAN\u00C7A");
		lblDespCobrana.setBounds(10, 367, 110, 20);
		panel.add(lblDespCobrana);

		JLabel lblDespesaVenda = new JLabel("DESP. VENDA");
		lblDespesaVenda.setBounds(10, 341, 110, 20);
		panel.add(lblDespesaVenda);

		txtDespVenda = new JTextField("0,00");
		txtDespVenda.setHorizontalAlignment(SwingConstants.CENTER);
		txtDespVenda.setForeground(new Color(255, 250, 205));
		txtDespVenda.setEnabled(false);
		txtDespVenda.setDisabledTextColor(Color.BLACK);
		txtDespVenda.setColumns(10);
		txtDespVenda.setBackground(new Color(255, 250, 205));
		txtDespVenda.setBounds(120, 341, 122, 20);
		panel.add(txtDespVenda);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}

		});
		btnAtualizar.setBounds(10, 459, 79, 25);
		panel.add(btnAtualizar);
		
		txtLucroBruto = new JTextField("0.0");
		txtLucroBruto.setHorizontalAlignment(SwingConstants.CENTER);
		txtLucroBruto.setForeground(new Color(255, 250, 205));
		txtLucroBruto.setEnabled(false);
		txtLucroBruto.setDisabledTextColor(Color.BLACK);
		txtLucroBruto.setColumns(10);
		txtLucroBruto.setBackground(new Color(255, 250, 205));
		txtLucroBruto.setBounds(222, 290, 86, 20);
		panel.add(txtLucroBruto);
		
		JLabel lblBruto = new JLabel("BRUTO");
		lblBruto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBruto.setBounds(99, 290, 122, 20);
		panel.add(lblBruto);
		
		JLabel lblLiquido = new JLabel("LIQUIDO");
		lblLiquido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLiquido.setBounds(99, 445, 122, 20);
		panel.add(lblLiquido);
		
		txtLucroLiquido = new JTextField("0.0");
		txtLucroLiquido.setHorizontalAlignment(SwingConstants.CENTER);
		txtLucroLiquido.setForeground(new Color(255, 250, 205));
		txtLucroLiquido.setEnabled(false);
		txtLucroLiquido.setDisabledTextColor(Color.BLACK);
		txtLucroLiquido.setColumns(10);
		txtLucroLiquido.setBackground(new Color(255, 250, 205));
		txtLucroLiquido.setBounds(222, 445, 86, 20);
		panel.add(txtLucroLiquido);

		painelEntradasSaidas = new Painel.Dinamico.ReceitasDespesasExtra.JPnlDespesasExtra(equipe);
		painelEntradasSaidas.setBounds(338, 80, 727, 461);
		add(painelEntradasSaidas);

		JButton btnReceitas = new JButton("Receitas");
		btnReceitas.addActionListener(this);
		btnReceitas.setBounds(338, 46, 89, 23);
		add(btnReceitas);

		JButton btnDespesas = new JButton("Despesas");
		btnDespesas.addActionListener(this);
		btnDespesas.setBounds(437, 46, 89, 23);
		add(btnDespesas);
		atualizar();

	}

	private void atualizar() {
		equipe = (Equipe) banco.buscarPorId(Equipe.class, equipe.getId());

		float recebido = equipe.getCobranca().getRecebidoTotal();
		txtReceitaPreso.setText(String.valueOf(recebido));
		float vendaVista = equipe.getVenda().getVendaVista();
		txtReceitavista.setText(String.valueOf(vendaVista));
		float receitaExtra = equipe.getTotalreceitaExtra();
		txtReceitaextra.setText(String.valueOf(receitaExtra));
		float receitaTotal = recebido + vendaVista + receitaExtra;
		txtReceitaTotal.setText(String.valueOf(receitaTotal));

		float custoCarrada = equipe.getCustoCarradas();
		txtCustoCarradas.setText(String.valueOf(custoCarrada));
		float custoRetorno = equipe.getCustoRetornos();
		txtCustoRetorno.setText(String.valueOf(custoRetorno));
		float custoReal = custoCarrada - custoRetorno;
		txtCustoReal.setText(String.valueOf(custoReal));

		float comissaochefe = equipe.getChefe().getComissaoVenda(equipe.getVenda().getVendaPraso());
		txtComissaoChefe.setText(String.valueOf(comissaochefe));
		float comissaocobrador = equipe.getCobranca().getCobrador().getComissao(recebido);
		txtComissaoCobrador.setText(String.valueOf(comissaocobrador));
		float comissaovendedor = equipe.getComissaoVendedores();
		txtComissaoVendedor.setText(String.valueOf(comissaovendedor));
		float comissaoTotal = comissaochefe + comissaocobrador + comissaovendedor;
		txtComissaoTotal.setText(String.valueOf(comissaoTotal));

		float despMenutencao = equipe.getValorManutencao();
		float despFret = equipe.getValorFretes();
		float perca = equipe.getDividaVendedores();
		float despLocal = despMenutencao + despFret + perca;
		txtDespLocal.setText(String.valueOf(despLocal));
		float despVenda = equipe.getVenda().getDespesa().getTotalDespesa();
		txtDespVenda.setText(String.valueOf(despVenda));
		float despCobranca =  equipe.getCobranca().getDespesa().getTotalDespesa();;
		txtDespCobranca.setText(String.valueOf(despCobranca));
		float despExtra = equipe.getTotalDespExtra();
		txtDespExtra.setText(String.valueOf(despExtra));
		float despTotal = despCobranca + despExtra + despVenda + despLocal;
		txtDespTotal.setText(String.valueOf(despTotal));
		
		float lucroBruto = receitaTotal-custoReal-comissaoTotal;
		
		txtLucroBruto.setText(String.valueOf(lucroBruto));
		float lucroLiquido= lucroBruto-despTotal;
		txtLucroLiquido.setText(String.valueOf(lucroLiquido));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();

		switch (acao) {
		case "Receitas":
			painelEntradasSaidas.removeAll();
			painelEntradasSaidas.repaint();
			JPnlReceitasExtra painel=new JPnlReceitasExtra(equipe);
			painelEntradasSaidas.add(painel);;
			painelEntradasSaidas.validate();
			

			break;
		case "Despesas":
			painelEntradasSaidas.removeAll();
			painelEntradasSaidas.repaint();
			JPnlDespesasExtra painel2=new JPnlDespesasExtra(equipe);
			painelEntradasSaidas.add(painel2);;
			painelEntradasSaidas.validate();
			break;

		default:
			break;
		}

	}
}
