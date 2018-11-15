package com.springtesting.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "region")
@Data
public class Region
{
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "name")
    @Length(max = 20,min = 2)
    private String name;

    public Region() {}

    public Region(@Length(max = 20, min = 2) String name)
    {
        this.name = name;
    }
}
