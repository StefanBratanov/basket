import domain.BasketItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static validators.PriceValidator.validate;

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
        return items;
    }

    public String cost() {
        BigDecimal cost = items.stream()
                .peek(basketItem -> validate(basketItem.price()))
                .map(basketItem -> basketItem.price())
                .reduce((x, y) -> x.add(y))
                .orElse(BigDecimal.ZERO).setScale(2);

        return String.format("The total cost of the basket is %s", cost.toString());
    }
}
