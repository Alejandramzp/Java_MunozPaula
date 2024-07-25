/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

/**
 *
 * @author Admin
 */
public class Doctor extends Persona {
    
    private String especialidad;
    private String tipo;

    public Doctor(String especialidad, String tipo, int id, String nombre, 
            String direccion, String nombre_hospital) {
        super(id, nombre, direccion, nombre_hospital);
        this.especialidad = especialidad;
        this.tipo = tipo;
    }

    @Override
    public int getId() {
        return super.getId(); 
    }
    @Override
    public void setId(int id) {
        super.setId(id); 
    }

    @Override
    public String getNombre() {
        return super.getNombre(); 
    }
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre); 
    }

    @Override
    public String getDireccion() {
        return super.getDireccion(); 
    }
    @Override
    public void setDireccion(String direccion) {
        super.setDireccion(direccion); 
    }

    @Override
    public String getNombre_hospital() {
        return super.getNombre_hospital();
    }
    @Override
    public void setNombre_hospital(String nombre_hospital) {
        super.setNombre_hospital(nombre_hospital); 
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return "Doctor {" +
                "ID = " + getId() + "|" +
                "Nombre = " + getNombre() + "|" +
                "Direccion = " + getDireccion() + "|" +
                "Hospital = " + getNombre_hospital() + "|" +
                "Especialidad = " + especialidad + "|" +
                "Tipo = " + tipo + "|" +
                "}";
    }
    
}
