package josehomenhuck.loanproject.service;

import josehomenhuck.loanproject.controller.dto.CustomerLoanRequest;
import josehomenhuck.loanproject.controller.dto.CustomerLoanResponse;
import josehomenhuck.loanproject.controller.dto.LoanResponse;
import josehomenhuck.loanproject.domain.Loan;
import josehomenhuck.loanproject.domain.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse loanAvailability(CustomerLoanRequest request) {
        var customer = request.toCustomer();
        var loan = new Loan(customer);

        List<LoanResponse> loans = new ArrayList<>();

        if (loan.canGetPersonalOrGuaranteedLoan()) {
            // Personal
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));

            // Guaranteed
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        if (loan.canGetConsignmentLoan()) {
            // Consignment
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
        }

        return new CustomerLoanResponse(request.name(), loans);
    }
}
