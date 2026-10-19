public class Manager extends Employee
        implements Payable, Reportable {

    private double baseSalary;
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double salary() {
        return baseSalary + bonus;
    }

    @Override
    public double getPayment() {
        return salary();
    }

    @Override
    public String getReport() {
        return "Manager: " + name
                + ", зарплата = " + salary();
    }
}