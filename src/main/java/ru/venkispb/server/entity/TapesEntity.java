package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tapes")
public class TapesEntity {

    @Id
    @SequenceGenerator(name="tapes_id_seq",sequenceName="tapes_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="tapes_id_seq")
    public int id;

    public String text;

    public String color;

    public Integer count;

    public Integer basketId;

    public Integer productId;

    public Timestamp createdAt;

    public Timestamp updatedAt;

}
