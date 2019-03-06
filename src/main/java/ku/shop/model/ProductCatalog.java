package ku.shop.model;

import java.util.*;

public class ProductCatalog {

    private static ProductCatalog productCatalog = new ProductCatalog();
    private Map<String, Product> products;
    private int size = 0;

    private ProductCatalog() {
        products = new HashMap<>();
    }

    public static ProductCatalog getInstance() {
        return productCatalog;
    }

    public void addProduct(String name, double price) {
        products.put(name, new Product(++size, name, price));
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public List<Product> getAll() {
        Collection<Product> list = products.values();
        return new ArrayList<>(list);
    }

    public void addProduct(List<Product> all) {
        for (Product product : all) {
            products.put(product.getName(), product);
            size++;
        }
    }
}
