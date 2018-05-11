package com.example.juanpablo.encuestas;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juanpablo.encuestas.Adaptadores.Adaptapregunta;
import com.example.juanpablo.encuestas.Modelos.Pregunta;
import com.example.juanpablo.encuestas.Modelos.Pregunta_abierta;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class crear_enc_abierta extends Fragment {
    public View view;
    private List<Pregunta> lista_preguntas;
    private Adaptapregunta adaptapregunta;

    public crear_enc_abierta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_crear_enc_abierta, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerViewenc_abierta=(RecyclerView)view.findViewById(R.id.recyclerviewenc_abierta);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerViewenc_abierta.setLayoutManager(linearLayoutManager);

        lista_preguntas=new ArrayList<>();
        lista_preguntas.add(new Pregunta_abierta("Esta es mi pregunta"));
        lista_preguntas.add(new Pregunta_abierta("Es que a veces tengo dos"));
        lista_preguntas.add(new Pregunta_abierta("Incluso 3 preguntas o.O"));
        lista_preguntas.add(new Pregunta_abierta("Es que a veces tengo dos"));
        lista_preguntas.add(new Pregunta_abierta("Incluso 3 preguntas o.O"));
        lista_preguntas.add(new Pregunta_abierta("Es que a veces tengo dos"));
        lista_preguntas.add(new Pregunta_abierta("Incluso 3 preguntas o.O"));

        adaptapregunta= new Adaptapregunta(getContext(),lista_preguntas);
        recyclerViewenc_abierta.setAdapter(adaptapregunta);
        adaptapregunta.notifyDataSetChanged();

    }
}
