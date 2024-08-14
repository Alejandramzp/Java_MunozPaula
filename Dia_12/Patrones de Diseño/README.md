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

## Bridge

Es un patrón de diseño estructural que te permite dividir una clase grande, o un grupo de clases estrechamente relacionadas, en dos jerarquías separadas (abstracción e implementación) que pueden desarrollarse independientemente la una de la otra.

Propósito: Permite desacoplar una abstracción de su implementación, de manera que ambas puedan ser modificadas independientemente sin necesidad de alterar por ello la otra.

### Aplicación:

- Desacoplar interfaz e implementación.
- Mejorar la extensibilidad.
- Esconder los detalles de la implementación a los clientes.

![logo](https://refactoring.guru/images/patterns/content/bridge/bridge.png)

## Composite

Es un patrón de diseño estructural que te permite componer objetos en estructuras de árbol y trabajar con esas estructuras como si fueran objetos individuales.

Propósito: Componer objetos en estructuras de árbol que representan jerarquías de un todo y sus partes. El Composite provee a los clientes un mismo trato para todos los objetos que forman la jerarquía.

Pensemos en nuestro sistema de archivos, este contiene directorios con archivos y a su vez estos archivos pueden ser otros directorios que contenga más archivos, y así sucesivamente. Lo anterior puede ser representado facilmente con el patrón Composite.

### Aplicación:

- Cuando queremos representar jerarquías de objetos compuestas por un todo y sus partes.
- Se quiere que los clientes ignoren la diferencia entre la composición de objetos y su uso individual.

![logo](https://refactoring.guru/images/patterns/content/composite/composite.png)

## Decorator

Es un patrón de diseño estructural que te permite añadir funcionalidades a objetos colocando estos objetos dentro de objetos encapsuladores especiales que contienen estas funcionalidades.

Propósito: Adjuntar responsabilidades adicionales a un objeto de forma dinámica. Los decoradores proporcionan una alternativa flexible para ampliar la funcionalidad.

### Aplicación: 

- Cuando necesitamos añadir o eliminar dinámicamente las responsabilidades a un objeto, sin afectar a otros objetos.
- Cuando queremos tener las ventajas de la Herencia pero necesitemos añadir funcionalidad durante el tiempo de ejecución. Es más flexible que la Herencia.
- Simplificar el código agregando funcionalidades usando muchas clases diferentes.
- Evitar sobreescribir código viejo agregando, envés, código nuevo.

![logo](https://refactoring.guru/images/patterns/content/decorator/decorator.png)

## Facade

Es un patrón de diseño estructural que proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases.

Propósito: Proporcionar una interfaz unificada para un conjunto de interfaces de un subsistema. Facade define una interfaz de alto nivel que hace que el subsistema sea más fácil de usar.

### Aplicación: 

- Cuando queremos encapsular un subsistema complejo con una interface más simple.
- Para crear una interface simplificada que ejecuta muchas acciones "detŕas del escenario".
- Existen muchas dependencias entre clientes y la implementación de clases de una abstracción. Se introduce el facade para desacoplar el subsistema de los clientes y otros subsistemas.
- Necesitamos desacoplar subsistemas entre sí, haciendo que se comuniquen únicamente mediante Facades.
- Para definir un punto de entrada a cada nivel del subsistema.

![logo](https://refactoring.guru/images/patterns/content/facade/facade.png)

## Flyweight

Es un patrón de diseño estructural que te permite mantener más objetos dentro de la cantidad disponible de RAM compartiendo las partes comunes del estado entre varios objetos en lugar de mantener toda la información en cada objeto.

Propósito: Permite eliminar o reducir la redundancia cuando tenemos gran cantidad de objetos que contienen información idéntica, además de lograr un equilibrio entre flexibilidad y rendimiento (uso de recursos).

Una característica importante es que los objetos Flyweight son inmutables, por lo que no podrán ser modificados una vez construidos. Puede utilizarse conjuntamente con el patrón Factory, de tal modo que en el momento en que se soliciten instancias del objeto, compruebe si ya existe un tipo Flyweight y devuelva esa referencia. En caso de que no exista la creará y la registrará.

### Aplicación:

- Reducir el uso de memoria y/o evitar errores con la misma (java.lang.OutOfMemoryError).
- Aunque la creación de objetos puede ser rápida, se podría reducir los tiempos de ejecución compartiendo objetos.

![logo](https://refactoring.guru/images/patterns/content/flyweight/flyweight.png)

## Proxy

Es un patrón de diseño estructural que te permite proporcionar un sustituto o marcador de posición para otro objeto. Un proxy controla el acceso al objeto original, permitiéndote hacer algo antes o después de que la solicitud llegue al objeto original.

Propósito:

- Proveer un sustituto o "placeholder" de otro objeto para controlar el acceso a este.
- Usar un nivel extra de indirección para permitir el acceso distribuido, controlado e inteligente.
- Agregar un "wrapper" para proteger el componente real de la complejidad innecesaria. Este wrapper permite agregar funcionalidad al objeto de interés sin cambiar el código del objeto.
  
Aunque a simple vista tenga similitudes al patrón Facade, ambos tiene matices diferentes.

- Mientras que los objetos Proxy representan a un objeto, los objetos Facade representan a un subsistema de objetos.
- Un objeto cliente Proxy no puede acceder a un objeto interno directamente, mientras que Facade no lo impide.
- Un objeto Proxy provee control de acceso a un único objeto de interés. Sin embargo, un objeto Facade provee una interface de alto nivel a un subsistema de objetos.

### Aplicación: 

- Cuando haya necesidad de una referencia más versátil y sofisticada a un objeto, no un simple puntero.
- Para adicionar seguridad al acceso de un objeto. El Proxy determinará si el cliente puede acceder al objeto de interés.
- Para proporcionar una API simplificada para que el código del cliente no tenga que lidiar con la complejidad del código del objeto de interés.
- Para proporcionar una interfaz de los web services o recursos REST.

![logo](https://refactoring.guru/images/patterns/content/proxy/proxy.png)
