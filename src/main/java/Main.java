
public class Main {
    public static void main(String[] args) {

        //создание сотрудников
        Salaried salaried = new Salaried("Анна", 60000);
        Hourly hourly = new Hourly("Иван", 500, 80);
        Manager manager = new Manager("Мария", 70000, 15000);

        Employee[] employees = {
                salaried, hourly, manager
        };

        // Массивы интерфейсных типов
        Payable[] payables = {
                salaried, hourly, manager
        };

        Reportable[] reports = {
                salaried, hourly, manager
        };

        EmployeeService service =
                new EmployeeService(employees);

        // Работа с интерфейсами
        service.printPayments(payables);
        service.printReports(reports);

        // Calculation: анонимный класс
        Calculation anonymousCalculation = new Calculation() {
            @Override
            public double calculate(Employee employee) {
                return employee.salary();
            }
        };

        //Calculation: лямбда
        Calculation lambdaCalculation =
                Employee::salary;

        double sumAnonymous = service.sumCalculations(
                employees, anonymousCalculation);


        double sumLambda = service.sumCalculations(
                employees, lambdaCalculation);

        System.out.println("\n=== Calculation ===");
        System.out.printf("Анонимный класс: %.2f%n", sumAnonymous);
        System.out.printf("Лямбда: %.2f%n", sumLambda);

        System.out.println(
                "Суммы совпадают: "
                        + (Math.abs(sumAnonymous - sumLambda) < 0.000001)
        );

        //Selection: первый порог
        double threshold1 = 40000;

        Selection selection1 =
                employee -> employee.salary() > threshold1;

        System.out.println("\n=== Зарплата выше 40000 ===");
        service.selectEmployees(selection1);

        //Selection: второй порог
        double threshold2 = 65000;

        Selection selection2 =
                employee -> employee.salary() > threshold2;

        System.out.println("\n=== Зарплата выше 65000 ===");
        service.selectEmployees(selection2);

        //Ссылка на метод
        Runnable report = service::printReport;

        System.out.println("\n=== Запуск Runnable ===");
        report.run();
    }
}
