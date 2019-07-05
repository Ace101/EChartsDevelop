package com.zsh.echartsdevelop;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Series;
import com.github.abel533.echarts.style.TextStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhangshihao
 * @date:2019-07-04
 * @description:
 */
public class EchartOptionUtil {

    public static GsonOption getLineChartOptions(Object[] xAxis, Object[] yAxis) {
        GsonOption option = new GsonOption();
        option.title("折线图");
        option.legend("销量");
        option.tooltip().trigger(Trigger.item);

        ValueAxis valueAxis = new ValueAxis();
        option.yAxis(valueAxis);

        CategoryAxis categorxAxis = new CategoryAxis();
        categorxAxis.axisLine().onZero(false);
        categorxAxis.boundaryGap(true);
        categorxAxis.data(xAxis);
        option.xAxis(categorxAxis);

        Line line = new Line();
        line.smooth(false).name("销量").data(yAxis).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
        option.series(line);
        return option;
    }

    public static GsonOption getBarChartOptions(Object[] xAxis, Object[] yAxis) {

        GsonOption option = new GsonOption();
        option.title("女干部配备情况");
        TextStyle textStyle = new TextStyle();
        textStyle.setFontSize(12);
        option.title().x("10").y("5").textStyle(textStyle);
        option.legend("总数", "已配备女干部", "未配备女干部");
        option.legend().x("10").y("30").itemWidth(10).itemHeight(10);

        ValueAxis valueAxis = new ValueAxis();
        option.yAxis(valueAxis);

        CategoryAxis categorxAxis = new CategoryAxis();
        categorxAxis.axisLine().onZero(false);
        categorxAxis.data(xAxis);
        option.xAxis(categorxAxis);

        Bar barTotal = new Bar();
        barTotal.name("总数").data(yAxis);

        Bar barAlready = new Bar();
        barAlready.name("已配备女干部").data(yAxis);

        Bar barNone = new Bar();
        barNone.name("未配备女干部").data(yAxis);

        List<Series> series = new ArrayList<>();
        series.add(barTotal);
        series.add(barAlready);
        series.add(barNone);

        option.series(series);

        return option;
    }
}
