package sit.int202.classicmodels_2567.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sit.int202.classicmodels_2567.models.Cart;
import sit.int202.classicmodels_2567.models.ClassicModelLineItem;
import sit.int202.classicmodels_2567.services.CartService;

@Controller
public class AppController {

//    @Autowired
//    private Cart<String, ClassicModelLineItem> cart;
    @Autowired
    private CartService cartService;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam String productCode, Model model){
        //session จะเก็บ obj ของ user แต่ละคนตาม browser เมื่อมี user คนใหม่ ก็จะส่ง cart ตัวใหม่ ดังนั้น cart ของแต่ละคนจะเป็นคนละอันกัน
        //เมื่อมี session ก็ไม่ต้อง add ใส่ model แล้ว
        Cart<String, ClassicModelLineItem> cart = (Cart) httpSession.getAttribute("cart");
        if(cart == null){
            cart = new Cart<>();
            httpSession.setAttribute("cart", cart);
        }
        cartService.addItem(productCode, cart);
        return "view_cart";
    }

    @GetMapping("/index")
    public String index(Model model, @CookieValue(value = "popup", defaultValue = "") String popup) {
        model.addAttribute("page", "index");
        model.addAttribute("popup", popup);
        return "index";
    }
    @GetMapping("/remove-cookie")
    public String removeCookie(Model model, HttpServletResponse response){
        response.addCookie(new Cookie("popup", ""));
        return "redirect:/index";
    }
}
