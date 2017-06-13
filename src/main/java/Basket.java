import domain.BasketItem;
import validators.PriceValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {

    private List<BasketItem> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public void add(BasketItem item) {
        items.add(item);
    }

    public void addAll(List<BasketItem> listOfItems) {
        items.addAll(listOfItems);
    }

    public List<BasketItem> items() {
        return Collections.unmodifiableList(items);
    }

    public String cost() {
        BigDecimal cost = items.stream()
                .map(BasketItem::price)
                .peek(PriceValidator::validate)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO).setScale(2);

        return String.format("The total cost of the basket is %s", cost.toString());
    }
}
