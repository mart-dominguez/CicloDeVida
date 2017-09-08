package com.example.martdominguez.ciclodevida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button btnRestar;
    private Button btnSumar;
    private Button btnReiniciar;
    private Button btnVolver;

    private TextView tv;
    private EditText txtIncremento;

    private Integer contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        contador=0;

        btnVolver= (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(clickBotones);
        btnSumar= (Button) findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(clickBotones);
        btnRestar=(Button) findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(clickBotones);
        btnReiniciar=(Button) findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(clickBotones);

        txtIncremento = (EditText) findViewById(R.id.incremento);
        tv=(TextView) findViewById(R.id.textoResultado);

        tv.setText("Contador : "+contador);
    }

    private View.OnClickListener clickBotones = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int incremento = Integer.parseInt(txtIncremento.getText().toString());
            switch (view.getId()){
                case R.id.btnSumar:
                    contador += incremento;
                    if(contador==10){
                        btnSumar.setEnabled(false);
                    }
                    break;
                case R.id.btnRestar:
                    contador -= incremento;
                    if(contador<=-10){
                        btnRestar.setEnabled(false);
                    }
                    break;
                case R.id.btnReiniciar:
                    contador =0;
                    txtIncremento.setText(1);
                    btnSumar.setEnabled(true);
                    btnRestar.setEnabled(true);
                    break;
                case R.id.btnVolver:
                    Intent iResultado = getIntent();
                    iResultado.putExtra("RESULTADO",contador*5);
                    setResult(RESULT_OK,iResultado);
                    finish();
            }
            tv.setText("Contador : "+contador);
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("contador",contador);
        outState.putBoolean("btnSumar",btnSumar.isEnabled());
        outState.putBoolean("btnRestar",btnRestar.isEnabled());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        contador = savedInstanceState.getInt("contador");
        tv.setText("Contador : "+contador);
        btnSumar.setEnabled(savedInstanceState.getBoolean("btnSumar"));
        btnRestar.setEnabled(savedInstanceState.getBoolean("btnRestar"));
    }
}
