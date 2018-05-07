package com.example.juanpablo.encuestas.Modelos;

import java.util.ArrayList;

/**
 * Created by jpablo.taborda on 7/05/18.
 */

public class Pregunta_cerrada extends Pregunta {

    public  Pregunta_cerrada(String enun, ArrayList<Respuesta> lis_res,String respuesta_final){
        setEnunciado(enun);
        setCjto_opciones(lis_res);
        Respuesta res_correcta=new Respuesta();
        res_correcta.setTexto(respuesta_final);
        setRes_final(res_correcta);

    }

}
