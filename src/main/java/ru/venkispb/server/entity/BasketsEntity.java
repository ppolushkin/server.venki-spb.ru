package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "baskets")
public class BasketsEntity {

    @Id
    @SequenceGenerator(name="baskets_id_seq",sequenceName="baskets_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="baskets_id_seq")
    public int id;

    public Timestamp createdAt;

    public Timestamp updatedAt;

    public Integer orderId;

}
