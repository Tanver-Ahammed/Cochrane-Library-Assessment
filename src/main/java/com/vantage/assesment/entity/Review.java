package com.vantage.assesment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Md. Tanver Ahammed
 * */

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String date;

    private String authors;

    private String details;

    @ManyToOne
    @JoinColumn(name = "topic_id_fk", referencedColumnName = "id")
    private Topic topic;

}
