package sit.int202.classicmodels_2567.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sit.int202.classicmodels_2567.entities.Customer;
import sit.int202.classicmodels_2567.entities.Office;
import sit.int202.classicmodels_2567.repositories.CustomerRepository;
import sit.int202.classicmodels_2567.repositories.OfficeRepository;

import java.util.List;

@Controller()
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping("")
    public String students(Model model) {
        model.addAttribute("customers", repository.findAll());
        model.addAttribute("page", "customers");
        return "customer_list";
    }

    @PostMapping("")
    public String createOffice(Office office, ModelMap modelMap) {
        modelMap.addAttribute("office", office);
        return "office_detail";
    }
    @GetMapping("/form")
    public  String getOfficeForm(Office office) {
        return "office_form";
    }
}
