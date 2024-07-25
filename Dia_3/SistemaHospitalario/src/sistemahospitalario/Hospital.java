/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

/**
 *
 * @author Admin
 */
public class Hospital {
    private String hospital_nombre;
    private String hospital_direccion;
    private int cantidad_departamentos;

    public Hospital(String hospital_nombre, String hospital_direccion, 
            int cantidad_departamentos) {
        this.hospital_nombre = hospital_nombre;
        this.hospital_direccion = hospital_direccion;
        this.cantidad_departamentos = cantidad_departamentos;
    }

    public String getHospital_nombre() {
        return hospital_nombre;
    }
    public void setHospital_nombre(String hospital_nombre) {
        this.hospital_nombre = hospital_nombre;
    }

    public String getHospital_direccion() {
        return hospital_direccion;
    }
    public void setHospital_direccion(String hospital_direccion) {
        this.hospital_direccion = hospital_direccion;
    }

    public int getId_departamento() {
        return cantidad_departamentos;
    }
    public void setId_departamento(int cantidad_departamentos) {
        this.cantidad_departamentos = cantidad_departamentos;
    }

    
    @Override
    public String toString(){
        return "Hospital {" +
                "Nombre = " + hospital_nombre + "|" +
                "Direccion = " + hospital_direccion + "|" +
                "Cantidad Departamentos = " + cantidad_departamentos + "|" +
                "}";
    }
}
