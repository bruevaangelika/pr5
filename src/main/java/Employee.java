public abstract class Employee {
    protected String name;
    //конструктор
    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double salary();
}