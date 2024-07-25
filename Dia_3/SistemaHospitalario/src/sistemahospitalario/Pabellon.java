/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospitalario;

/**
 *
 * @author Admin
 */
public class Pabellon {
    private String nombre_pabellon;
    private String especialidad_pabellon;
    private int numero_pacientes;
    private String hospital_pabellon;

    public Pabellon(String nombre_pabellon, String especialidad_pabellon,
            int numero_pacientes, String hospital_pabellon) {
        this.nombre_pabellon = nombre_pabellon;
        this.especialidad_pabellon = especialidad_pabellon;
        this.numero_pacientes = numero_pacientes;
        this.hospital_pabellon = hospital_pabellon;
    }

    public String getNombre_pabellon() {
        return nombre_pabellon;
    }
    public void setNombre_pabellon(String nombre_pabellon) {
        this.nombre_pabellon = nombre_pabellon;
    }

    public String getEspecialidad_pabellon() {
        return especialidad_pabellon;
    }
    public void setEspecialidad_pabellon(String especialidad_pabellon) {
        this.especialidad_pabellon = especialidad_pabellon;
    }

    public int getNumero_pacientes() {
        return numero_pacientes;
    }
    public void setNumero_pacientes(int numero_pacientes) {
        this.numero_pacientes = numero_pacientes;
    }

    public String getHospital_pabellon() {
        return hospital_pabellon;
    }
    public void setHospital_pabellon(String hospital_pabellon) {
        this.hospital_pabellon = hospital_pabellon;
    }
    
    @Override
    public String toString(){
        return "Pabellon {" +
                "Nombre = " + nombre_pabellon + "|" +
                "Especialidad = " + especialidad_pabellon + "|" +
                "Numero Pacientes = " + numero_pacientes + "|" +
                "Hospital = " + hospital_pabellon + "|" +
                "}";
    }
}
