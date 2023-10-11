package seminars.first._Homework.Shop;

public class Product extends seminars.first.Shop.Product {
    public Product(int cost, String title) {
        this.setCost(cost);
        this.setTitle(title);
    }

    @Override
    public String toString() {
        return getTitle() + " = " + getCost();
    }


}
