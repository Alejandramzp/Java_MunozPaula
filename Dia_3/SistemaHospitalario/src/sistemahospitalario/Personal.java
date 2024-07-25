/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

/**
 *
 * @author Admin
 */
public class Personal extends Persona {
    
    private String fecha_vinculacion;
    private String departamento_nombre;
    private double salario;

    public Personal(String fecha_vinculacion, String departamento_nombre,
            double salario, int id, String nombre, String direccion, 
            String nombre_hospital) {
        super(id, nombre, direccion, nombre_hospital);
        this.fecha_vinculacion = fecha_vinculacion;
        this.departamento_nombre = departamento_nombre;
        this.salario = salario;
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

    public String getFecha_vinculacion() {
        return fecha_vinculacion;
    }
    public void setFecha_vinculacion(String fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public String getDepartamento_nombre() {
        return departamento_nombre;
    }
    public void setDepartamento_nombre(String departamento_nombre) {
        this.departamento_nombre = departamento_nombre;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString(){
        return "Personal {" +
                "ID = " + getId() + "|" +
                "Nombre = " + getNombre() + "|" +
                "Direccion = " + getDireccion() + "|" +
                "Hospital = " + getNombre_hospital() + "|" +
                "Fecha Vinculacion = " + fecha_vinculacion + "|" +
                "Departamento = " + departamento_nombre + "|" +
                "Salario = " + salario + "|" +
                "}";
    }
   
}
