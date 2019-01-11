package com.spring.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction_history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Items items;

    @ManyToOne
    @JoinColumn(name = "cashier_id")
    private Users users;

    @Column(name = "amount")
    private int amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time")
    private Date timestamp = new Date();

    public History() {
    }

    public History(Items items, Users users, int amount, Date timestamp) {
        this.items = items;
        this.users = users;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
