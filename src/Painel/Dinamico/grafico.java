package Painel.Dinamico;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

@SuppressWarnings("serial")
public class grafico extends JPanel {

	float carrada = 350000;
	float compra = (float) (carrada/3.5);
	float retorno = 16500;
	float praso = 285500;
	float vista = (carrada-praso-(praso))/2;

	public grafico(String[] lista,int q,int w, int e, int r ) {

		setBounds(q, w, e, r);

		DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

		


		dataSet.setValue(Float.valueOf(lista[0]), "V", "Vista");
		dataSet.setValue(Float.valueOf(lista[1]), "D", "Desp");
		dataSet.setValue(Float.valueOf(lista[2]), "R", "Retorno");

		JFreeChart grafico = ChartFactory.createBarChart3D("Pontos Criticos",
				"", "", dataSet, PlotOrientation.HORIZONTAL,
				true, true, false);
		setLayout(null);
		
		grafico.setBackgroundPaint(Color.lightGray);

		ChartPanel chartPanel = new ChartPanel(grafico);
		chartPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		chartPanel.setBounds(getBounds());
		chartPanel.setOpaque(true);
		//não sei que diabos é isso
		//chartPanel.setBackground(Color.black);
		add(chartPanel);

	}



	

}