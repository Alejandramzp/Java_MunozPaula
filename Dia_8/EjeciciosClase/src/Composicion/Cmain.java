
package Composicion;

public class Cmain {
    public static void main(String[] args) {
        House house = new House();
        System.out.println("House: "+house.getRoom().getType());
    }
}
