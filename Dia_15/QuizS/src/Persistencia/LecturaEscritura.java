
package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Logica.Joven;
import Logica.Nomina;
import Logica.Tarjeta;
import Logica.Visa;


public class LecturaEscritura {
    private BufferedReader reader;
    private BufferedWriter writer;
    private String filename;
    private List<Tarjeta> list;
    
    public LecturaEscritura(String filename){
        this.filename = filename;
        list = new ArrayList<>();
    }

    public List<Tarjeta> getList() {
        return list;
    }

    public void setList(List<Tarjeta> list) {
        this.list = list;
    }
    
    public void leerTarjetas(){
        
        try {
            reader = new BufferedReader(new FileReader("./archivos/"+this.filename+".txt"));
            String line = reader.readLine();
            while(line!=null){
                String[] datos = line.split(";");
                switch (datos[2]){
                    case "Joven" -> list.add(new Joven(datos[0],Double.parseDouble(datos[1]),this.filename));
                    case "Nomina" -> list.add(new Nomina(datos[0],Double.parseDouble(datos[1]),this.filename));
                    case "Visa" -> list.add(new Visa(datos[0],Double.parseDouble(datos[1]),this.filename));   
                    default ->{}    
                }
                line = reader.readLine();
            }
            reader.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void escribirTarjetas(List<Tarjeta> tarjetas){
        try{
            writer = new BufferedWriter(new FileWriter(new File("archivos/reporte.txt")));
            for(Tarjeta t: tarjetas){
                writer.write(t.toString()+"\n");
            }
            writer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void setFileName(String filename) {
        this.filename=filename;
    }

}
