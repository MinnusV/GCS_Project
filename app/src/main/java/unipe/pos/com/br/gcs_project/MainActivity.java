package unipe.pos.com.br.gcs_project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private EditText pesoT, alturaT, nomeT;
    private TextView resultadoT;
    private Button btnCalcular;

    private Double peso, altura, resultado;
    private String nome;

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
                showDialog();
            }
        });
    }

    protected void showDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View view = layoutInflater.inflate(R.layout.input_dialog, null);
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
        aBuilder.setView(view);

        nomeT = (EditText) view.findViewById(R.id.NameId);

        aBuilder.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                peso = Double.parseDouble(pesoT.getText().toString());
                altura = Double.parseDouble(alturaT.getText().toString());
                nome = nomeT.getText().toString();

                resultado = (peso)/(altura*altura);

                resultadoT.setText(nome + " seu IMC é: " + resultado.toString());
            }
        }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = aBuilder.create();
        alert.show();
    }

}
