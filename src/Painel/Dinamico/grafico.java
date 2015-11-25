package Painel.Dinamico;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class grafico extends JPanel {

	public grafico() {
		super();
		setLayout(null);
		setBounds(1, 1, 294, 198);
		DefaultPieDataset data = new DefaultPieDataset();

		data.setValue("Receita", 350000);
		data.setValue("Custo", 95200);
		data.setValue("Despesa" , 35450);
		data.setValue("Comissão" , 38600);

		JFreeChart chart = ChartFactory.createPieChart3D("Recebimento", data, true, true, true);

//		PiePlot3D plot = (PiePlot3D) chart.getPlot();
//		plot.setLabelLinksVisible(true);
//
//		plot.setStartAngle(90);
//		plot.setDirection(Rotation.CLOCKWISE);
//
//		plot.setForegroundAlpha(5);
//		plot.setInteriorGap(0.20);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		chartPanel.setBounds(1, 1, 294, 198);
		add(chartPanel);

	}

}