package validators;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;
import static validators.PriceValidator.isNegative;
import static validators.PriceValidator.validate;

public class PriceValidatorTest {

    @Rule
    public ExpectedException exception = none();

    @Test
    public void validatesPrice() {
        BigDecimal price = BigDecimal.valueOf(1.31);

        validate(price);
    }

    @Test
    public void throwsExceptionIfPriceIsNegative() {

        BigDecimal negativePrice = BigDecimal.valueOf(-1.21);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No negative prices allowed");

        validate(negativePrice);
    }

    @Test
    public void checksIfBigDecimalIsNegative() {
        BigDecimal positiveNumber = BigDecimal.valueOf(1.32);
        BigDecimal negativeNumber = BigDecimal.valueOf(-2.31);
        BigDecimal zero = BigDecimal.ZERO;

        assertThat(isNegative(positiveNumber), is(false));
        assertThat(isNegative(negativeNumber), is(true));
        assertThat(isNegative(zero), is(false));
    }

}