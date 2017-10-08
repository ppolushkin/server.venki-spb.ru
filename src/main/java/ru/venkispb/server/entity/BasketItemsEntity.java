package ru.venkispb.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "basket_items")
public class BasketItemsEntity {

    @Id
    @SequenceGenerator(name="basket_items_id_seq",sequenceName="basket_items_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="basket_items_id_seq")
    public int id;

    public Integer basketId;

    public Integer productId;

    public Integer count;

}
