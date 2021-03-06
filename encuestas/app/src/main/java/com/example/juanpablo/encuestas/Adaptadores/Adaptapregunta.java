package com.example.juanpablo.encuestas.Adaptadores;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juanpablo.encuestas.Modelos.Pregunta;
import com.example.juanpablo.encuestas.Modelos.Respuesta;
import com.example.juanpablo.encuestas.R;
import com.example.juanpablo.encuestas.detallepreguntaabierta;
import com.example.juanpablo.encuestas.detallepreguntacerrada;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jpablo.taborda on 11/05/18.
 */

public class Adaptapregunta extends RecyclerView.Adapter<Adaptapregunta.preguntaviewholder> {
    public List<Pregunta> lista_preguntas;
    public Context contexto;

    public Adaptapregunta(Context context,List<Pregunta> lista_preguntas_ent){
        this.lista_preguntas=lista_preguntas_ent;
        this.contexto=context;

    }

    @Override
    public preguntaviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardpregunta,parent,false);
        preguntaviewholder pvh= new preguntaviewholder(contexto,view,this);
        return pvh;
    }

    @Override
    public void onBindViewHolder(preguntaviewholder holder, int position) {
        holder.labpregunta.setText((position+1)+". Pregunta");

    }

    @Override
    public int getItemCount() {
        return lista_preguntas.size();
    }

    public static class preguntaviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView labpregunta;
        public Button bot_borrar;
        public Context contexto;
        public Adaptapregunta adaptapro;


        public preguntaviewholder(Context context, View view, Adaptapregunta adaptapregunta) {
            super(view);
            this.contexto=context;
            labpregunta=(TextView) view.findViewById(R.id.card_pregunta_lab_pregunta);
            bot_borrar=(Button)view.findViewById(R.id.card_pregunta_bot_borrar);
            bot_borrar.setOnClickListener(this);
            this.adaptapro=adaptapregunta;
            view.setOnClickListener(this);




        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.card_pregunta_bot_borrar:
                    adaptapro.lista_preguntas.remove(getPosition());
                    adaptapro.notifyDataSetChanged();
                    break;
                case R.id.card_pregunta:
                    Bundle contenedor= new Bundle();
                    contenedor.putString(adaptapro.lista_preguntas.get(getPosition()).getEnunciado(),"enunciado");
                    contenedor.putParcelableArrayList(adaptapro.lista_preguntas.get(getPosition()).getCjto_opciones(),"conjunto_respuestas");
                    Fragment a_reemplazar= null;
                    if(lista_res==null){
                        a_reemplazar= new detallepreguntaabierta();
                    }
                    else{
                        a_reemplazar= new detallepreguntacerrada();
                    }
                    a_reemplazar.setArguments(contenedor);

                    ((AppCompatActivity)contexto).getSupportFragmentManager().beginTransaction().replace(R.id.fram_frag_facebooklogin,a_reemplazar).addToBackStack(null).commit();
                    break;
            }


        }
    }
}
