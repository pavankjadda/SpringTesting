package com.springtesting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address_type")
public class AddressType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "type",nullable = false)
    private String type;

    public AddressType()
    {

    }

    public AddressType(String type)
    {
        this.type=type;
    }
}
