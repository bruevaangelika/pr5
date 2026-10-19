public class Salaried extends Employee
        implements Payable, Reportable {

    private final double monthlySalary;

    public Salaried(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double salary() {
        return monthlySalary;
    }

    @Override
    public double getPayment() {
        return salary();
    }

    @Override
    public String getReport() {
        return "Salaried: " + name
                + ", зарплата = " + salary();
    }
}
