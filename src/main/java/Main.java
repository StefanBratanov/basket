import domain.BasketItem;
import domain.Item;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket();

        BasketItem banana = new BasketItem(Item.BANANA, BigDecimal.valueOf(0.20));
        BasketItem orange = new BasketItem(Item.ORANGE, BigDecimal.valueOf(0.10));
        BasketItem apple = new BasketItem(Item.APPLE, BigDecimal.valueOf(0.30));
        BasketItem lemon = new BasketItem(Item.LEMON, BigDecimal.valueOf(0.24));
        BasketItem peach = new BasketItem(Item.PEACH, BigDecimal.valueOf(0.31));

        basket.add(banana);
        basket.add(orange);
        basket.add(apple);
        basket.add(lemon);
        basket.add(peach);

        basket.addAll(Arrays.asList(banana, orange));

        System.out.println(basket.cost());

    }
}
