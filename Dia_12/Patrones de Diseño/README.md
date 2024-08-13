# ![logo](https://i.imgur.com/Yt1vXic.png)

Los patrones de diseño (design patterns) son soluciones habituales a problemas comunes en el diseño de software. Cada patrón es como un plano que se puede personalizar para resolver un problema de
diseño particular de tu código.Estos patrones se dividen en tres tipos:

## Tipos de Patrones de Diseño
- Patrones Creacionales
- Patrones Estructurales
- Patrones de Comportamiento

# Patrones Estructurales

Los patrones estructurales explican cómo ensamblar objetos y clases en estructuras más grandes, a la vez que se mantiene la flexibilidad y eficiencia de estas estructuras.

## Adapter

Es un patrón de diseño estructural que permite la colaboración entre objetos con interfaces incompatibles. Como cualquier adaptador en el mundo real este patrón se utiliza para ser una interfaz, un puente, entre dos objetos. 

Propósito: Convertir la interfaz (adaptee) de una clase en otra interfaz (target) que el cliente espera. Permitir a dos interfaces incompatibles trabajar en conjunto. Este patrón nos permite ver a nuevos y distintos elementos como si fueran igual a la interfaz conocida por nuestra aplicación.

### Aplicación:

- Cuando el cliente espera usar la interfaz de destino (target).
- Deseamos usar una clase existente pero la interfaz que ofrece no concuerda con la que necesitamos.

![logo](https://refactoring.guru/images/patterns/content/adapter/adapter-es.png)

### Implementación

Supongamos que tienes una clase OldSystem que tiene un método oldMethod(), y quieres usar esta clase en una aplicación que espera una interfaz Target con un método request().

#### Ejemplo:

1. Definir la interfaz Target

```java
// Interfaz que tu aplicación espera
public interface Target {
    void request();
}
```

 2. Implementar la clase OldSystem que no es compatible con la interfaz Target.

```java
// Clase antigua con un método incompatible
public class OldSystem {
    public void oldMethod() {
        System.out.println("Old method in OldSystem.");
    }
}
```

3. Crear el Adapter que adapta OldSystem a la interfaz Target.
   
```java
// Adapter que convierte OldSystem a Target
public class Adapter implements Target {
    private OldSystem oldSystem;

    public Adapter(OldSystem oldSystem) {
        this.oldSystem = oldSystem;
    }

    @Override
    public void request() {
        oldSystem.oldMethod(); // Llama al método incompatible
    }
}
```

4. Usar el Adapter en tu aplicación en lugar de OldSystem.

```java
public class Main {
    public static void main(String[] args) {
        OldSystem oldSystem = new OldSystem();
        Target target = new Adapter(oldSystem);
        
        target.request(); // Esto llama a oldMethod() de OldSystem
    }
}

```
