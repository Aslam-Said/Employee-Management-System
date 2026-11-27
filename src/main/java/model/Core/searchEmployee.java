package model.Core;

import model.EmployeeAndDepartment.Employee;

import java.util.ArrayList;

public class searchEmployee {

    public static ArrayList<Employee> search(ArrayList<Employee>employees,String query){
        ArrayList<Employee> result=new ArrayList<Employee>();

        if(employees==null)
            return result;
        if(query==null||query.trim().isEmpty()){
            result.addAll(employees);
            return result;
        }
        String current=query.trim();
        for (Employee emp:employees){
            String id=String.valueOf(emp.getId());
            if(id.contains(current))
                result.add(emp);
        }
        return result;
    }

    public static ArrayList<Employee> search(ArrayList<Employee>employees,Departments dep){
        ArrayList<Employee> res=new ArrayList<Employee>();

        for (Employee emp:employees){
            if(dep == emp.getDepartment()){
                res.add(emp);
            }
        }

        return res;

    }
}
