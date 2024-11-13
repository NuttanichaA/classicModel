package sit.int202.classicmodels_2567.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int202.classicmodels_2567.entities.Product;
import sit.int202.classicmodels_2567.models.Cart;
import sit.int202.classicmodels_2567.models.ClassicModelLineItem;
import sit.int202.classicmodels_2567.repositories.ProductRepository;

@Service
public class CartService {

    @Autowired
    private ProductRepository repository;

    public void addItem(String productCode, Cart<String, ClassicModelLineItem> cart){
        Product product = repository.findById(productCode).orElse(null);
        if(product != null){
            cart.addItem(productCode, new ClassicModelLineItem(product));
        }
    }
}
