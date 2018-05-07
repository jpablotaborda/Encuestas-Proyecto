package com.example.juanpablo.encuestas.Modelos;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Juan Pablo on 03/05/2018.
 */

public class Encuesta {
    private String nombre;
    ArrayList<Pregunta> lista_preguntas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void agregar_pregunta(Pregunta pregun){
        lista_preguntas.add(pregun);
    }
    public void borrar_pregunta(int indice){
        lista_preguntas.remove(indice);

    }

    public ArrayList<Pregunta> getLista_preguntas() {
        return lista_preguntas;
    }
}
