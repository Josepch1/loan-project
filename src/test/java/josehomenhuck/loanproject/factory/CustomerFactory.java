package josehomenhuck.loanproject.factory;

import josehomenhuck.loanproject.domain.Customer;

public class CustomerFactory {
    public static Customer build(Integer age, Double income, String location) {
        return new Customer(age,
                "123.456.789-00",
                "John Doe",
                income,
                location);
    }
}
