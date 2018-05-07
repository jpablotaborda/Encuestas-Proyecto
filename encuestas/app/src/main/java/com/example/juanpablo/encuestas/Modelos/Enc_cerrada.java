package com.example.juanpablo.encuestas.Modelos;

import java.util.ArrayList;

/**
 * Created by Juan Pablo on 03/05/2018.
 */

public class Enc_cerrada extends Encuesta {
    private String tipo;
    private String nombre;
    public Enc_cerrada(String nombre_ent,ArrayList<Pregunta_cerrada> preguntas){
        this.tipo="Cerrada";
        this.nombre=nombre_ent;
        int i=0;
        while(i<preguntas.size()){
            agregar_pregunta(preguntas.get(i));
            i++;
        }


    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





}
