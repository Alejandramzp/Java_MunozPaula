/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

/**
 *
 * @author Admin
 */
public class Paciente extends Persona {
    
    private String fecha_nacimiento;
    private String fecha_ingreso;
    private String nombre_pabellon;

    public Paciente(String fecha_nacimiento, String fecha_ingreso, 
            String nombre_pabellon, int id, String nombre, String direccion,
            String nombre_hospital) {
        super(id, nombre, direccion, nombre_hospital);
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_ingreso = fecha_ingreso;
        this.nombre_pabellon = nombre_pabellon;
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
    
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public String getFecha_ingreso() {
        return fecha_ingreso;
    }
    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getNombre_pabellon() {
        return nombre_pabellon;
    }
    public void setNombre_pabellon(String nombre_pabellon) {
        this.nombre_pabellon = nombre_pabellon;
    }
       
    
    @Override
    public String toString(){
        return "Paciente {" +
                "ID = " + getId() + "|" +
                "Nombre = " + getNombre() + "|" +
                "Direccion = " + getDireccion() + "|" +
                "Hospital = " + getNombre_hospital() + "|" +
                "Fecha Nacimiento = " + fecha_nacimiento + "|" +
                "Fecha Ingreso = " + fecha_ingreso + "|" +
                "Pabellon = " + nombre_pabellon + "|" +
                "}";
    }
}
