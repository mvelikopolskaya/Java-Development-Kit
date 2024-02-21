public class Main {
    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        employeeList.addEmployee(new Employee(1, "123", "Anna", 10));
        employeeList.addEmployee(new Employee(2, "456", "Sergey", 3));
        employeeList.addEmployee(new Employee(3, "789", "Irina", 15));
        employeeList.addEmployee(new Employee(4, "012", "Anton", 8));
        employeeList.addEmployee(new Employee(5, "345", "Svetlana", 8));
        employeeList.addEmployee(new Employee(6, "678", "Sergey", 9));

        System.out.println(employeeList.findByExperience(8));
        System.out.println(employeeList.findPhonenumberByName("Sergey"));
        System.out.println(employeeList.findByID(3));
    }
}