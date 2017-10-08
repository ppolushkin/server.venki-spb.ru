package ru.venkispb.server.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "admins")
public class AdminsEntity {

    @Id
    @SequenceGenerator(name="admins_id_seq",sequenceName="admins_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admins_id_seq")
    public int id;

    public String email;

    public String passwordHash;

    public LocalDateTime createdAt;

    public LocalDateTime updatedAt;

    public boolean receiveEmails;

}
