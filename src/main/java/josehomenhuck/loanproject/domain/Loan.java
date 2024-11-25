package josehomenhuck.loanproject.domain;

import josehomenhuck.loanproject.domain.exception.LoanNotAvailableException;

public class Loan {

    private Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean canGetPersonalOrGuaranteedLoan() {
        if (customer.isIncomeEqualOrLowerThan(3000)) {
            return true;
        }

        return customer.isIncomeBetween(3000, 5000)
                && customer.isAgeLowerThan(30)
                && customer.isLocation("SP");
    }

    public double getPersonalLoanInterestRate() {
        if (canGetPersonalOrGuaranteedLoan()) {
            return 4.0;
        }

        throw new LoanNotAvailableException("Customer does not meet the requirements for a personal loan");
    }

    public double getGuaranteedLoanInterestRate() {
        if (canGetPersonalOrGuaranteedLoan()) {
            return 3.0;
        }

        throw new LoanNotAvailableException("Customer does not meet the requirements for a guaranteed loan");
    }

    public boolean canGetConsignmentLoan() {
        return customer.isIncomeEqualsOrGreaterThan(5000);
    }

    public double getConsignmentLoanInterestRate() {
        if (canGetConsignmentLoan()) {
            return 2.0;
        }

        throw new LoanNotAvailableException("Customer does not meet the requirements for a consignment loan");
    }
}
