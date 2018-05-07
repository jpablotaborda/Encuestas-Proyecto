package com.example.juanpablo.encuestas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juanpablo.encuestas.Modelos.Encuesta;

public class config_encuestas extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_encuestas);
        //configurando componentes
        Spinner tipoencuesta= (Spinner) findViewById(R.id.config_spinner_tipo_encuesta);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.tiposencuenta,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoencuesta.setAdapter(adapter);
        //tipoencuesta.setOnItemSelectedListener(this);

        Button boton_crear_encuesta= (Button) findViewById(R.id.config_bot_crear_encuesta);
        boton_crear_encuesta.setOnClickListener(this);
        //creando encuesta
        Encuesta encuesta= new Encuesta();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch ((int) adapterView.getItemIdAtPosition(i)){
            case 0:
                Toast.makeText(this, "Caso 0", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(this, "Caso 1", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {

    }
}
