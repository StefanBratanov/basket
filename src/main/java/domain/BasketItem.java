package domain;

import java.math.BigDecimal;

public class BasketItem {

    private Item item;
    private BigDecimal price;

    public BasketItem(Item item, BigDecimal price) {
        this.item = item;
        this.price = price;
    }

    public BigDecimal price() {
        return price;
    }
}
