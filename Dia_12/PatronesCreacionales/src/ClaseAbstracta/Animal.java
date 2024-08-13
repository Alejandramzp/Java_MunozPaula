
package ClaseAbstracta;

// CLASE ABSTRACTA: Obliga que las clase hijas se definan el comportamiento
// Método vacio que define que se debe hacer pero no el COMO se hace.

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
    //Método Abstracto
    public abstract void sound();

    //Método Concreto
    public void sleep(){
        System.out.println("El "+name+ " está durmiendo.");
    }
}
