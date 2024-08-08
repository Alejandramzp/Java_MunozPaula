# ![Logo](https://osvaldogalvan.com/wp-content/uploads/principios-solid.png)

Los Principios SOLID tienen cinco principios de diseño de clases Orientado a Objetos. Son un conjunto de reglas y mejores prácticas a seguir al diseñar una estructura de clase.
Estos principios se llamaron S.O.L.I.D. por sus siglas en inglés:

    S: Single responsibility principle o Principio de responsabilidad única.
    O: Open/closed principle o Principio de abierto/cerrado.
    L: Liskov substitution principle o Principio de sustitución de Liskov.
    I: Interface segregation principle o Principio de segregación de la interfaz.
    D: Dependency inversion principle o Principio de inversión de dependencia.
    
Aplicar estos principios facilitará el trabajo y proporcionará algunas ventajas:

    - Crear un software eficaz: que cumpla con su cometido y que sea robusto y estable.
    - Escribir un código limpio y flexible ante los cambios: que se pueda modificar fácilmente según necesidad, que sea reutilizable y mantenible.
    - Permitir escalabilidad: que acepte ser ampliado con nuevas funcionalidades de manera ágil.
    
## Single Responsibility Principle (SRP)

El principio habla de que "Toda clase debería tener una sola responsabilidad: esta debería tener un solo propósito en el sistema, y solo debería haber una razón para cambiarla".
Según este principio, cada clase debería tener una única responsabilidad, en otras palabras, un solo trabajo.

Supongamos que tenemos una clase Superheroe, como sabes, los superhéroes tienen habilidades y características muy diferentes, así que podríamos pensar en una clase de este tipo:

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/38e73412-7179-473d-9b69-0f1333041829.png)

En la que agregamos métodos como volar, que es una habilidad que tienen casi todos los superhéroes (pero no todos), luego trepar paredes que solo lo tiene spiderman, luego lanzar fuego y así. Esta clase está haciendo demasiadas cosas y tiene demasiadas razones para cambiar, lo que va a originar problemas cuando el código crezca.

La manera de resolver este problema es que la clase superhéroe tenga una sola función, por ejemplo, realizar superhabilidades, y que las habilidades individuales sean delegadas a otras clases.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/1523189b-9504-4166-8f5c-d67b47f19123.png)

### Implementación

Ejemplo de clase Coche:

```
class Coche {  
    String marca;

    Coche(String marca){ this.marca = marca; }

    String getMarcaCoche(){ return marca; }

    void guardarCocheDB(Coche coche){ ... }
}
```
Como podemos observar, la clase Coche permite tanto el acceso a las propiedades de la clase como a realizar operaciones sobre la BBDD, por lo que la clase ya tiene más de una responsabilidad.Si debemos realizar cambios en los métodos que realizan las operaciones no será muy eficiente.

Para evitar esto, debemos separar las responsabilidades de la clase, por lo que podemos crear otra clase que se encargue de las operaciones a la BBDD:

```
class Coche {  
    String marca;

    Coche(String marca){ this.marca = marca; }

    String getMarcaCoche(){ return marca; }
}

class CocheDB{  
    void guardarCocheDB(Coche coche){ ... }
    void eliminarCocheDB(Coche coche){ ... }
}
```
De esta forma el sistema será mucho más fácil de segmentar y de corregir en caso de errores, lo que ayudará a organizar las clases y hacerlas más escalables.

## Open/Closed Principle (OCP)

El principio habla de que "El código debería estar abierto a la extensión pero cerrado a la modificación. Si tenemos un buen diseño de código no tenemos que cambiar tanto código para agregar nuevas funciones. En otras palabras, en lugar de cambiar el código de una clase existente, se debe agregar una nueva funcionalidad para evitar posibles errores, tanto de compatibilidad como de código heredado.

Usemos el ejemplo anterior: tenemos la clase superhéroe con el método realizarSuperHabilidades, a partir de esa clase instanciamos el objeto Superman. 

Pero, ¿cuál es la principal habilidad de Superman? Volar. Entonces, ¿agregamos volar a la clase Superhéroe? No, porque violaría el principio de abierto / cerrado.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/c84e87e8-1952-4932-9aea-77ad36be198e.png)

La forma correcta sería tener una interfaz superhabilidad y diferentes clases para cada habilidad. Así, cada habilidad debe cumplir el contrato de la interfaz y cada vez que creamos un nuevo superhéroe le asignamos sus habilidades.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/eed28ec6-0493-4bf2-aca8-9120ddce2253.png)

