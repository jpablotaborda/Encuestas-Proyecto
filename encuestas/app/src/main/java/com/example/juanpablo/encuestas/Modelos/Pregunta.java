package com.example.juanpablo.encuestas.Modelos;

import java.util.ArrayList;

/**
 * Created by Juan Pablo on 03/05/2018.
 */

public class Pregunta {
    private String Enunciado;
    private Respuesta res_final;
    private ArrayList<Respuesta> cjto_opciones;

    public Respuesta getRes_final() {
        return res_final;
    }

    public void setRes_final(Respuesta res_final) {
        this.res_final = res_final;
    }

    public String getEnunciado() {

        return Enunciado;
    }

    public ArrayList<Respuesta> getCjto_opciones() {
        return cjto_opciones;
    }

    public void setCjto_opciones(ArrayList<Respuesta> cjto_opciones) {
        this.cjto_opciones = cjto_opciones;
    }

    public void setEnunciado(String enunciado) {
        Enunciado = enunciado;
    }
}
