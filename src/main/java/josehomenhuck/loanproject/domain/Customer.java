package josehomenhuck.loanproject.domain;

public class Customer {

    private Integer age;

    private String cpf;

    private String name;

    private Double income;

    private String location;

    public Customer(Integer age, String cpf, String name, Double income, String location) {
        this.age = age;
        this.cpf = cpf;
        this.name = name;
        this.income = income;
        this.location = location;
    }

    public boolean isIncomeEqualsOrGreaterThan(double i) {
        return income >= i;
    }

    public boolean isIncomeEqualOrLowerThan(double i) {
        return income <= i;
    }

    public boolean isIncomeBetween(double min, double max) {
        return income >= min && income <= max;
    }

    public boolean isAgeLowerThan(int i) {
        return age < i;
    }

    public boolean isLocation(String location) {
        return this.location.equalsIgnoreCase(location);
    }
}
