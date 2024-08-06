
package Mapas;


import java.util.HashMap;
import java.util.Map;


public class Mmain {

  
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        try {
            map.put("A",1);
            map.put("B",2);
            map.put("C",3);

            System.out.println("Valor asociado con A:"+map.get("A"));
            map.remove("B");
            System.out.println(map);
        }
        catch (NullPointerException e){
            System.out.println("Por favor tener cuidado, accediste a una clave nula: " + e);
        }
        catch (Exception e){
            System.out.println("Excepcion general: " + e);
        }
    }
    
}