### Implementación

Ejemplo de clase Coche:

```
class Coche {  
    String marca;

    Coche(String marca){ this.marca = marca; }

    String getMarcaCoche(){ return marca; }
}
```
Si quisiéramos iterar a través de una lista de coches e imprimir sus marcas por pantalla:

```
public static void main(String[] args) {  
    Coche[] arrayCoches = {
            new Coche("Renault"),
            new Coche("Audi")
    };
    imprimirPrecioMedioCoche(arrayCoches);
}

public static void imprimirPrecioMedioCoche(Coche[] arrayCoches){  
    for (Coche coche : arrayCoches) {
        if(coche.marca.equals("Renault")) System.out.println(18000);
        if(coche.marca.equals("Audi")) System.out.println(25000);
    }
}
```
Esto no cumpliría el principio abierto/cerrado, ya que si decidimos añadir un nuevo coche de otra marca, también tendríamos que modificar el método que hemos creado anteriormente. Para cada nuevo coche habría que añadir nueva lógica al método precioMedioCoche().

Para que cumpla con este principio podríamos hacer lo siguiente:

```
abstract class Coche {  
    // ...
    abstract int precioMedioCoche();
}

class Renault extends Coche {  
    @Override
    int precioMedioCoche() { return 18000; }
}

class Audi extends Coche {  
    @Override
    int precioMedioCoche() { return 25000; }
}

class Mercedes extends Coche {  
    @Override
    int precioMedioCoche() { return 27000; }
}

public static void main(String[] args) {

    Coche[] arrayCoches = {
            new Renault(),
            new Audi(),
            new Mercedes()
    };

    imprimirPrecioMedioCoche(arrayCoches);
}

public static void imprimirPrecioMedioCoche(Coche[] arrayCoches){  
    for (Coche coche : arrayCoches) {
        System.out.println(coche.precioMedioCoche());
    }
}
```
Cada coche extiende la clase abstracta Coche e implementa el método abstracto precioMedioCoche(). Así, cada coche tiene su propia implementación del método precioMedioCoche(), por lo que el método imprimirPrecioMedioCoche() itera el array de coches y solo llama al método precioMedioCoche().

Ahora, si añadimos un nuevo coche, precioMedioCoche() no tendrá que ser modificado. Solo tendremos que añadir el nuevo coche al array, cumpliendo así el principio abierto/cerrado.

## Liskov Substitution Principle (LSP) 

El principio declara que "Los objetos de las subclases deberían ser reemplazables por objetos de sus clases superiores (base o padre) sin afectar el comportamiento del sistema". Esto define una jerarquía específica de clases que no afecta el comportamiento del sistema sin importar si se implementa la clase padre o una de sus subclases.

Por ejemplo, si tenemos la clase Superhéroe volador que hereda de la clase superhéroe, los objetos instanciados a partir de esas dos clases deberían ser también superhéroes, obvio. Así que podrían intercambiarse.

Entonces, supongamos que de Superhéroe instancio a Ironman y de Superhéroe volador a Superman, ambos podrían intercambiarse sin problemas, los dos son superhéroes y los dos vuelan.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/9428ead4-7105-48fc-b404-cd439eebd1b0.png)

Ahora supongamos que en la subclase Superheroe volador agrego una restricción que dice que solo puede volar con sus superpoderes. En ese caso, Ironman, que vuela con un traje, no cumpliría con esa restricción y los objetos ya no serían intercambiables. Habríamos roto el principio.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/bf3cdb9f-6891-4821-9dce-a571e85357b6.png)

Esto quiere decir que debemos evitar agregar restricciones o cambiar el comportamiento de los métodos heredados en una clase para no tener luego comportamientos inesperados en la aplicación.

### Implementación

Ejemplo de Coches:

```
Coche[] arrayCoches = {  
        new Renault(),
        new Audi(),
        new Mercedes(),
        new Ford()
};

public static void imprimirNumAsientos(Coche[] arrayCoches){  
    for (Coche coche : arrayCoches) {
        if(coche instanceof Renault)
            System.out.println(numAsientosRenault(coche));
        if(coche instanceof Audi)
            System.out.println(numAsientosAudi(coche));
        if(coche instanceof Mercedes)
            System.out.println(numAsientosMercedes(coche));
        if(coche instanceof Ford)
            System.out.println(numAsientosFord(coche));
    }
}
imprimirNumAsientos(arrayCoches);  
```
Esto no cumple con el principio de substitución de Liskov ni con el de abierto/cerrado.El programa debe conocer cada tipo de Coche y llamar a su método numAsientos() asociado. Así, si añadimos un nuevo coche, el método debe modificarse para aceptarlo.

