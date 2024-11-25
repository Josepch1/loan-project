package josehomenhuck.loanproject.domain;

import josehomenhuck.loanproject.domain.exception.LoanNotAvailableException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class canGetPersonalOrGuaranteedLoan {
        static Stream<Arguments> provideTestCases() {
            return Stream.of(
                    // incomeBetween3000And5000, ageLowerThan30, locationIsSP, expectedResult
                    Arguments.of(true, true, true, true),    // All requirements met
                    Arguments.of(true, true, false, false), // Not living in SP
                    Arguments.of(true, false, true, false), // Not under 30 years
                    Arguments.of(false, true, true, false), // Salary outside the range
                    Arguments.of(true, false, false, false) // Not in SP and not under 30 years
            );
        }

        @Test
        void shouldReturnTrueWhenIncomeIsEqualOrLowerThan3000() {
            // True when income is equal or lower than 3000
            doReturn(true)
                    .when(customer).isIncomeEqualOrLowerThan(3000);

            assertTrue(loan.canGetPersonalOrGuaranteedLoan());
        }

        @Test
        void shouldReturnTrueWhenIncomeIsBetween3000And5000AndAgeIsLowerThan30AndLocationIsSP() {
            // False when income is equal or lower than 3000
            doReturn(false)
                    .when(customer).isIncomeEqualOrLowerThan(3000);

            // True when income is between 3000 and 5000
            doReturn(true)
                    .when(customer).isIncomeBetween(3000, 5000);

            // True when age is lower than 30
            doReturn(true)
                    .when(customer).isAgeLowerThan(30);

            // True when location is SP
            doReturn(true)
                    .when(customer).isLocation("SP");

            assertTrue(loan.canGetPersonalOrGuaranteedLoan());
        }

        @ParameterizedTest
        @MethodSource("provideTestCases")
        void shouldValidatePersonalLoanEligibility(
                boolean incomeBetween3000And5000,
                boolean ageLowerThan30,
                boolean locationIsSP,
                boolean expectedResult
        ) {
            // Mocking
            doReturn(incomeBetween3000And5000).when(customer).isIncomeBetween(3000, 5000);
            doReturn(ageLowerThan30).when(customer).isAgeLowerThan(30);
            doReturn(locationIsSP).when(customer).isLocation("SP");

            // Assertion
            assertEquals(expectedResult, loan.canGetPersonalOrGuaranteedLoan());
        }
    }

    @Nested
    class canGetConsignmentLoan {
        @Test
        void shouldReturnTrueWhenIncomeIsEqualOrGreaterThan5000() {
            // True when income is equal or greater than 5000
            doReturn(true)
                    .when(customer).isIncomeEqualsOrGreaterThan(5000);

            assertTrue(loan.canGetConsignmentLoan());
        }

        @Test
        void shouldReturnFalseWhenIncomeIsLowerThan5000() {
            // False when income is equal or greater than 5000
            doReturn(false)
                    .when(customer).isIncomeEqualsOrGreaterThan(5000);

            assertFalse(loan.canGetConsignmentLoan());
        }
    }

    @Nested
    class getPersonalLoanInterestRate {
        @Test
        void shouldReturn4WhenEligibleForPersonalLoan() {
            // True when income is equal or lower than 3000
            doReturn(true)
                    .when(customer).isIncomeEqualOrLowerThan(3000);

            assertEquals(4.0, loan.getPersonalLoanInterestRate());
        }

        @Test
        void shouldThrowLoanNotAvailableExceptionWhenNotEligibleForPersonalLoan() {
            // False when income is equal or lower than 3000
            doReturn(false)
                    .when(customer).isIncomeEqualOrLowerThan(3000);

            assertThrows(LoanNotAvailableException.class, () -> loan.getPersonalLoanInterestRate());
        }
    }

    @Nested
    class getGuaranteedLoanInterestRate {
        @Test
        void shouldReturn3WhenEligibleForGuaranteedLoan() {
            // True when income is equal or lower than 3000
            doReturn(true)
                    .when(customer).isIncomeEqualOrLowerThan(3000);

            assertEquals(3.0, loan.getGuaranteedLoanInterestRate());
        }

        @Test
        void shouldThrowLoanNotAvailableExceptionWhenNotEligibleForGuaranteedLoan() {
            // False when income is equal or lower than 3000
            doReturn(false)
                    .when(customer).isIncomeEqualOrLowerThan(3000);

            assertThrows(LoanNotAvailableException.class, () -> loan.getGuaranteedLoanInterestRate());
        }
    }

    @Nested
    class getConsignmentLoanInterestRate {
        @Test
        void shouldReturn2WhenEligibleForConsignmentLoan() {
            // True when income is equal or greater than 5000
            doReturn(true)
                    .when(customer).isIncomeEqualsOrGreaterThan(5000);

            assertEquals(2.0, loan.getConsignmentLoanInterestRate());
        }

        @Test
        void shouldThrowLoanNotAvailableExceptionWhenNotEligibleForConsignmentLoan() {
            // False when income is equal or greater than 5000
            doReturn(false)
                    .when(customer).isIncomeEqualsOrGreaterThan(5000);

            assertThrows(LoanNotAvailableException.class, () -> loan.getConsignmentLoanInterestRate());
        }
    }
}