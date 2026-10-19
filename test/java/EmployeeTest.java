
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void testSalariedSalary() {
        Salaried employee = new Salaried("Анна", 60000);

        assertEquals(60000.0, employee.salary(), 0.001);
    }

    @Test
    void testHourlySalary() {
        Hourly employee = new Hourly("Иван", 500, 80);

        assertEquals(40000.0, employee.salary(), 0.001);
    }

    @Test
    void testManagerSalary() {
        Manager employee = new Manager("Мария", 70000, 15000);

        assertEquals(85000.0, employee.salary(), 0.001);
    }

    @Test
    void testEmployeeName() {
        Salaried employee = new Salaried("Анна", 60000);

        assertEquals("Анна", employee.getName());
    }

    @Test
    void testSelection() {
        Salaried salaried = new Salaried("Анна", 60000);
        Hourly hourly = new Hourly("Иван", 500, 80);
        Manager manager = new Manager("Мария", 70000, 15000);

        Selection selection =
                employee -> employee.salary() > 65000;

        assertFalse(selection.test(salaried));
        assertFalse(selection.test(hourly));
        assertTrue(selection.test(manager));
    }
}
