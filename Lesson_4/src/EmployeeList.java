import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<Employee> employeeList;

    public EmployeeList() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> findByExperience(int experience){
       List<Employee> requiredEmployees = new ArrayList<>();
       for(Employee employee: employeeList){
           if(employee.getExperience() == experience)
               requiredEmployees.add(employee);
       }
       return requiredEmployees;
    }

    public List<Employee> findPhonenumberByName(String name){
        List<Employee> requiredEmployees = new ArrayList<>();
        for(Employee employee: employeeList){
            if(employee.getName().equalsIgnoreCase(name))
                requiredEmployees.add(employee);
        }
        return requiredEmployees;
    }

    public List<Employee> findByID(int id){
        List<Employee> requiredEmployees = new ArrayList<>();
        for(Employee employee: employeeList){
            if(employee.getId() == id)
                requiredEmployees.add(employee);
        }
        return requiredEmployees;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employees list:").append("\n");
        for (Employee employee: employeeList){
            sb.append(employee).append("\n");
        }
        return sb.toString();
    }
}
