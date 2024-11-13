package sit.int202.classicmodels_2567.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int202.classicmodels_2567.entities.Product;
import sit.int202.classicmodels_2567.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }
}
