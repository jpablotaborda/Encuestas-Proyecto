package com.example.juanpablo.encuestas.Modelos;

/**
 * Created by jpablo.taborda on 7/05/18.
 */

public class Pregunta_abierta extends Pregunta {
    public Pregunta_abierta(String enunciado){
        this.setCjto_opciones(null);
        this.setEnunciado(enunciado);


    }
    public void responder(String res){
        Respuesta respues= new Respuesta();
        respues.setTexto(res);
        setRes_final(respues);

    }
}
