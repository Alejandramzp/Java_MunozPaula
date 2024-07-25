/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

/**
 *
 * @author Admin
 */
public class Departamento {
    
    private int id_departamento;
    private String nombre_departamento;
    private String nombrehospital;

    public Departamento(int id_departamento, String nombre_departamento, 
            String nombrehospital) {
        this.id_departamento = id_departamento;
        this.nombre_departamento = nombre_departamento;
        this.nombrehospital = nombrehospital;
    }

    public int getId_departamento() {
        return id_departamento;
    }
    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }
    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public String getNombrehospital() {
        return nombrehospital;
    }
    public void setNombrehospital(String nombrehospital) {
        this.nombrehospital = nombrehospital;
    }
 
    @Override
    public String toString(){
        return "Departamento {" +
                "ID = " + id_departamento + "|" +
                "Nombre = " + nombre_departamento + "|" +
                "Hospital = " + nombrehospital + "|" +
                "}";
    }
}
