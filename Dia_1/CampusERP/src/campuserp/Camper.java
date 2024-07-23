/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campuserp;

/**
 *
 * @author Admin
 */
public class Camper {
    
    private int id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String acudiente;
    private String celular;
    private String fijo;
    private String estado;
    private String riesgo;
    
    //Constructor
    public Camper (int id,String nombres,String apellidos,String direccion,
     String acudiente,String celular,String fijo,String estado,String riesgo){
    
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.acudiente = acudiente;
        this.celular = celular;
        this.fijo = fijo;
        this.estado = estado;
        this.riesgo = riesgo;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getNombres(){
        return nombres;
    }
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public String getAcudiente(){
        return acudiente;
    }
    public void setAcudiente(String acudiente){
        this.acudiente = acudiente;
    }
    
    public String getCelular(){
        return celular;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }
    
    public String getFijo(){
        return fijo;
    }
    public void setFijo(String fijo){
        this.fijo = fijo;
    }
    
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getRiesgo(){
        return riesgo;
    }
    public void setRiesgo(String riesgo){
        this.riesgo = riesgo;
    }
    
}
