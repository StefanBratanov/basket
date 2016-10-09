import domain.BasketItem;

import java.util.ArrayList;
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
        return items;
    }

    public String cost() {
        Double cost = items.stream()
                .map(basketItem -> basketItem.price())
                .reduce((x, y) -> x + y)
                .orElse(0.00);

        return String.format("The total cost of the basket is %.2f", cost);
    }
}
