package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "revisions")
public class RevisionsEntity {

    @Id
    @SequenceGenerator(name="revisions_id_seq",sequenceName="revisions_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="revisions_id_seq")
    public int id;

    public Integer pageId;

    public String content;

    public Timestamp createdAt;

    public Timestamp updatedAt;

}
