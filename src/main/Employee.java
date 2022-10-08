package main;

public class Employee {

    private String name;
    private double salary;
    private double workHours;
    private int hireYear;

    public Employee(String name, double salary, double workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public Double tax(){
        double limitTax = 1000;
        double taxPercentage = 3;
        if(salary < 0){
            throw new IllegalArgumentException("Invalid value.");
        }
        if(salary <= limitTax){
            return 0.0;
        }
        else if(salary > limitTax){
            return salary*taxPercentage/100;
        }
        throw new IllegalArgumentException("Invalid value");
    }

    public Double bonus(){
        int limitWorkHours = 40;
        if(workHours > limitWorkHours){
            return (workHours - limitWorkHours)*30;
        }
        return 0.0;
    }

    public Double raiseSalary(){
        if(salary < 0){
            throw new IllegalArgumentException("Invalid value.");
        }
        int totalYearsOfWork = 2021 - hireYear;
        int lowerLimit = 10;
        int upperLimit = 20;
        double lowRaisePercentage = 5.0;
        double midRaisePercentage = 10.0;
        double upRaisePercentage = 15.0;
        double totalRaise;

        if(totalYearsOfWork < lowerLimit)
           totalRaise = (salary*lowRaisePercentage)/100;
        else if(lowerLimit <= totalYearsOfWork && totalYearsOfWork < upperLimit)
            totalRaise = (salary*midRaisePercentage)/100;
        else if(totalYearsOfWork >= upperLimit)
            totalRaise = (salary*upRaisePercentage)/100;
        else
            throw new IllegalArgumentException("Invalid value");

        return ((bonus() + totalRaise) - tax());
    }

    @Override
    public String toString() {
        return "The name of the employee is: " + name + "\n" +
                "The salary of the employee is: " + salary + "\n" +
                "The work hours of the employee is: " + workHours + "\n" +
                "The hire year of the employee is: " + hireYear + "\n" +
                "Tax: " + tax() + "\n" + "Bonus: " + bonus() + "\n" +
                "Raise salary: " + raiseSalary() + "\n" +
                "Final salary: " + (raiseSalary() + salary);
    }
}
