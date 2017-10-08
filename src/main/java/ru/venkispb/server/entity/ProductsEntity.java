package ru.venkispb.server.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "products")
public class ProductsEntity {

    @Id
    @SequenceGenerator(name="products_id_seq",sequenceName="products_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="products_id_seq")
    public int id;

    public String article;

    public String name;

    public String height;

    public String width;

    public String notes;

    public String smallImageName;

    public String bigImageName;

    public String extraImageName;

    public BigInteger price;

    public Timestamp createdAt;

    public Timestamp updatedAt;

    public String may9;

    public String smallImg;

    public String mediumImg;

    public String bigImg;

    public BigInteger retailPrice;

}
