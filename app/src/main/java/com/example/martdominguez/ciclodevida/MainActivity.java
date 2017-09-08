package com.example.martdominguez.ciclodevida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final Integer CODIGO_LLAMADA_ACT2=800;
    private final Integer CODIGO_LLAMADA_ACT3=900;
    private Button btnRestar;
    private Button btnSumar;
    private Button btnReiniciar;
    private Button btnAct2;
    private TextView tv;
    private TextView tvRes2;
    private EditText txtIncremento;
    private Integer contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador=0;
        btnAct2= (Button) findViewById(R.id.ira2);
        btnAct2.setOnClickListener(clickBotones);
        btnSumar= (Button) findViewById(R.id.btnSumar);
        btnSumar.setOnClickListener(clickBotones);
        btnRestar=(Button) findViewById(R.id.btnRestar);
        btnRestar.setOnClickListener(clickBotones);
        btnReiniciar=(Button) findViewById(R.id.btnReiniciar);
        btnReiniciar.setOnClickListener(clickBotones);
        txtIncremento = (EditText) findViewById(R.id.incremento);
        tv=(TextView) findViewById(R.id.textoResultado);
        tvRes2=(TextView) findViewById(R.id.textoResultado2);
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
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                Intent i = new Intent(MainActivity.this,MainActivity2.class);
//                startActivityForResult(i,CODIGO_LLAMADA_ACT3);
                break;
            case R.id.ira2:
                Intent i2 = new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(i2,CODIGO_LLAMADA_ACT2);
        }
        tv.setText("Contador : "+contador);
    }
};

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==CODIGO_LLAMADA_ACT2){
            if (resultCode == RESULT_OK) {
                Log.d("ACTIVIADAD MAIN","Extras: ---> "+data.getExtras().get("RESULTADO"));
                tvRes2.setText(data.getExtras().get("RESULTADO").toString());
            }
        }
        if(requestCode==CODIGO_LLAMADA_ACT3){
            if (resultCode == RESULT_OK) {
                Log.d("ACTIVIADAD MAIN","Extras: ---> "+data.getExtras().get("RESULTADO"));
                tvRes2.setText(" CODIGO 3: " +data.getExtras().get("RESULTADO").toString());
            }
        }

    }
}
