
package DIP.Good;


public class LightBulb implements Switchable{
    
    public void turnOn(){
        System.out.println("Me prendí...");
    }
    
    public void turnOff(){
        System.out.println("Me apagué...");
    }
    
}
