package Painel.Manu;

import javax.swing.JPanel;

import Janela.Cadastro.JFrmCadFuncionario;
import Janela.Cadastro.JFrmCadProduto;
import Janela.Cadastro.JFrmCadTransporte;
import Janela.Compra.JFrmComProduto;
import Janela.Pesquisa.JFrmPesFuncionario;
import Janela.Pesquisa.JFrmPesProduto;
import Janela.Pesquisa.JFrmPesTransporte;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPnlManu extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPnlManu() {
		setBounds(0, 0, 1350, 90);
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 21);
		add(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastroProduto = new JMenuItem("Cadastro Produto");
		mntmCadastroProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrmCadProduto cp = new JFrmCadProduto();
				cp.setVisible(true);
				cp.setAlwaysOnTop(true);
				cp.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCadastroProduto);
		
		JMenuItem mntmCadastroTransporte = new JMenuItem("Cadastro Transporte");
		mntmCadastroTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmCadTransporte ct = new JFrmCadTransporte();
				ct.setVisible(true);
				ct.setAlwaysOnTop(true);
				ct.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCadastroTransporte);
		
		JMenuItem mntmCadastroFuncionario = new JMenuItem("Cadastro Funcionario");
		mntmCadastroFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmCadFuncionario cf = new JFrmCadFuncionario();
				cf.setVisible(true);
				cf.setAlwaysOnTop(true);
				cf.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCadastroFuncionario);
		
		JMenu mnPesquisa = new JMenu("Pesquisa");
		menuBar.add(mnPesquisa);
		
		JMenuItem mntmPesquisaProduto = new JMenuItem("Pesquisa Produto");
		mntmPesquisaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmPesProduto pp = new JFrmPesProduto();
				pp.setVisible(true);
				pp.setAlwaysOnTop(true);
				pp.setLocationRelativeTo(null);
			}
		});
		mnPesquisa.add(mntmPesquisaProduto);
		
		JMenuItem mntmPesquisaTransporte = new JMenuItem("Pesquisa Transporte");
		mntmPesquisaTransporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmPesTransporte pt = new JFrmPesTransporte();
				pt.setVisible(true);
				pt.setAlwaysOnTop(true);
				pt.setLocationRelativeTo(null);
			}
		});
		mnPesquisa.add(mntmPesquisaTransporte);
		
		JMenuItem mntmPesquisaFuncionario = new JMenuItem("Pesquisa Funcionario");
		mntmPesquisaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmPesFuncionario pf = new JFrmPesFuncionario();
				pf.setVisible(true);
				pf.setAlwaysOnTop(true);
				pf.setLocationRelativeTo(null);
			}
		});
		mnPesquisa.add(mntmPesquisaFuncionario);
		
		JMenuItem mntmPesquisaCompra = new JMenuItem("Pesquisa Compra");
		mnPesquisa.add(mntmPesquisaCompra);
		
		JMenu mnMovimentao = new JMenu("Movimenta\u00E7\u00E3o");
		menuBar.add(mnMovimentao);
		
		JMenuItem mntmComprarProduto = new JMenuItem("Comprar Produto");
		mntmComprarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrmComProduto cp = new JFrmComProduto();
				cp.setVisible(true);
				cp.setAlwaysOnTop(true);
				cp.setLocationRelativeTo(null);
			}
		});
		mnMovimentao.add(mntmComprarProduto);

	}
}
