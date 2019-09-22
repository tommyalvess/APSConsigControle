package br.com.apsconsig.controleapscontrole.Activies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import br.com.apsconsig.controleapscontrole.R;
import com.ramotion.foldingcell.FoldingCell;

public class ProdSemanalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_semanal);

        //Açoes

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Produção Semanal");

        final FoldingCell fcInserir = (FoldingCell) findViewById(R.id.inseridosCard);
        final FoldingCell fcPagos = (FoldingCell) findViewById(R.id.pagosCard);
        final FoldingCell fcCancelados = (FoldingCell) findViewById(R.id.canceladoCard);

        fcInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcInserir.toggle(false);
            }
        });

        fcPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcPagos.toggle(false);
            }
        });

        fcCancelados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcCancelados.toggle(false);
            }
        });

    }
}
