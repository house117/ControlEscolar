/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controlescolar.objects.Alumno;
import controlescolar.objects.Fecha;
import java.util.ArrayList;
import exceptions.*;

/**
 *
 * @author House
 */
public class ControlEscolar {
    ArrayList<Alumno> listaAlumnos;
    public ControlEscolar(ArrayList<Alumno> listaAlumnos){
        this.listaAlumnos = listaAlumnos;
    }
    public ControlEscolar(){
        listaAlumnos = new ArrayList<>();
    }
    public void addAlumno(Alumno e) throws NumeroControlRepetidoException{
        for(int i=0; i<listaAlumnos.size(); i++){
            System.out.println(e.getNoControl()+" | "+listaAlumnos.get(i).getNoControl());
            if(e.getNoControl().equals(listaAlumnos.get(i).getNoControl())){
                throw new NumeroControlRepetidoException("Numero de control repetido");
            }
        }
        listaAlumnos.add(e);
    }
    public Alumno buscarNoControl (String noControl){
        for(int i=0; i<listaAlumnos.size(); i++){
            if(noControl.equals(listaAlumnos.get(i).getNoControl())){
                return listaAlumnos.get(i);
            }
        }
        return null;
    }
    public ArrayList<Alumno> buscarPorNombre (String nombre){
        ArrayList<Alumno> encontrados = new ArrayList<>();
        for(int i=0; i<listaAlumnos.size(); i++){
            if(nombre.equals(listaAlumnos.get(i).getNombre())){
                encontrados.add(listaAlumnos.get(i));
            }
        }
        return encontrados;
    }
    public void eliminarAlumno(String noControl){
        for(int i=0; i<listaAlumnos.size(); i++){
            if(noControl.equals(listaAlumnos.get(i).getNoControl())){
                listaAlumnos.remove(i);
            }
        }
    } 
    public void modificarNombre(String noControl, String nuevoNombre){
        buscarNoControl(noControl).setNombre(nuevoNombre);
    }
    public void modificarApat(String noControl, String nuevoApat){
        buscarNoControl(noControl).setaPaterno(nuevoApat);
    }
    public void modificarAMat(String noControl, String nuevoAmat){
        buscarNoControl(noControl).setaMaterno(nuevoAmat);
    }
    public void modificarFechaNac(String noControl, Fecha nuevaFechaNac){
        buscarNoControl(noControl).setFechaNac(nuevaFechaNac);
    }
    public void modificarCarrera(String noControl, String nuevaCarrera){
        buscarNoControl(noControl).setCarrera(nuevaCarrera);
    }
    

}
