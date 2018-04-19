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
    private ArrayList<Alumno> listaAlumnos;
    public ControlEscolar(ArrayList<Alumno> listaAlumnos){
        this.listaAlumnos = listaAlumnos;
    }
    public ControlEscolar(){
        listaAlumnos = new ArrayList<>();
    }
    public void addAlumno(Alumno e) throws NumeroControlRepetidoException{
        for(int i=0; i<getListaAlumnos().size(); i++){
            System.out.println(e.getNoControl()+" | "+getListaAlumnos().get(i).getNoControl());
            if(e.getNoControl().equals(getListaAlumnos().get(i).getNoControl())){
                throw new NumeroControlRepetidoException("Numero de control repetido");
            }
        }
        getListaAlumnos().add(e);
    }
    public Boolean existeNoControl(String noControl){
        for(int i=0; i<getListaAlumnos().size(); i++){
            if(noControl.equals(getListaAlumnos().get(i).getNoControl())){
                return true;
            }
        }
        return false;
        
        
    }
    public Alumno buscarNoControl (String noControl){
        for(int i=0; i<getListaAlumnos().size(); i++){
            if(noControl.equals(getListaAlumnos().get(i).getNoControl())){
                return getListaAlumnos().get(i);
            }
        }
        return null;
    }
    public ArrayList<Alumno> buscarPorNombre (String nombre){
        ArrayList<Alumno> encontrados = new ArrayList<>();
        for(int i=0; i<getListaAlumnos().size(); i++){
            if(nombre.equals(getListaAlumnos().get(i).getNombre())){
                encontrados.add(getListaAlumnos().get(i));
            }
        }
        return encontrados;
    }
    public void eliminarAlumno(String noControl){
        for(int i=0; i<getListaAlumnos().size(); i++){
            if(noControl.equals(getListaAlumnos().get(i).getNoControl())){
                getListaAlumnos().remove(i);
            }
        }
    } 
    public void mostrarAlumno(String noControl){
        System.out.println("noControl: "+buscarNoControl(noControl).getNoControl());
        System.out.println("Nombre: "+buscarNoControl(noControl).getNombre());
        System.out.println("Apellido Paterno: "+buscarNoControl(noControl).getaPaterno());
        System.out.println("Apellido Materno: "+buscarNoControl(noControl).getaMaterno());
        System.out.println("Fecha de nacimiento: "+buscarNoControl(noControl).getFechaNac().toString());
        System.out.println("Carrera: "+buscarNoControl(noControl).getCarrera());
        System.out.println("Promedio: "+buscarNoControl(noControl).getPromedio());
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

    /**
     * @return the listaAlumnos
     */
    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    /**
     * @param listaAlumnos the listaAlumnos to set
     */
    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    

}
