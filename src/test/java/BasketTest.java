import domain.BasketItem;
import domain.Item;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BasketTest {

    private Basket basket;

    @Before
    public void init() {
        basket = new Basket();
    }

    @Test
    public void addsItemsToBasket() {

        BasketItem banana = new BasketItem(Item.BANANA,0.20);
        BasketItem apple = new BasketItem(Item.APPLE,0.40);

        basket.add(banana);
        basket.add(apple);

        assertThat(basket.items().size(),is(2));
        assertThat(basket.items(),contains(banana,apple));

    }

    @Test
    public void calculatesCostOfBasket() {

        BasketItem orange = new BasketItem(Item.ORANGE,0.30);
        BasketItem lemon = new BasketItem(Item.LEMON,0.20);
        BasketItem peach = new BasketItem(Item.PEACH,0.35);

        basket.add(orange);
        basket.add(lemon);
        basket.add(peach);

        assertEquals("The total cost of the basket is 0.85",basket.cost());
    }

    @Test
    public void costIsZeroWhenBasketIsEmpty() {

        assertEquals("The total cost of the basket is 0.00",basket.cost());

    }




}