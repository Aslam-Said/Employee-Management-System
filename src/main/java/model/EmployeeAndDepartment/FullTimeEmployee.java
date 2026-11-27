package model.EmployeeAndDepartment;
import java.util.Scanner;
public class FullTimeEmployee extends Employee{
    private int MonthlySalary;
    private int MonthlyBonus;

    private FullTimeEmployee(double salary, gender Gender, type Type, int age, Departments department,
                            String name, int monthlyBonus, int monthlySalary) {
        super(salary, Gender, Type, age, department, name);
        if(MonthlySalary<=0)
            throw new IllegalArgumentException("Invaild Monthly salary");
        else
            MonthlyBonus = monthlyBonus;
        if(MonthlyBonus<=0)
            throw new IllegalArgumentException("Invaild Monthly Bonus");
        else
            MonthlySalary = monthlySalary;
    }
    public FullTimeEmployee createFullTimeEmployee(double salary, gender Gender, type Type, int age, Departments department,
                                                   String name, int monthlyBonus, int monthlySalary){
        try {
            return new FullTimeEmployee( salary,  Gender, Type,  age, department,
                     name, monthlyBonus, monthlySalary);
        }
        catch (IllegalArgumentException e){
            System.out.println("Invaild because :  "+e.getMessage());
            return null;
        }
    }

    public int getMonthlySalary() {
        return MonthlySalary;
    }

    public int getMonthlyBonus() {
        return MonthlyBonus;
    }

    public boolean setMonthlySalary(int monthlySalary) {
        if(monthlySalary<=0)
            return false;

        MonthlySalary = monthlySalary;
        return true;
    }

    public boolean setMonthlyBonus(int monthlyBonus) {
        if(monthlyBonus<=0)
            return false;
        MonthlyBonus = monthlyBonus;
        return true;
    }

    public boolean updateSalary(){
        System.out.println("Enter the new Monthly Salary: ");
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        System.out.println("Eneter the new Monthly Bonus: ");
        int y=scanner.nextInt();
        boolean check=setMonthlySalary(x);
        boolean check2=setMonthlyBonus(y);
        if(!check||!check2){
            return false;
        }
        return true;
    }
}
