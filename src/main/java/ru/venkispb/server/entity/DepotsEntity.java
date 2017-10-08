package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "depots")
public class DepotsEntity {

    @Id
    @SequenceGenerator(name="depots_id_seq",sequenceName="depots_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="depots_id_seq")
    public int id;

    public String name;

    public Timestamp createdAt;

    public Timestamp updatedAt;

}
