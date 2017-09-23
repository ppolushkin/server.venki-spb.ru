package ru.venkispb.server.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @SequenceGenerator(name="admins_id_seq",sequenceName="admins_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admins_id_seq")
    public Integer id;

    public String email;

    public String password_hash;

    public LocalDateTime created_at;

    public LocalDateTime updated_at;

    public Boolean receive_emails;

}
