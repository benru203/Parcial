package com.example.parcial;

import java.util.ArrayList;

public class Data {

    private static ArrayList<Estudiante> Estudiantes = new ArrayList<Estudiante>();

    public static ArrayList<Estudiante> getEstudiantes() {
        return Estudiantes;
    }

    public static void AddEstudiante(Estudiante estudiante){
        Estudiantes.add(estudiante);
    }

}
