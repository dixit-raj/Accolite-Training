package com.example.Order.models;

public class Order {
    private Long id;
    private OrderState state;
    private String description;

    public Order(){}

    public Order(Long id, String description){
        this.id = id;
        this.state = OrderState.NEW;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
