package com.zsh.echartsdevelop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private EchartView lineChart;
    private EchartView chartFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_main);

        lineChart = findViewById(R.id.lineChart);
        chartFemale = findViewById(R.id.chart_female);
        lineChart.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
                refreshLineChart();
            }
        });
        chartFemale.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                refreshChartFemale();
            }
        });

    }

    private void refreshLineChart() {
        Object[] x = new Object[]{
                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        Object[] y = new Object[]{
                820, 932, 901, 934, 1290, 1330, 1320
        };
        lineChart.refreshEchartsWithOption(EchartOptionUtil.getLineChartOptions(x, y));
    }

    private void refreshChartFemale() {
        Object[] x = new Object[]{
                "市委\\n部门", "市政府\\n部门", "地区\\n党委\\n部门", "地区\\n政府\\n部门", "必须\\n配备\\n女干部\\n单位"
        };

        Object[] y = new Object[]{
                40, 20, 11
        };
        chartFemale.refreshEchartsWithOption(EchartOptionUtil.getBarChartOptions(x, y));
    }
}
