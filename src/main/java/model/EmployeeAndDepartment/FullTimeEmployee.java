package model.EmployeeAndDepartment;
import java.util.Scanner;
public class FullTimeEmployee extends Employee{
    private int MonthlySalary;
    private int MonthlyBonus;

    public FullTimeEmployee(double salary, gender Gender, type Type, int age, Departments department,
                            String name, int monthlyBonus, int monthlySalary) {
        super(salary, Gender, Type, age, department, name);
        if(MonthlySalary<=0)
            throw new IllegalArgumentException("Invalid Monthly salary: it must be greater than zero");
        else
            MonthlyBonus = monthlyBonus;
        if(MonthlyBonus<=0)
            throw new IllegalArgumentException("Invalid Monthly Bonus :it must be greater than zero");
        else
            MonthlySalary = monthlySalary;
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

    public boolean updateSalary(int monthlySalary,int monthlyBonus){
        this.setSalary(this.MonthlySalary+this.MonthlyBonus);
        return true;
    }
}
