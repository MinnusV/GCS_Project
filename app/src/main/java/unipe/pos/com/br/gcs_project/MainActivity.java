package unipe.pos.com.br.gcs_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private EditText pesoT, alturaT;
    private TextView resultadoT;
    private Button btnCalcular;

    private Double peso, altura, resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoT = (EditText) findViewById(R.id.PesoId);
        alturaT = (EditText) findViewById(R.id.AlturaId);

        resultadoT = (TextView) findViewById(R.id.ResultId);

        btnCalcular = (Button) findViewById(R.id.BtnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peso = Double.parseDouble(pesoT.getText().toString());
                altura = Double.parseDouble(alturaT.getText().toString());

                resultado = (peso)/(altura*altura);

                resultadoT.setText(resultado.toString());
            }
        });


    }
}
