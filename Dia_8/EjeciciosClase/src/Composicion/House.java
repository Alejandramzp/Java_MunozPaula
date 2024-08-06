
package Composicion;


public class House {
    private Room room;

    public House() {
        this.room = new Room();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
