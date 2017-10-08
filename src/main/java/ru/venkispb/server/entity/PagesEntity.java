package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "pages")
public class PagesEntity {

    @Id
    @SequenceGenerator(name="pages_id_seq",sequenceName="pages_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pages_id_seq")
    public int id;

    public String reference;

    public String title;

    public Timestamp createdAt;

    public Timestamp updatedAt;

    public String applicationName;

}
