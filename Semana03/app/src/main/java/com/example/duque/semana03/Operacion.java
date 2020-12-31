package com.example.duque.semana03;

public class Operacion {

    public String verificaEdad(int edad){
        String mensaje="Edad no valida";
        if(edad >= 18){
            mensaje = "Mayor de edad";
        }else if(edad >= 1 & edad < 18){
            mensaje = "Menor de edad";
        }
        return mensaje;
    }

}
