
package TreeMap;

import java.util.TreeMap;


public class Tmain {
    public static void main(String[] args) {
        TreeMap<String,Integer> map = new TreeMap<>();
        try {
            map.put("A", 1);
            map.put("B", 2);
            map.put("C", 3);
            map.put("D", 4);
            map.put("E", 5);
        
        System.out.println("Value A: " + map.get("A"));
        
        map.remove("B");
        
        System.out.println("Value F: " + map.get("F"));
        } 
        catch (NullPointerException e){
            System.out.println("Intentaste agregar un elemento nulo: " + e);
        }
        catch (Exception e){
            System.out.println("Excepcion general: " + e);
        }
    }
}
