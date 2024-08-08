
package ISP.Bad;


public class HumanWorker implements Worker {
    
    @Override
    public void produce(){
        System.out.println("Estoy produciendo");
    }
    
    @Override
    public void eat(){
        System.out.println("Me tocó comer...");
    }
}
