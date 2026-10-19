public class EmployeeService {
    private Employee[] employees;

    public EmployeeService(Employee[] employees) {
        this.employees = employees;
    }
//печать оплаты
    public void printPayments(Payable[] payables) {
        System.out.println("\n=== Выплаты ===");

        for (Payable payable : payables) {
            payable.printPayment();
        }
    }

    public void printReports(Reportable[] reports) {
        System.out.println("\n=== Отчеты ===");

        for (Reportable report : reports) {
            System.out.println(report.getReport());
        }
    }
//подсчет общей суммы
    public double sumCalculations(
            Employee[] employees,
            Calculation calculation) {

        double sum = 0;

        for (Employee employee : employees) {
            sum += calculation.calculate(employee);
        }

        return sum;
    }

    public void selectEmployees(Selection selection) {
        for (Employee employee : employees) {
            if (selection.test(employee)) {
                System.out.println(
                        employee.getName() + ": "
                                + employee.salary()
                );
            }
        }
    }

    public void printReport() {
        System.out.println("\n=== Общий отчет ===");

        double total = 0;

        for (Employee employee : employees) {
            System.out.printf(
                    "%s: %.2f%n",
                    employee.getName(),
                    employee.salary()
            );

            total += employee.salary();
        }

        System.out.printf(
                "Общая сумма зарплат: %.2f%n",
                total
        );
    }
}