import org.cts.models.Employee;
import org.cts.services.EmployeeServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Driver {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(org.cts.config.BeanConfig.class);
        Employee employee = applicationContext.getBean("employee", Employee.class);
        System.out.println(employee);
        EmployeeServices employeeServices = applicationContext.getBean("employeeServicesImpl", EmployeeServices.class);
        employee.setEmployeeID("298625");
        employee.setEmployeeName("Aditya chakraborty");
        employee.setAddress("Kolkata");
        employee.setDesignationl("SA");
        employee.setDepartment("IT");
        /*Boolean status = employeeServices.createEmployee(employee);
        System.out.println("Created Employee Successfully :: " + status);*/
        System.out.println("===================Trying to fetch employee detils=================");
        List<Employee> employeeDetails = employeeServices.getEmployeeDetails();
        employeeDetails.stream().forEach(System.out::println);

    }
}
