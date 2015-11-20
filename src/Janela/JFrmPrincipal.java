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
import Painel.Dinamico.JPnlEquipeMercadoria;
import Painel.Dinamico.JPnlEquipePrincipal;
import Painel.Dinamico.JPnlEquipeVendaComissao;
import Painel.Manu.JPnlManu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.Container;

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
	private JLabel foto;
	private Container painelModular;

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

					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
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
		panelComandas.setBounds(5, 100, 270, 570);
		contentPane.add(panelComandas);
		panelComandas.setLayout(null);

		btnMercadoriaEquipe = new JButton("Marcadoria da Equipe");
		btnMercadoriaEquipe.setEnabled(false);
		btnMercadoriaEquipe.setBounds(10, 95, 250, 23);
		panelComandas.add(btnMercadoriaEquipe);

		btnVendas = new JButton("Venda e Comiss\u00E3o");
		btnVendas.setEnabled(false);
		btnVendas.setBounds(10, 130, 250, 23);
		panelComandas.add(btnVendas);

		btnCobrancaAndamento = new JButton("Presta\u00E7\u00E3o de Contas Venda");
		btnCobrancaAndamento.setEnabled(false);
		btnCobrancaAndamento.setBounds(10, 165, 250, 23);
		panelComandas.add(btnCobrancaAndamento);

		btnInformaInicial = new JButton("Informa\u00E7\u00F5es Iniciais");
		btnInformaInicial.setEnabled(false);
		btnInformaInicial.setBounds(10, 60, 250, 23);
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
		panelSetorial.setBounds(280, 100, 1075, 570);
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
		btnCobrancaAndamento.setActionCommand("LOCATARIOS");

		JButton btnCarregarEquipe = new JButton("Carregar Equipe");
		btnCarregarEquipe.setBackground(new Color(220, 220, 220));
		btnCarregarEquipe.setActionCommand("CARREGAEQUIPE");
		btnCarregarEquipe.addActionListener(this);
		btnCarregarEquipe.setBounds(10, 11, 250, 23);
		panelComandas.add(btnCarregarEquipe);

		JButton button = new JButton("Cobran\u00E7as e Saldo de Quita\u00E7\u00E3o");
		button.setEnabled(false);
		button.setActionCommand("IMOVEIS");
		button.setBounds(10, 200, 250, 23);
		panelComandas.add(button);
		
		// imagem no lugar do painel dos modulos
				foto = new JLabel();
				foto.setBounds(60, 300, 150, 165);
				ImageIcon imagem = new ImageIcon(
						Main.class.getResource("/Imagens/selo.png"));
				Image img = imagem.getImage().getScaledInstance(foto.getWidth(),
						foto.getHeight(), Image.SCALE_DEFAULT);
				foto.setIcon(new ImageIcon(img));
				panelComandas.add(foto);
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
			panelSetorial.add(new JPnlEquipePrincipal());
			panelSetorial.validate();

			if (equipe != null) {
				btnMercadoriaEquipe.setEnabled(true);
				btnCobrancaAndamento.setEnabled(true);

				btnVendas.setEnabled(true);
				btnInformaInicial.setEnabled(true);
			}

			break;
		case "MERCADORIA":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			JPnlEquipeMercadoria painelEquipe = new JPnlEquipeMercadoria();
			painelEquipe.setEquipe(equipe);
			painelEquipe.atualiza();
			panelSetorial.add(painelEquipe);
			panelSetorial.validate();
			System.out.println("Atualizou tranquilo - "+painelEquipe.atualiza());

			break;
		case "VENDAS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipeVendaComissao());
			panelSetorial.validate();

			break;
		case "LOCATARIOS":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			// panelSetorial.add(new JPnlLocatarios());
			panelSetorial.validate();

			break;
		case "Informa\u00E7\u00F5es Iniciais":
			panelSetorial.removeAll();
			panelSetorial.repaint();
			panelSetorial.add(new JPnlEquipePrincipal());
			panelSetorial.validate();

			break;

		default:
			break;
		}

	}
}