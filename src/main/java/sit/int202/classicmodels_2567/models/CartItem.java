package sit.int202.classicmodels_2567.models;

public interface CartItem {
    public int getQuantity();
    public void setQuantity(int quantity);
    public double getUnitPrice();
    public double getTotal(); //unitprice*quantity
    public double getPercentDiscount();
}

