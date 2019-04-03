package com.example.parcial;

import java.util.ArrayList;

public class Estudiante {

    private String ID;
    private String Nombre;
    private String Apellido;
    private ArrayList<Integer> Notas;

    public Estudiante(String ID, String nombre, String apellido) {
        this.ID = ID;
        Nombre = nombre;
        Apellido = apellido;
    }

    public Estudiante(String ID, String nombre, String apellido, ArrayList<Integer> notas) {
        this.ID = ID;
        Nombre = nombre;
        Apellido = apellido;
        Notas = notas;
    }

    public ArrayList<Integer> getNotas() {
        return Notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        Notas = notas;
    }

    public boolean AddNota(int Nota){
        if(Notas.size()==3){
            return false;
        }
        Notas.add(Nota);
        return true;
    }

    public double GetNotaFinal(){
        if(this.Notas.size()==0){
            return Double.valueOf(0);
        }
        int Promedio = 0;
        int Sum = 0;
        for (int i = 0; i < this.Notas.size() ; i++) {
              Promedio += this.Notas.get(i);
        }
        return Double.valueOf(Promedio / this.Notas.size());
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}
