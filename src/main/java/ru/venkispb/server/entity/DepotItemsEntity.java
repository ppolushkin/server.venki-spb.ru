package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "depot_items")
public class DepotItemsEntity {

    @Id
    @SequenceGenerator(name="depot_items_id_seq",sequenceName="depot_items_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="depot_items_id_seq")
    public int id;

    public Integer productId;

    public Integer depotId;

    public int count;

    public int holdCount;

    public Timestamp createdAt;

    public Timestamp updatedAt;

}
