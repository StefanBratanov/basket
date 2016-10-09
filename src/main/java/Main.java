import domain.BasketItem;
import domain.Item;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket();

        BasketItem banana = new BasketItem(Item.BANANA,0.20);
        BasketItem orange = new BasketItem(Item.ORANGE,0.10);
        BasketItem apple = new BasketItem(Item.APPLE,0.30);
        BasketItem lemon = new BasketItem(Item.LEMON,0.24);
        BasketItem peach = new BasketItem(Item.PEACH,0.31);

        basket.add(banana);
        basket.add(orange);
        basket.add(apple);
        basket.add(lemon);
        basket.add(peach);

        basket.addAll(Arrays.asList(banana, orange));

        System.out.println(basket.cost());

    }
}
