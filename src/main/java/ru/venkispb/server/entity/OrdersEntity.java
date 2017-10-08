package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @SequenceGenerator(name="orders_id_seq",sequenceName="orders_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="orders_id_seq")
    public int id;

    public Integer basketId;

    public String fullName;

    public String phone;

    public String email;

    public String address;

    public Boolean delivery;

    public String notes;

    public Timestamp createdAt;

    public Timestamp updatedAt;

    public String state;

}
