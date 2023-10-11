package seminars.first._Homework.Shop;

import seminars.first.Shop.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop extends seminars.first.Shop.Shop {
    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        List<Product> sortedProduct = new ArrayList<>(getProducts());
        sortedProduct.sort(Comparator.comparing(Product::getCost));
        return sortedProduct;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        if (getProducts().isEmpty()) {
            throw new RuntimeException("Корзина пуста");
        }
        Product maxPrice = getProducts().get(0);
        for (Product item : getProducts()) {
            if (item.getCost() > maxPrice.getCost()) {
                maxPrice = item;
            }
        }
        return maxPrice;
    }
}
