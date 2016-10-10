import domain.BasketItem;
import domain.Item;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

public class BasketTest {

    private Basket basket;

    @Rule
    public ExpectedException exception = none();

    @Before
    public void init() {
        basket = new Basket();
    }

    @Test
    public void addsItemsToBasket() {

        BasketItem banana = new BasketItem(Item.BANANA, BigDecimal.valueOf(0.20));
        BasketItem apple = new BasketItem(Item.APPLE, BigDecimal.valueOf(0.40));

        basket.add(banana);
        basket.add(apple);

        assertThat(basket.items().size(),is(2));
        assertThat(basket.items(),contains(banana,apple));

    }

    @Test
    public void addsListOfItemsToBasket() {

        BasketItem orange = new BasketItem(Item.ORANGE, BigDecimal.valueOf(0.19));
        BasketItem peach = new BasketItem(Item.PEACH, BigDecimal.valueOf(0.32));
        BasketItem lemon = new BasketItem(Item.LEMON, BigDecimal.valueOf(0.10));

        basket.add(orange);
        basket.addAll(Arrays.asList(peach, lemon));

        assertThat(basket.items().size(), is(3));
        assertThat(basket.items(), hasItems(peach, lemon));

    }

    @Test
    public void calculatesCostOfBasket() {

        BasketItem orange = new BasketItem(Item.ORANGE, BigDecimal.valueOf(0.30));
        BasketItem lemon = new BasketItem(Item.LEMON, BigDecimal.valueOf(0.20));
        BasketItem peach = new BasketItem(Item.PEACH, BigDecimal.valueOf(0.35));

        basket.add(orange);
        basket.add(lemon);
        basket.add(peach);

        assertEquals("The total cost of the basket is 0.85",basket.cost());
    }

    @Test
    public void exceptionIsThrownWhenThereIsNegativePriceWhileCalculatingCost() {

        BasketItem banana = new BasketItem(Item.BANANA, BigDecimal.valueOf(0.20));
        BasketItem apple = new BasketItem(Item.APPLE, BigDecimal.valueOf(-0.40));

        basket.add(banana);
        basket.add(apple);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("No negative prices allowed");

        basket.cost();
    }

    @Test
    public void costIsZeroWhenBasketIsEmpty() {

        assertEquals("The total cost of the basket is 0.00",basket.cost());

    }
}