package josehomenhuck.loanproject.controller.dto;

import josehomenhuck.loanproject.domain.LoanType;

public record LoanResponse(
        LoanType type,
        Double interestRate
) {
}
