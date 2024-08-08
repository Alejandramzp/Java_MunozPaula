
package DIP.Good;


public class Switch {
    public Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }
    
    public void operate(){
        device.turnOn();
    }
}
