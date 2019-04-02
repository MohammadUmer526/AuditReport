package com.example.auditreport;

import android.content.res.Resources;

import java.util.ArrayList;


import charts.Area3DChartActivity;
import charts.AreaChartActivity;
import charts.Bar3DChartActivity;
import charts.BarChartActivity;
import charts.BoxChartActivity;
import charts.BubbleChartActivity;
import charts.BubbleMapActivity;
import charts.ChoroplethMapActivity;
import charts.CircularGaugeActivity;
import charts.Column3DChartActivity;
import charts.ColumnChartActivity;
import charts.CombinedChartActivity;
import charts.ConnectorMapActivity;
import charts.FunnelChartActivity;
import charts.HeatMapChartActivity;
import charts.HiloChartActivity;
import charts.LineChartActivity;
import charts.LinearColorScaleActivity;
import charts.MekkoChartActivity;
import charts.MosaicChartActivity;
import charts.OHLCChartActivity;
import charts.ParetoChartActivity;
import charts.PertChartActivity;
import charts.PieChartActivity;
import charts.PointMapActivity;
import charts.PolarChartActivity;
import charts.PyramidActivity;
import charts.QuadrantChartActivity;
import charts.RadarChartActivity;
import charts.RangeChartActivity;
import charts.ResourceChartActivity;
import charts.ScatterChartActivity;
import charts.SunburstChartActivity;
import charts.TagCloudActivity;
import charts.ThermometerActivity;
import charts.TreeMapChartActivity;
import charts.TwoPiesOneColumnActivity;
import charts.VennDiagramActivity;
import charts.VerticalChartActivity;
import charts.WaterfallChartActivity;
import charts.WindDirectionActivity;
import charts.WindSpeedActivity;

public class Chart {

    private String name;
    private Class activityClass;

    private Chart(String name, Class activityClass) {
        this.name = name;
        this.activityClass = activityClass;
    }

    public String getName() {
        return name;
    }

    Class getActivityClass() {
        return activityClass;
    }

    static ArrayList<Chart> createChartList(Resources resources) {
        ArrayList<Chart> chartList = new ArrayList<>();

        chartList.add(new Chart(resources.getString(R.string.pie_chart), PieChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.column_chart), ColumnChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.line_chart), LineChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.area_chart), AreaChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.bar_chart), BarChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.venn_diagram), VennDiagramActivity.class));
        chartList.add(new Chart(resources.getString(R.string.heat_map_chart), HeatMapChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.tag_cloud), TagCloudActivity.class));
        chartList.add(new Chart(resources.getString(R.string.waterfall_chart), WaterfallChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.tree_map_chart), TreeMapChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.circular_gauge), CircularGaugeActivity.class));
        chartList.add(new Chart(resources.getString(R.string.thermometer), ThermometerActivity.class));
        chartList.add(new Chart(resources.getString(R.string.linear_color_scale), LinearColorScaleActivity.class));
        chartList.add(new Chart(resources.getString(R.string.wind_speed), WindSpeedActivity.class));
        chartList.add(new Chart(resources.getString(R.string.wind_direction), WindDirectionActivity.class));
        chartList.add(new Chart(resources.getString(R.string.scatter_chart), ScatterChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.resource_chart), ResourceChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.radar_chart), RadarChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.polar_chart), PolarChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.range_chart), RangeChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.vertical_chart), VerticalChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.funnel_chart), FunnelChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.pert_chart), PertChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.combined_chart), CombinedChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.bubble_chart), BubbleChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.pareto_chart), ParetoChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.pyramid_chart), PyramidActivity.class));
        chartList.add(new Chart(resources.getString(R.string.box_chart), BoxChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.mosaic_chart), MosaicChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.mekko_chart), MekkoChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.bar3d_chart), Bar3DChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.column3d_chart), Column3DChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.area3d_chart), Area3DChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.hilo_chart), HiloChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.ohlc_chart), OHLCChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.quadrant_chart), QuadrantChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.sunburst_chart), SunburstChartActivity.class));
        chartList.add(new Chart(resources.getString(R.string.bubble_map), BubbleMapActivity.class));
        chartList.add(new Chart(resources.getString(R.string.choropleth_map), ChoroplethMapActivity.class));
        chartList.add(new Chart(resources.getString(R.string.point_map), PointMapActivity.class));
        chartList.add(new Chart(resources.getString(R.string.connector_map), ConnectorMapActivity.class));
        chartList.add(new Chart(resources.getString(R.string.two_pies_one_column), TwoPiesOneColumnActivity.class));
//        chartList.add(new Chart(resources.getString(R.string.gantt_chart), GanttChartActivity.class));

        return chartList;
    }

}
