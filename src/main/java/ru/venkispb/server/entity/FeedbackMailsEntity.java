package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "feedback_mails")
public class FeedbackMailsEntity {

    @Id
    @SequenceGenerator(name="feedback_mails_id_seq",sequenceName="feedback_mails_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="feedback_mails_id_seq")
    public int id;

    public String email;

    public String name;

    public String phone;

    public String message;

    public Timestamp createdAt;

    public Timestamp updatedAt;

    public String applicationName;

}
