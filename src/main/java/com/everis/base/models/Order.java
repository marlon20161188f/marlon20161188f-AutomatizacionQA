package com.everis.base.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","petId","quantity","shipData","status","complete"})
public class Order {
    private int id;

    private int petId;
    private int quantity;
    private String shipData;
    private String status;
    private boolean complete;

    public Order (){

    }

    public Order(int id, int petId, int quantity) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipData() {
        return shipData;
    }

    public void setShipData(String shipData) {
        this.shipData = shipData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
