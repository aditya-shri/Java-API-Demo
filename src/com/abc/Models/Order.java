package com.abc.Models;

import com.abc.Services.ItemDAO;

public class Order {

    private int id;
    private int userid;
    private Item item;
    private String description;
    private int quantity;

    public Order(int userid, int quantity, Item item) {
        this.id = 0;
        this.userid = userid;
        this.description = "";
        this.quantity = quantity;
        this.item = item;
    }

    public Order(int userid, String description, int quantity, Item item) {
        this.id = 0;
        this.userid = userid;
        this.description = description;
        this.quantity = quantity;
        this.item = item;
    }

    public Order(int userid, String description, int quantity, String item) throws Exception {
        this.id = 0;
        this.userid = userid;
        this.description = description;
        this.quantity = quantity;
        Item it = ItemDAO.getItem(item);
        if (it == null) {
            throw new Exception("Item not found!");
        } else {
            this.item = it;
        }
    }

    public Order(int id, int userid, String description, int quantity, String item) throws Exception {
        this.id = id;
        this.userid = userid;
        this.description = description;
        this.quantity = quantity;
        Item it = ItemDAO.getItem(item);
        if (it == null) {
            throw new Exception("Item not found!");
        } else {
            this.item = it;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "user=" + userid +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", item=" + item +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (getId() != order.getId()) return false;
        if (getQuantity() != order.getQuantity()) return false;
        if (getUserid() != order.getUserid()) return false;
        return getItem().equals(order.getItem());
    }

    @Override
    public int hashCode() {
        int result = getUserid();
        result = 31 * result + getQuantity();
        result = 31 * result + getItem().hashCode();
        return result;
    }
}
