package br.com.apsconsig.controleapscontrole.Activies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import br.com.apsconsig.controleapscontrole.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ProdGeralActivity extends AppCompatActivity {

    private BarChart mChart;
    private SeekBar seekBarX, seekBarY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_geral);

        //Açoes

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Produção Geral do Ano");

        mChart = findViewById(R.id.chart1);
        mChart.getDescription().setEnabled(false);

        setData(10);
        mChart.setFitBars(true);


    }// OnCreat

    private void setData(int count) {
        ArrayList<BarEntry> yVals = new ArrayList<>();

        for (int i = 0; i < count; i++){
            float value = (float) (Math.random()*100);
            yVals.add(new BarEntry(i, (int) value));
        }

        BarDataSet set = new BarDataSet(yVals, "Date Set");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        set.setDrawValues(true);


        BarData data = new BarData(set);

        //data.setBarWidth(0.9f); // set custom bar width
        mChart.setData(data);
        mChart.setFitBars(true); // make the x-axis fit exactly all bars
        //mChart.invalidate(); // refresh
        mChart.animateY(500);
    }

}
