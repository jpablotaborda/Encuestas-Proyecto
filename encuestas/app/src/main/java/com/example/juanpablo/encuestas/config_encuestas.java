package com.example.juanpablo.encuestas;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juanpablo.encuestas.Modelos.Encuesta;

public class config_encuestas extends Fragment implements View.OnClickListener {
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.activity_config_encuestas,container,false);
        return v;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //configurando componentes
        Spinner tipoencuesta= (Spinner) v.findViewById(R.id.config_spinner_tipo_encuesta);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.tiposencuenta,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoencuesta.setAdapter(adapter);
        //tipoencuesta.setOnItemSelectedListener(this);

        Button boton_crear_encuesta= (Button) v.findViewById(R.id.config_bot_crear_encuesta);
        boton_crear_encuesta.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        EditText cam_nom_enc= (EditText) v.findViewById(R.id.config_cam_nom_encuesta);
        Spinner spinner_tipo_enc= (Spinner) v.findViewById(R.id.config_spinner_tipo_encuesta);
        if(cam_nom_enc.getText().toString().isEmpty()){
            Toast.makeText(getActivity().getApplicationContext(), "Debe ingresar un nombre para la encuesta", Toast.LENGTH_SHORT).show();
        }
        else{
            Fragment creacion_enc_a_mostrar=null;
           switch (spinner_tipo_enc.getSelectedItem().toString()){
               case "Encuesta Cerrada":
                   creacion_enc_a_mostrar= new crear_enc_cerrada();
                   break;
               case "Encuesta Abierta":
                   creacion_enc_a_mostrar= new crear_enc_abierta();
                   break;

           }
           getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fram_frag_facebooklogin,creacion_enc_a_mostrar).addToBackStack(null).commit();

        }
    }
}
