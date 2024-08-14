# ![logo](https://i.imgur.com/Yt1vXic.png)

Los patrones de diseño (design patterns) son soluciones habituales a problemas comunes en el diseño de software. Cada patrón es como un plano que se puede personalizar para resolver un problema de
diseño particular de tu código.Estos patrones se dividen en tres tipos:

## Tipos de Patrones de Diseño
- Patrones Creacionales
- Patrones Estructurales
- Patrones de Comportamiento

# Patrones Estructurales

Los patrones estructurales explican cómo ensamblar objetos y clases en estructuras más grandes, a la vez que se mantiene la flexibilidad y eficiencia de estas estructuras. Composición de clases u objetos.

## Adapter(Adaptador)

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

## Bridge(Puente)

Es un patrón de diseño estructural que te permite dividir una clase grande, o un grupo de clases estrechamente relacionadas, en dos jerarquías separadas (abstracción e implementación) que pueden desarrollarse independientemente la una de la otra.

Propósito: Permite desacoplar una abstracción de su implementación, de manera que ambas puedan ser modificadas independientemente sin necesidad de alterar por ello la otra.

### Aplicación:

- Desacoplar interfaz e implementación.
- Mejorar la extensibilidad.
- Esconder los detalles de la implementación a los clientes.

![logo](https://refactoring.guru/images/patterns/content/bridge/bridge.png)

## Composite(Objeto Compuesto)

Es un patrón de diseño estructural que te permite componer objetos en estructuras de árbol y trabajar con esas estructuras como si fueran objetos individuales.

Propósito: Componer objetos en estructuras de árbol que representan jerarquías de un todo y sus partes. El Composite provee a los clientes un mismo trato para todos los objetos que forman la jerarquía.

Pensemos en nuestro sistema de archivos, este contiene directorios con archivos y a su vez estos archivos pueden ser otros directorios que contenga más archivos, y así sucesivamente. Lo anterior puede ser representado facilmente con el patrón Composite.

### Aplicación:

- Cuando queremos representar jerarquías de objetos compuestas por un todo y sus partes.
- Se quiere que los clientes ignoren la diferencia entre la composición de objetos y su uso individual.

![logo](https://refactoring.guru/images/patterns/content/composite/composite.png)

## Decorator(Decorador)

Es un patrón de diseño estructural que te permite añadir funcionalidades a objetos colocando estos objetos dentro de objetos encapsuladores especiales que contienen estas funcionalidades.

Propósito: Adjuntar responsabilidades adicionales a un objeto de forma dinámica. Los decoradores proporcionan una alternativa flexible para ampliar la funcionalidad.

### Aplicación: 

- Cuando necesitamos añadir o eliminar dinámicamente las responsabilidades a un objeto, sin afectar a otros objetos.
- Cuando queremos tener las ventajas de la Herencia pero necesitemos añadir funcionalidad durante el tiempo de ejecución. Es más flexible que la Herencia.
- Simplificar el código agregando funcionalidades usando muchas clases diferentes.
- Evitar sobreescribir código viejo agregando, envés, código nuevo.

![logo](https://refactoring.guru/images/patterns/content/decorator/decorator.png)

## Facade(Fachada)

Es un patrón de diseño estructural que proporciona una interfaz simplificada a una biblioteca, un framework o cualquier otro grupo complejo de clases.

Propósito: Proporcionar una interfaz unificada para un conjunto de interfaces de un subsistema. Facade define una interfaz de alto nivel que hace que el subsistema sea más fácil de usar.

### Aplicación: 

- Cuando queremos encapsular un subsistema complejo con una interface más simple.
- Para crear una interface simplificada que ejecuta muchas acciones "detŕas del escenario".
- Existen muchas dependencias entre clientes y la implementación de clases de una abstracción. Se introduce el facade para desacoplar el subsistema de los clientes y otros subsistemas.
- Necesitamos desacoplar subsistemas entre sí, haciendo que se comuniquen únicamente mediante Facades.
- Para definir un punto de entrada a cada nivel del subsistema.

![logo](https://refactoring.guru/images/patterns/content/facade/facade.png)

## Flyweight(Peso ligero)

Es un patrón de diseño estructural que te permite mantener más objetos dentro de la cantidad disponible de RAM compartiendo las partes comunes del estado entre varios objetos en lugar de mantener toda la información en cada objeto.

Propósito: Permite eliminar o reducir la redundancia cuando tenemos gran cantidad de objetos que contienen información idéntica, además de lograr un equilibrio entre flexibilidad y rendimiento (uso de recursos).

Una característica importante es que los objetos Flyweight son inmutables, por lo que no podrán ser modificados una vez construidos. Puede utilizarse conjuntamente con el patrón Factory, de tal modo que en el momento en que se soliciten instancias del objeto, compruebe si ya existe un tipo Flyweight y devuelva esa referencia. En caso de que no exista la creará y la registrará.

### Aplicación:

- Reducir el uso de memoria y/o evitar errores con la misma (java.lang.OutOfMemoryError).
- Aunque la creación de objetos puede ser rápida, se podría reducir los tiempos de ejecución compartiendo objetos.

![logo](https://refactoring.guru/images/patterns/content/flyweight/flyweight.png)

## Proxy(Representante)

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

# Patrones de Comportamiento

Los patrones de comportamiento tratan con algoritmos y la asignación de responsabilidades entre objetos. Forma en que las clases u objetos se comunican y distribuyen funcionalidades.

## Chain of Responsibility(Cadena de Responsabilidad)

Es un patrón de diseño de comportamiento que te permite pasar solicitudes a lo largo de una cadena de manejadores. Al recibir una solicitud, cada manejador decide si la procesa o si la pasa al siguiente manejador de la cadena.

Propósito: Evita acoplar el emisor de una petición a su receptor dando a más de un objeto la posibilidad de responder a una petición. Cada elemento deberá tener referencia al siguiente.

### Aplicación: 

- Hay más de un objeto que puede manejar una petición, y el manejador no se conoce previamente, sino que debería determinarse automáticamente.
- Se quiere enviar una petición a un objeto entre varios sin especificar explícitamente el receptor.
- El conjunto de objetos que pueden tratar una petición debería ser especificado en función del contexto o de condiciones específicas en el momento en que se realiza la solicitud.

![logo](https://refactoring.guru/images/patterns/content/chain-of-responsibility/chain-of-responsibility.png)

## Command(Action)

Es un patrón de diseño de comportamiento que convierte una solicitud en un objeto independiente que contiene toda la información sobre la solicitud. Esta transformación te permite parametrizar los métodos con diferentes solicitudes, retrasar o poner en cola la ejecución de una solicitud y soportar operaciones que no se pueden realizar.

Este patrón desacopla al objeto que invoca la operación del objeto que sabe cómo llevar a cabo la misma. Un objeto llamado Invoker transfiere el comando a otro objeto llamado Receiver el cual ejecuta el código correcto para el comando recibido.

Propósito: Encapsular una petición en forma de objeto, permitiendo de ese modo que parametrizar clientes con diferentes peticiones, "colas" o registros de solicitudes, y apoyar las operaciones de deshacer.

### Aplicación:

- Cuando queremos realizar peticiones en diferentes tiempos. Se puede hacer a través de la especificación de una "cola".
- Para implementar la función de deshacer (undo), ya que se puede almacenar el estado de la ejecución del comando para revertir sus efectos.
- Cuando necesitemos mantener un registro (log) de los cambios y acciones.

![logo](https://refactoring.guru/images/patterns/content/command/command-es.png)

## Iterator(Iterador)

Es un patrón de diseño de comportamiento que te permite recorrer elementos de una colección sin exponer su representación subyacente (lista, pila, árbol, etc.).

Propósito: Define una interfaz que declara los métodos necesarios para acceder secuencialmente a un grupo de objetos de una colección. Algunos de los métodos que podemos definir en la interfaz Iterador son:

Primero(), Siguiente(), HayMas() y ElementoActual().

### Aplicación: 

- Se desea acceder a los elementos de un contenedor de objetos (por ejemplo, una lista) sin exponer cómo está implementada internamente.

![logo](https://refactoring.guru/images/patterns/content/iterator/iterator-es.png)

## Mediator(Intermediario)

Es un patrón de diseño de comportamiento que te permite reducir las dependencias caóticas entre objetos. El patrón restringe las comunicaciones directas entre los objetos, forzándolos a colaborar únicamente a través de un objeto mediador.

Propósito: Define un objeto que encapsula cómo un conjunto de objetos interactúan, pudiendo alterar el comportamiento del programa en ejecución. La comunicación entre objetos es encapsulada con un objeto mediador. Los objetos no se comunican de forma directa entre ellos, en lugar de ello se comunican mediante el mediador. Esto reduce las dependencias entre los objetos en comunicación, reduciendo entonces la Dependencia de código.

### Aplicación: 

- Se desea reducir la dependencia entre clases evitando que los objetos se relacionen entre ellos de forma explícita, y permitiendo variar cualquier interacción independientemente.

![logo](https://refactoring.guru/images/patterns/content/mediator/mediator.png)

## Memento(Recuerdo)

Es un patrón de diseño de comportamiento que te permite guardar y restaurar el estado previo de un objeto sin revelar los detalles de su implementación.

Propósito: Almacenar el estado de un objeto (o del sistema completo) en un momento dado, de manera que se pueda restaurar en ese punto de manera sencilla. Se mantiene almacenado el estado del objeto para un instante de tiempo en una clase independiente de aquella a la que pertenece el objeto (pero sin romper la encapsulación), de forma que ese recuerdo permita que el objeto sea modificado y pueda volver a su estado anterior.

### Aplicación:

- Se quiere poder restaurar el sistema desde estados pasados.
- Se desea facilitar el hacer y deshacer de determinadas operaciones, para lo que habrá que guardar los estados anteriores de los objetos sobre los que se opere (o bien recordar los cambios de forma incremental).

![logo](https://refactoring.guru/images/patterns/content/memento/memento-es.png)

## Observer(Publicación-Suscripción)

Es un patrón de diseño de comportamiento que te permite definir un mecanismo de suscripción para notificar a varios objetos sobre cualquier evento que le suceda al objeto que están observando.

Propósito: Definir una dependencia de uno a muchos entre los objetos de manera que cuando un objeto cambia de estado, todos los que dependen de él son notificados y se actualizan automáticamente. Los Observers se registran con el Subject a medida que se crean. Siempre que el Subject cambie, difundirá a todos los Observers registrados que ha cambiado, y cada Observer consulta al Subject que supervisa para obtener el cambio de estado que se haya generado.

En Java tenemos acceso a la clase Observer mediante java.util.Observer

### Aplicación:

- Un cambio en un objeto requiere cambiar los demás, pero no sabemos cuántos objetos hay que cambiar.
- Configurar de manera dinámica un componente de la Vista, envés de estáticamente durante el tiempo de compilación.
- Un objeto debe ser capaz de notificar a otros objetos sin que estos objetos estén fuertemente acoplados.

![logo](https://refactoring.guru/images/patterns/content/observer/observer.png)

## State(Estado)

Es un patrón de diseño de comportamiento que permite a un objeto alterar su comportamiento cuando su estado interno cambia. Parece como si el objeto cambiara su clase.

Propósito: Permite a un objeto alterar su comportamiento dependiendo de su estado interno.

## Aplicación:

- Un determinado objeto tiene diferentes estados y también distintas responsabilidades según el estado en que se encuentre en determinado instante.
- Se desea simplificar casos en los que se tiene un complicado y extenso código de decisión que depende del estado del objeto.

![logo](https://refactoring.guru/images/patterns/content/state/state-es.png)
