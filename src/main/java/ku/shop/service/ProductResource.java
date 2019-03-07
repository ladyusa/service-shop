package ku.shop.service;

import ku.shop.db.ProductDAO;
import ku.shop.model.Order;
import ku.shop.model.Product;
import ku.shop.model.ProductCatalog;
import ku.shop.model.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {

    @Autowired
    private ProductDAO productReposity;

    @Autowired
    private TaxCalculator taxCalculator;

    @GetMapping("/product/all")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> list = productReposity.getAll();
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getAccount(@PathVariable int id) {
        Product product = productReposity.getOne(id);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping("/product/create")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productReposity.insert(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PostMapping("/order/create/{pid}/{quantity}")
    public ResponseEntity<Double> createOrder(@PathVariable int pid, @PathVariable int quantity) {

        Order order = new Order();
        order.setTaxCalculator(taxCalculator);
        Product product = productReposity.getOne(pid);
        if (product == null) {
            return new ResponseEntity<Double>(HttpStatus.NOT_FOUND);
        }
        order.addItem(product, quantity);
        return new ResponseEntity<Double>(order.getTotal(), HttpStatus.OK);
    }
}
