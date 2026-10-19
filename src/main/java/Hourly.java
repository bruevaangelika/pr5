public class Hourly extends Employee
        implements Payable, Reportable {

    private final double hourlyRate;
    private final int hours;

    public Hourly(String name, double hourlyRate, int hours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public double salary() {
        return hourlyRate * hours;
    }

    @Override
    public double getPayment() {
        return salary();
    }

    @Override
    public String getReport() {
        return "Hourly: " + name
                + ", зарплата = " + salary();
    }
}