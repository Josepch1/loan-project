package josehomenhuck.loanproject.controller;

import jakarta.validation.Valid;
import josehomenhuck.loanproject.controller.dto.CustomerLoanRequest;
import josehomenhuck.loanproject.controller.dto.CustomerLoanResponse;
import josehomenhuck.loanproject.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @PostMapping("/customer-loans")
    public ResponseEntity<CustomerLoanResponse> getCustomerLoans(@RequestBody @Valid CustomerLoanRequest request) {
        var response = loanService.loanAvailability(request);

        return ResponseEntity.ok(response);
    }
}
