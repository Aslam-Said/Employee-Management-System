package model.Core;

import model.EmployeeAndDepartment.Employee;

public class Update {

    public static Boolean update(Employee employee , String name , int age , double salary , double bonus){
        int prevAge = employee.getAge();
        Boolean ret = employee.setAge(age);
        if(!ret) {
            throw new IllegalArgumentException("Invalid Age");
        }
        ret = employee.updateSalary(salary , bonus);
        if(!ret){
            employee.setAge(prevAge);
            throw new IllegalArgumentException("Invalid Salary");
        }
        employee.setName(name);

        return true;
    }

    public static Boolean update(Employee employee , String name , int age , double rate , int hrs){
        int prevAge = employee.getAge();
        Boolean ret = employee.setAge(age);
        if(!ret) {
            throw new IllegalArgumentException("Invalid Age");
        }
        ret = employee.updateSalary(rate , (double)hrs);
        if(!ret){
            employee.setAge(prevAge);
            throw new IllegalArgumentException("Invalid Salary");
        }
        employee.setName(name);

        return true;
    }

}
