
package LSP.Bad;


public class Penguin extends Bird{
    
    @Override
    public void fly(){
        throw new UnsupportedOperationException("¡Los pinguinos no vuelan!");
    }
    
}
