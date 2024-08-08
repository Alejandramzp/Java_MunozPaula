
package ISP.Good;


public class HumanWorker implements Worker,Eater {
    @Override
    public void eat(){
        System.out.println("Tocó Comer...");
    }
    @Override
    public void produce(){
        System.out.println("Nací para producir...");
    }
}
