package domain;

public class BasketItem {

    private Item item;
    private Double price;

    public BasketItem(Item item, Double price) {
        this.item = item;
        this.price = price;
    }

    public Double price() {
        return price;
    }
}
