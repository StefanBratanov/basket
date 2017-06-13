package validators;

import java.math.BigDecimal;

public class PriceValidator {

    public static void validate(BigDecimal price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("No negative prices allowed");
        }
    }

    public static boolean isNegative(BigDecimal price) {
        return price.signum() == -1;
    }
}