Para que este método cumpla con el principio, la clase Coche debe definir el nuevo método:

```
abstract class Coche {

    // ...
    abstract int numAsientos();
}
```

Y las subclases deben implementar dicho método:

```
class Renault extends Coche {

    // ...
    @Override
    int numAsientos() {
        return 5;
    }
}
```
Ahora volvemos a implementar el método anterior, simplemente llama al método numAsientos() de la superclase donde el parámetro es de tipo coche.

```
public static void imprimirNumAsientos(Coche[] arrayCoches){  
        for (Coche coche : arrayCoches) {
            System.out.println(coche.numAsientos());
        }
    }

imprimirNumAsientos(arrayCoches);  
```

Como podemos ver, ahora el método imprimirNumAsientos() no necesita saber con qué tipo de coche va a realizar su lógica, simplemente llama al método numAsientos() del tipo Coche, ya que como tal, una subclase de Coche debe implementar dicho método.

## Interface Segregation Principle (ISP) 

El principio declara que "Las clases que implementen una interfaz o una clase abstracta no deben estar obligadas a implementar partes que no utilizaran".Las interfaces ayudan a desacoplar partes del sistema, Si se requiere se puede dividir una interfaz compleja en dos o más que contengan métodos que sabemos serán implementados en su totalidad por las clases que la hereden.

Este principio debe asegurar que las clases que hereden una interfaz hagan uso de todos los métodos implementados. No se debe forzar a la subclase a heredar métodos innecesarios.

Volvamos al ejemplo de la clase superhéroe. Por el principio de responsabilidad única sabemos que no debemos meter todas las habilidades ahí, sino crear una interfaz. Entonces creamos la interfaz HabilidadesDelSuperHeroe y agregamos habilidades como volar, trepar muros, lanzar fuego, etc.

Esto parece buena idea, pero supongamos que creamos a Superman a partir de la clase superhéroe. Según este diseño, Superman treparía muros y lanzaría fuego y sabemos que no es así, por lo tanto, hemos roto el principio de segregación de interfaces.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/245a4cf9-6c64-4256-86dd-cb77dbcd3987.png)

Lo que podemos hacer es tener una clase Superheroe con todos los métodos y propiedades comunes a los superhéroes. Luego, con herencia, creamos clases hijas para cada tipo de superhéroe. Como cada tipo de superhéroe tiene habilidades diferentes, creamos interfaces específicas para cada habilidad. Entonces el superhéroe trepamuros tiene superfuerza y trepa muros, y el superheroe volador puede volar y tiene superfuerza.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/2e0a62f7-ecc2-4bf6-88d9-07a3ea301795.png)

¡Ahora sí hemos segregado las interfaces! Y podemos instanciar superhéroes específicos que tendrán sus superpoderes específicos (ahora Superman ya no trepa muros).

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/4fa21f3a-0d5e-4201-bee9-44a0e11f22e0.png)

### Implementación

Ejemplo de clases de aves:

Queremos definir las clases necesarias para albergar algunos tipos de aves como loros y tucanes.Pero ahora queremos añadir a los pingüinos. Estos son aves, pero además tienen la habilidad de nadar.

```
interface IAve {  
    void volar();
    void comer();
    void nadar();
}

class Loro implements IAve{

    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }

    @Override
    public void nadar() {
        //...
    }
}

class Pinguino implements IAve{

    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }

    @Override
    public void nadar() {
        //...
    }
}
```

El problema es que el loro no nada, y el pingüino no vuela, por lo que tendríamos que añadir una excepción o aviso si se intenta llamar a estos métodos. Además, si quisiéramos añadir otro método a la interfaz IAve, tendríamos que recorrer cada una de las clases que la implementa e ir añadiendo la implementación de dicho método en todas ellas. Esto viola el principio de segregación de interfaz, ya que estas clases (los clientes) no tienen por qué depender de métodos que no usan.

Lo más correcto sería separar más las interfaces, tanto como sea necesario. En este caso podríamos hacer lo siguiente:

