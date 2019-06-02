package com.koguty.spocone.datamanagement;

import com.koguty.spocone.commonclasses.Employee;
import com.koguty.spocone.commonclasses.Project;
import com.koguty.spocone.commonclasses.Task;
import com.koguty.spocone.analyzing.DataReceiver;

import java.util.List;
import java.util.Set;

import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.pie.PieChart02;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.SwingWrapper;

import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.colors.BaseSeriesColors;
import javafx.scene.paint.Color;

public class Chart implements ExampleChart<PieChart> {
	
	  public static void main(String[] args) {
	 
	    ExampleChart<PieChart> exampleChart = new PieChart02();
	    PieChart chart = exampleChart.getChart();
	    new SwingWrapper<PieChart>(chart).displayChart();
	  }
	 
	  @Override
	  public PieChart getChart() {
	 
	    // Create Chart
	    PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();
 
	    // Series
	    chart.addSeries("Gold", 24);
	    chart.addSeries("Silver", 21);
	    chart.addSeries("Platinum", 39);
	    chart.addSeries("Copper", 17);
	    chart.addSeries("Zinc", 40);
	 
	    return chart;
	  }
}
