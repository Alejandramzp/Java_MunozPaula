
package HashMap;

import java.util.HashMap;


public class Hmain {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap = new HashMap<>();
        try {
            hashMap.put("A", 1);
            hashMap.put("B", 2);
            hashMap.put("C", 3);
            System.out.println("Valor asociado a A: "+ hashMap.get("A"));
            
            hashMap.remove("B");
            System.out.println(hashMap);
        }
        catch(NullPointerException e){
            System.out.println("Cuidado!, Intentaste agregar un elemento nulo: " + e);
        }
        catch (Exception e) {
            System.out.println("Excepcion general: " + e);
        }
    }
}
