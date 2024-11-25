package josehomenhuck.loanproject.domain;

import josehomenhuck.loanproject.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {
        Customer customer = CustomerFactory.build(25, 5000.0, "SP");

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            assertTrue(customer.isIncomeEqualOrLowerThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThan() {
            assertTrue(customer.isIncomeEqualOrLowerThan(8000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreaterThanValue() {
            assertFalse(customer.isIncomeEqualOrLowerThan(3000.0));
        }
    }

    @Nested
    class isIncomeEqualsOrGreaterThan {
        Customer customer = CustomerFactory.build(25, 5000.0, "SP");

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            assertTrue(customer.isIncomeEqualsOrGreaterThan(5000.0));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThan() {
            assertTrue(customer.isIncomeEqualsOrGreaterThan(3000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanValue() {
            assertFalse(customer.isIncomeEqualsOrGreaterThan(8000.0));
        }
    }

    @Nested
    class isIncomeBetween {
        Customer customer = CustomerFactory.build(25, 5000.0, "SP");

        @Test
        void shouldBeTrueWhenIncomeIsBetween() {
            assertTrue(customer.isIncomeBetween(3000.0, 8000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanMin() {
            assertFalse(customer.isIncomeBetween(8000.0, 10000.0));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreaterThanMax() {
            assertFalse(customer.isIncomeBetween(3000.0, 4000.0));
        }
    }

    @Nested
    class isAgeLowerThan {
        Customer customer = CustomerFactory.build(25, 5000.0, "SP");

        @Test
        void shouldBeTrueWhenAgeIsLower() {
            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqual() {
            assertFalse(customer.isAgeLowerThan(20));
        }

        @Test
        void shouldBeFalseWhenAgeIsGreaterThan() {
            assertFalse(customer.isAgeLowerThan(10));
        }
    }

    @Nested
    class isLocation {
        Customer customer = CustomerFactory.build(25, 5000.0, "SP");

        @Test
        void shouldBeTrueWhenLocationIsEqual() {
            assertTrue(customer.isLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsDifferent() {
            assertFalse(customer.isLocation("RJ"));
        }
    }
}