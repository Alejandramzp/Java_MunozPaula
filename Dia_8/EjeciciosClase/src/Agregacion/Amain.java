
package Agregacion;

public class Amain {
    public static void main(String[] args) {
        Department dep = new Department("Engineering");
        Employee emp1 = new Employee("Bang Chan");
        Employee emp2 = new Employee("Chang bin");

        dep.addEmployee(emp1);
        dep.addEmployee(emp2);

        for(int i = 0; i<dep.getEmployees().size(); i++){
            System.out.println("Employee #" +(i+1)+ ":" + dep.getEmployees().get(i));
        }
    }
}
