package model.EmployeeAndDepartment;

public abstract class Employee {

    public enum gender {
        Male,
        Female
    }

    public enum type {
        FullTime,
        PartTime
    }

    static  int cnt=0;

    private int Id;

    private String Name;

    private Departments Department;

    private int Age;

    private type Type;

    private double Salary;

    private gender Gender;

    public Employee(double salary, gender gender, type Type,
                    int age, Departments department, String name) {
        if(salary<=0){
            throw new IllegalArgumentException("Invaild Salary");
        }
        else
            this.Salary=salary;

        this.Gender = gender;

        this.Type = Type;

        if(age<=0) {
            throw new IllegalArgumentException("Invaild Age");
        }
        else
            this.Age=age;

        if(department==null)
            throw new IllegalArgumentException("Invaild Department");
        else
            Department = department;

        Name = name;

        cnt++;

        Id = cnt;

    }

    public int getId() {
        return Id;
    }

    public gender getGender() {
        return Gender;
    }

    public double getSalary() {
        return Salary;
    }

    public type getType() {
        return Type;
    }

    public int getAge() {
        return Age;
    }

    public Departments getDepartment() {
        return Department;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean setDepartment(Departments department) {
        if(department==null){
            return false;
        }
        Department = department;
        return true;
    }

    public Boolean setAge(int age) {
        if(age<=0){
            return false;
        }
        Age = age;
        return true;
    }

    public void setType(type Type) {
        this.Type = Type;
    }

    public Boolean setSalary(double salary) {
        if(salary<=0){
            return false;
        }
        Salary = salary;
        return true;
    }

    public abstract Boolean updateSalary(double x,double y);


}
