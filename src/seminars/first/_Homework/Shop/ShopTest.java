package seminars.first._Homework.Shop;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class ShopTest {
    public static void main(String[] args) {
//        Подготовка тестового стека

        List<seminars.first.Shop.Product> products = new ArrayList<>();
        List<seminars.first.Shop.Product> productsEmpty = new ArrayList<>();
        products.add(new Product(15, "Pineapple"));
        products.add(new Product(5, "Strawberry"));
        products.add(new Product(4, "Cherry"));
        Shop shop = new Shop();
        shop.setProducts(products);

//        Начало тестов
        assertThat(shop.getProducts()).isNotNull();
        assertThat(shop.getProducts().size()).isEqualTo(3);
        assertThat(shop.getProducts()).contains(products.get(0), products.get(1), products.get(2));

        shop.setProducts(productsEmpty); // Проверяем, что при пустой корзине происходит вывод исключения
        assertThatThrownBy(shop::getMostExpensiveProduct).isInstanceOf(RuntimeException.class);
        shop.setProducts(products);
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(15);
        assertThat(shop.getMostExpensiveProduct().getTitle()).isEqualTo("Pineapple");

        assertThat(shop.sortProductsByPrice().get(0).getTitle()).isEqualTo("Cherry");
        assertThat(shop.sortProductsByPrice().get(0).getCost()).isEqualTo(4);
        assertThat(shop.sortProductsByPrice().get(products.size()-1).getTitle()).isEqualTo("Pineapple");
        assertThat(shop.sortProductsByPrice().get(products.size()-1).getCost()).isEqualTo(15);
    }
}
