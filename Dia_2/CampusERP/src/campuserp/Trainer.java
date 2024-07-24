/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package campuserp;

/**
 *
 * @author Admin
 */
public class Trainer {
        
    private int id;
    private String nombres;
    private String apellidos;
    private String celular;
    private String salon;
    
    //Constructor de los datos
    public Trainer (int id,String nombres,String apellidos,String celular,
                     String salon){
    
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.salon = salon;
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
    
    public String getCelular(){
        return celular;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }
      
    public String getSalon(){
        return salon;
    }
    public void setSalon(String riesgo){
        this.salon = riesgo;
    }
    
    @Override
    public String toString(){
        return "Trainer {" +
                "Id = " + id + "|" +
                "Nombres = " + nombres + "|" +
                "Apellidos = " + apellidos + "|" +
                "Celular = " + celular + "|" +
                "Riesgo = " + salon + "|" +
                "}";
    }    
}

