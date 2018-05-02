package com.example.juanpablo.encuestas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class config_encuestas extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_encuestas);
        Spinner tipoencuesta= (Spinner) findViewById(R.id.config_spinner_tipo_encuesta);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.tiposencuenta,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoencuesta.setAdapter(adapter);
        tipoencuesta.setOnItemSelectedListener(this);
        TextView lab_num_res= (TextView) findViewById(R.id.config_lab_num_res_encuesta);
        EditText cam_num_res= (EditText) findViewById(R.id.config_cam_num_res_encuesta);
        lab_num_res.setVisibility(View.INVISIBLE);
        cam_num_res.setVisibility(View.INVISIBLE);
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
}
