
package ISP.Bad;


public class RobotWorker implements Worker{
    
    @Override
    public void produce(){
        System.out.println("Produzco.");
    }
    
    @Override
    public void eat(){
        throw new UnsupportedOperationException("¿Queseso?");
    }
    
}
