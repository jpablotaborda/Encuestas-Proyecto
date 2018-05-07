package com.example.juanpablo.encuestas.Modelos;

import java.util.ArrayList;

/**
 * Created by Juan Pablo on 03/05/2018.
 */

public class Enc_abierta extends  Encuesta {
    private String tipo;
    private String nombre;

    public Enc_abierta(String nombre_ent,ArrayList<Pregunta_abierta> preguntas){
        this.tipo="Abierta";
        this.nombre=nombre_ent;
        int i=0;
        while(i<preguntas.size()){
            agregar_pregunta(preguntas.get(i));
            i++;
        }
    }
}
