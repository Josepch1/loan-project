package josehomenhuck.loanproject.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import josehomenhuck.loanproject.domain.Customer;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerLoanRequest(
        @NotNull(message = "Age must be informed")
        @Min(18)
        Integer age,

        @CPF(message = "Invalid CPF")
        String cpf,

        @NotBlank(message = "Name must be informed")
        String name,

        @NotNull(message = "Income must be informed")
        @Min(1000)
        Double income,

        @NotBlank(message = "Location must be informed")
        String location
) {


    public Customer toCustomer() {
        return new Customer(age, cpf, name, income, location);
    }
}