```
interface IAve {  
    void comer();
}
interface IAveVoladora {  
    void volar();
}

interface IAveNadadora {  
    void nadar();
}

class Loro implements IAve, IAveVoladora{

    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }
}

class Pinguino implements IAve, IAveNadadora{

    @Override
    public void nadar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }
}
```
Así, cada clase implementa las interfaces de la que realmente necesita implementar sus métodos. A la hora de añadir nuevas funcionalidades, esto nos ahorrará bastante tiempo, y además, cumplimos con el primer principio (Responsabilidad Única).

## Dependency Inversion Principle (DIP) 

El principio declara que "Las clases de alto nivel no deberían depender de clase de bajo nivel, estas deberían depender de sus abstracciones" y "Las abstracciones no deberían depender de detalles. Los detalles deberían depender de abstracciones". El objetivo de este principio es conseguir desacoplar las clases, lograr que los módulos de la aplicación no dependan unos de otros, pero tampoco de componentes externos como bases de datos.

Para eliminar dependencias en el código hacemos uso de las interfaces y clases abstractas. Si una clase necesita de otra, la inicialización de esta segunda clase debería venir desde fuera, es decir, no crear objetos dentro de una clase.

Por ejemplo, imaginemos la clase TheAvengers que es de alto nivel porque requiere a las clases Ironman y Cap que son las de bajo nivel.

Lo que nuestro sentido común nos diría es que dentro de la clase TheAvengers llamemos a las clases Ironmany Cap. Pero esto sería un error, ya que si luego queremos agregar a Hulk tendríamos que modificar la clase TheAvengers y esto viola el principio de abierto y cerrado. Cerrado para su modificación pero abierto para su extensión.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/ef5ab36f-14f0-4352-8179-fa0612c36f75.png)

Lo que haremos es usar una interfaz Avenger que tiene el contrato que deben seguir todos los avengers. Y por su lado, la clase TheAvengers recibe las instancias de los superhéroes a través de la interfaz. Por eso a esta técnica se le conoce como inyección de dependencias, ya que la clase, en vez de traer las dependencias, las recibe desde afuera.

![Logo](https://edteam-media.s3.amazonaws.com/blogs/big/8b0f199e-e7d7-4703-804a-21c1a30ea0ce.png)

### Implementación

Ejemplo de acceso a datos:

Supongamos que tenemos una clase para realizar el acceso a datos, y lo hacemos a través de una BBDD:

```
class DatabaseService{  
    //...
    void getDatos(){ //... }
}

class AccesoADatos {

    private DatabaseService databaseService;

    public AccesoADatos(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    Dato getDatos(){
        databaseService.getDatos();
        //...
    }
}
```
En el futuro queremos cambiar el servicio de BBDD por un servicio que conecta con una API. Para esto tendríamos que ir modificando todas las instancias de la clase AccesoADatos, una por una. Esto es debido a que nuestro módulo de alto nivel (AccesoADatos) depende de un módulo de más bajo nivel (DatabaseService), violando así el principio de inversión de dependencias. El módulo de alto nivel debería depender de abstracciones.

Para arreglar esto, podemos hacer que el módulo AccesoADatos dependa de una abstracción más genérica:

```
interface Conexion {  
    Dato getDatos();
    void setDatos();
}

class AccesoADatos {

    private Conexion conexion;

    public AccesoADatos(Conexion conexion){
        this.conexion = conexion;
    }

    Dato getDatos(){
        conexion.getDatos();
    }
}
```
Así, sin importar el tipo de conexión que se le pase al módulo AccesoADatos, ni este ni sus instancias tendrán que cambiar, por lo que nos ahorraremos mucho trabajo.

Ahora, cada servicio que queramos pasar a AccesoADatos deberá implementar la interfaz Conexion:

```
class DatabaseService implements Conexion {

    @Override
    public Dato getDatos() { //... }

    @Override
    public void setDatos() { //... }
}

class APIService implements Conexion{

    @Override
    public Dato getDatos() { //... }

    @Override
    public void setDatos() { //... }
}
```
Así, tanto el módulo de alto nivel como el de bajo nivel dependen de abstracciones, por lo que cumplimos el principio de inversión de dependencias. Además, esto nos forzará a cumplir el principio de Liskov, ya que los tipos derivados de Conexion (DatabaseService y APIService) son sustituibles por su abstracción (interfaz Conexion).

## Referencias

- [Principios SOLID](https://www.enmilocalfunciona.io/principios-solid/)
- [EDteam](https://ed.team/blog/que-son-los-principios-solid-en-programacion-la-mejor-explicacion-en-espanol)
