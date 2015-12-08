package Janela;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jboss.jandex.Main;

import Bin.Equipe.Equipe;
import Janela.Pesquisa.JFrmPesEquipe;
import Painel.Dinamico.JPnlEquipeCobrancaComissao;
import Painel.Dinamico.JPnlEquipeDepositos;
import Painel.Dinamico.JPnlEquipeMercadoriaRetorno;
import Painel.Dinamico.JPnlEquipePrestacaoCobranca;
import Painel.Dinamico.JPnlEquipePrestacaoVenda;
import Painel.Dinamico.JPnlEquipePrincipal;
import Painel.Dinamico.JPnlEquipeVendaComissao;
import Painel.Manu.JPnlManu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Font;

@SuppressWarnings("serial")
public class JFrmPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panelSetorial;
	private Date data = new Date();
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	private Equipe equipe;
	private JPnlManu panelMenu;
	private JButton btnMercadoriaEquipe;
	private JButton btnVendas;
	private JButton btnCobrancaAndamento;
	private JButton btnInformaInicial;
	private JButton btnSaldoQuitacao;
	private JButton btnDepositos;
	private JButton btnRelatorioFinalDe;
	private JButton btnPrestaoDeContas;
	private JLabel lblVendedorVenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {// com.jtattoo.plaf.luna.LunaLookAndFeel azulado simples
						// com.jtattoo.plaf.smart.SmartLookAndFeel o padrão que
						// eu
						// usava muito
						// com.jtattoo.plaf.hifi.HiFiLookAndFeel preto bem
						// massa!!
						// com.jtattoo.plaf.graphite.GraphiteLookAndFeel preto
						// com
						// detalhes marrons
						// com.jtattoo.plaf.fast.FastLookAndFeel cinza basico
						// com.jtattoo.plaf.aluminium.AluminiumLookAndFeel -
						// com.jtattoo.plaf.acryl.AcrylLookAndFeel - um pouco
						// transparente detalhes em preto, bonito
						// com.jtattoo.plaf.bernstein.BernsteinLookAndFeel
						// bonito
						// detalhes em amarelo laranja
						// com.jtattoo.plaf.mcwin.McWinLookAndFeel interface do
						// MacOs
						// com.jtattoo.plaf.mint.MintLookAndFeel basico cores
						// cinsas
						// padrao
						// com.jtattoo.plaf.noire.NoireLookAndFeel preto com
						// detalhe
						// em laranja
						// com.jtattoo.plaf.smart.SmartLookAndFeel tons em azul
						// com.jtattoo.plaf.texture.TextureLookAndFeel banco
						// gelo
						// com detalhes em preto fosco muito massa
						// Properties props = new Properties();
						// props.put("logoString", "");
						// SmartLookAndFeel.setCurrentTheme(props);

					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					JFrmPrincipal frame = new JFrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("betin");
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrmPrincipal() {
		setTitle("Vendas e Crediario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenu = new JPnlManu();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(5, 5, 1350, 90);
		contentPane.add(panelMenu);

		JPanel panelComandas = new JPanel();
		panelComandas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelComandas.setBounds(5, 99, 270, 570);
		contentPane.add(panelComandas);
		panelComandas.setLayout(null);

		btnMercadoriaEquipe = new JButton("CARRADAS E RETORNOS");
		btnMercadoriaEquipe.setEnabled(false);
		btnMercadoriaEquipe.setBounds(10, 70, 250, 23);
		panelComandas.add(btnMercadoriaEquipe);

		btnVendas = new JButton("VENDEDORES E TRANSPORTES");
		btnVendas.setEnabled(false);
		btnVendas.setBounds(10, 100, 250, 23);
		panelComandas.add(btnVendas);

		btnCobrancaAndamento = new JButton("RELATORIO FINAL DA VENDA");
		btnCobrancaAndamento.setEnabled(false);
		btnCobrancaAndamento.setBounds(10, 130, 250, 23);
		panelComandas.add(btnCobrancaAndamento);

		btnInformaInicial = new JButton("INFORMA\u00C7\u00D5ES INICIAIS");
		btnInformaInicial.setEnabled(false);
		btnInformaInicial.setBounds(10, 40, 250, 23);
		panelComandas.add(btnInformaInicial);
		btnInformaInicial.addActionListener(this);

		JPanel panelRodape = new JPanel();
		panelRodape.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRodape.setBounds(5, 675, 1350, 43);
		contentPane.add(panelRodape);
		panelRodape.setLayout(null);

		JLabel lblData = new JLabel(String.valueOf(dt.format(data)));
		lblData.setBounds(5, 10, 98, 14);
		lblData.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblData.setVerticalAlignment(SwingConstants.TOP);
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		panelRodape.add(lblData);

		JLabel lblContato = new JLabel("Rogoberto Ribeiro-(88) 9.8878-0587 / (88) 9.9786-7735");
		lblContato.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContato.setForeground(new Color(30, 144, 255));
		lblContato.setBounds(1000, 10, 340, 14);
		panelRodape.add(lblContato);

		panelSetorial = new JPanel();
		panelSetorial.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelSetorial.setBounds(280, 99, 1075, 570);
		contentPane.add(panelSetorial);

		panelSetorial.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, screenSize.width, screenSize.height);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		btnMercadoriaEquipe.addActionListener(this);
		btnMercadoriaEquipe.setActionCommand("MERCADORIA");
		btnVendas.addActionListener(this);
		btnVendas.setActionCommand("VENDAS");
		btnInformaInicial.addActionListener(this);
		btnCobrancaAndamento.addActionListener(this);
		btnCobrancaAndamento.setActionCommand("PREST_VEND");

		JButton btnCarregarEquipe = new JButton("CARREGAR EQUIPE");
		btnCarregarEquipe.setBackground(new Color(220, 220, 220));
		btnCarregarEquipe.setActionCommand("CARREGAEQUIPE");
		btnCarregarEquipe.addActionListener(this);
		btnCarregarEquipe.setBounds(10, 10, 250, 23);
		panelComandas.add(btnCarregarEquipe);

		btnSaldoQuitacao = new JButton("VENDEDORES E QUITA\u00C7\u00D5ES");
		btnSaldoQuitacao.setEnabled(false);
		btnSaldoQuitacao.addActionListener(this);
		btnSaldoQuitacao.setActionCommand("QUITACAO");
		btnSaldoQuitacao.setBounds(10, 190, 250, 23);
		panelComandas.add(btnSaldoQuitacao);

		// imagem no lugar do painel dos modulos
		JLabel foto = new JLabel();
		foto.setBounds(10, 290, 250, 269);
		ImageIcon imagem = new ImageIcon(Main.class.getResource("/Imagens/000.png"));
		Image img = imagem.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));
		panelComandas.add(foto);
		
		btnDepositos = new JButton("DEPOSITOS E COBRAN\u00C7A");
		btnDepositos.setEnabled(false);
		btnDepositos.addActionListener(this);
		btnDepositos.setActionCommand("DEPOSI");
		btnDepositos.setBounds(10, 160, 250, 23);
		panelComandas.add(btnDepositos);
		
		btnRelatorioFinalDe = new JButton("RELATORIO FINAL DE COBRAN\u00C7A");
		btnRelatorioFinalDe.setEnabled(false);
		btnRelatorioFinalDe.setActionCommand("QUITACAO");
		btnRelatorioFinalDe.setBounds(10, 220, 250, 23);
		panelComandas.add(btnRelatorioFinalDe);
		
		btnPrestaoDeContas = new JButton("RELATORIO FINAL DE COBRAN\u00C7A");
		btnPrestaoDeContas.setEnabled(false);
		btnPrestaoDeContas.addActionListener(this);
		btnPrestaoDeContas.setActionCommand("PRES_COB");
		btnPrestaoDeContas.setBounds(10, 254, 250, 23);
		panelComandas.add(btnPrestaoDeContas);
		
		// imagem no lugar do painel dos modulos
		JLabel foto0 = new JLabel();
		foto0.setBounds(20, 80, 50, 50);
		ImageIcon img0 = new ImageIcon(Main.class.getResource("/Imagens/001.png"));
		Image img00 = img0.getImage().getScaledInstance(foto0.getWidth(), foto0.getHeight(), Image.SCALE_DEFAULT);
		foto0.setIcon(new ImageIcon(img00));
		panelSetorial.add(foto0);
		
		JLabel foto1 = new JLabel();
		foto1.setBounds(20, 20, 50, 50);
		ImageIcon img1 = new ImageIcon(Main.class.getResource("/Imagens/002.png"));
		Image img01 = img1.getImage().getScaledInstance(foto1.getWidth(), foto1.getHeight(), Image.SCALE_DEFAULT);
		foto1.setIcon(new ImageIcon(img01));
		panelSetorial.add(foto1);
		
		JLabel foto2 = new JLabel();
		foto2.setBounds(20, 140, 50, 50);
		ImageIcon img2 = new ImageIcon(Main.class.getResource("/Imagens/003.png"));
		Image img02 = img2.getImage().getScaledInstance(foto2.getWidth(), foto2.getHeight(), Image.SCALE_DEFAULT);
		foto2.setIcon(new ImageIcon(img02));
		panelSetorial.add(foto2);
		
		JLabel foto3 = new JLabel();
		foto3.setBounds(20,200, 50, 50);
		ImageIcon img3 = new ImageIcon(Main.class.getResource("/Imagens/013.png"));
		Image img03 = img3.getImage().getScaledInstance(foto3.getWidth(), foto3.getHeight(), Image.SCALE_DEFAULT);
		foto3.setIcon(new ImageIcon(img03));
		panelSetorial.add(foto3);
		
		JLabel foto4 = new JLabel();
		foto4.setBounds(20,260, 50, 50);
		ImageIcon img4 = new ImageIcon(Main.class.getResource("/Imagens/015.png"));
		Image img04 = img4.getImage().getScaledInstance(foto4.getWidth(), foto4.getHeight(), Image.SCALE_DEFAULT);
		foto4.setIcon(new ImageIcon(img04));
		panelSetorial.add(foto4);
		
		JLabel foto5 = new JLabel();
		foto5.setBounds(20,320, 50, 50);
		ImageIcon img5 = new ImageIcon(Main.class.getResource("/Imagens/031.png"));
		Image img05 = img5.getImage().getScaledInstance(foto5.getWidth(), foto5.getHeight(), Image.SCALE_DEFAULT);
		foto5.setIcon(new ImageIcon(img05));
		panelSetorial.add(foto5);
		
		JLabel foto6 = new JLabel();
		foto6.setBounds(20,380, 50, 50);
		ImageIcon img6 = new ImageIcon(Main.class.getResource("/Imagens/036.png"));
		Image img06 = img6.getImage().getScaledInstance(foto6.getWidth(), foto6.getHeight(), Image.SCALE_DEFAULT);
		foto6.setIcon(new ImageIcon(img06));
		panelSetorial.add(foto6);
		
		JLabel foto7 = new JLabel();
		foto7.setBounds(20,440, 50, 50);
		ImageIcon img7 = new ImageIcon(Main.class.getResource("/Imagens/032.png"));
		Image img07 = img7.getImage().getScaledInstance(foto7.getWidth(), foto7.getHeight(), Image.SCALE_DEFAULT);
		foto7.setIcon(new ImageIcon(img07));
		panelSetorial.add(foto7);
		

		JLabel foto8 = new JLabel();
		foto8.setBounds(20,500, 50, 50);
		ImageIcon img8 = new ImageIcon(Main.class.getResource("/Imagens/019.png"));
		Image img08 = img8.getImage().getScaledInstance(foto8.getWidth(), foto8.getHeight(), Image.SCALE_DEFAULT);
		foto8.setIcon(new ImageIcon(img08));
		panelSetorial.add(foto8);
		
		JLabel lblCrediarioEVendas = new JLabel("CREDI\u00C1RIO E VENDAS");
		lblCrediarioEVendas.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblCrediarioEVendas.setBounds(586, 455, 479, 104);
		panelSetorial.add(lblCrediarioEVendas);
		
		JLabel lblCarradas = new JLabel("MERCADORIA CARRADA");
		lblCarradas.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCarradas.setBounds(100, 30, 257, 25);
		panelSetorial.add(lblCarradas);
		
		JLabel lblRetorno = new JLabel("MERCADORIA RETORNO");
		lblRetorno.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRetorno.setBounds(101, 90, 257, 25);
		panelSetorial.add(lblRetorno);
		
		JLabel lblDevoluo = new JLabel("MERCADORIA DEVOLU\u00C7\u00C3O");
		lblDevoluo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDevoluo.setBounds(101, 150, 257, 25);
		panelSetorial.add(lblDevoluo);
		
		lblVendedorVenda = new JLabel("VENDEDOR VENDA");
		lblVendedorVenda.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVendedorVenda.setBounds(101, 210, 257, 25);
		panelSetorial.add(lblVendedorVenda);
		
		JLabel lblVendedorCobrana = new JLabel("VENDEDOR COBRAN\u00C7A");
		lblVendedorCobrana.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVendedorCobrana.setBounds(100, 270, 257, 25);
		panelSetorial.add(lblVendedorCobrana);
		
		JLabel lblTransportes = new JLabel("TRANSPORTES");
		lblTransportes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTransportes.setBounds(100, 331, 257, 25);
		panelSetorial.add(lblTransportes);
		
		JLabel lblPrestaoVenda = new JLabel("PRESTA\u00C7\u00C3O VENDA");
		lblPrestaoVenda.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrestaoVenda.setBounds(100, 390, 257, 25);
		panelSetorial.add(lblPrestaoVenda);
		
		JLabel lblPrestaoCobrana = new JLabel("PRESTA\u00C7\u00C3O COBRAN\u00C7A");
		lblPrestaoCobrana.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrestaoCobrana.setBounds(100, 445, 257, 25);
		panelSetorial.add(lblPrestaoCobrana);
		
		JLabel label = new JLabel("PRESTA\u00C7\u00C3O COBRAN\u00C7A");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(100, 510, 257, 25);
		panelSetorial.add(label);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		System.out.println(acao);

		switch (acao) {
		case "CARREGAEQUIPE":
			JFrmPesEquipe func = new JFrmPesEquipe();
			func.moduloEscolher();
			func.setModal(true);
			func.setVisible(true);
			equipe = (Equipe) func.getObj();
			panelMenu.getLblTituloDaEquipe().setText(equipe.getTitulo());
			panelMenu.getLblTituloDaEquipe().setVisible(true);

			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipeMercadoriaRetorno(equipe));
			panelSetorial.validate();

			if (equipe != null) {
				btnMercadoriaEquipe.setEnabled(true);
				btnCobrancaAndamento.setEnabled(true);
				btnSaldoQuitacao.setEnabled(true);
				btnVendas.setEnabled(true);
				btnInformaInicial.setEnabled(true);
				btnDepositos.setEnabled(true);
				btnPrestaoDeContas.setEnabled(true);
			}

			break;
		case "MERCADORIA":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			JPnlEquipeMercadoriaRetorno painelEquipe = new JPnlEquipeMercadoriaRetorno(equipe);
			panelSetorial.add(painelEquipe);
			panelSetorial.validate();

			break;
		case "VENDAS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipeVendaComissao(equipe));
			panelSetorial.validate();

			break;
		case "PREST_VEND":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipePrestacaoVenda(equipe));
			panelSetorial.validate();

			break;
		case "INFORMA\u00C7\u00D5ES INICIAIS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipePrincipal(equipe));
			panelSetorial.validate();

			break;
		case "QUITACAO":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipeCobrancaComissao(equipe));
			panelSetorial.validate();

			break;
		case "DEPOSI":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipeDepositos(equipe));
			panelSetorial.validate();

			break; 
		case "PRES_COB":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipePrestacaoCobranca(equipe));
			panelSetorial.validate();

			break;

		default:
			break;
		}

	}
}