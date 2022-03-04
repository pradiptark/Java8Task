package main.model;

public class Invoice {
    Integer id;
    Double amount;
    String customer;
    String title;

    public Invoice(Integer id, String customer, double amount, String title){
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.title = title;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getCustomer() { return customer; }

    public void setCustomer(String customer) { this.customer = customer; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }



    @Override
    public String toString() {
        return String.format("%1$-13d%2$-20s%3$-20.2f%4$-20s", id, customer, amount, title);
    }
}
