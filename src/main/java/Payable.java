public interface Payable {
    double getPayment();

    default void printPayment() {
        System.out.printf(
                "Выплата сотруднику: %.2f%n",
                getPayment()
        );
    }
}