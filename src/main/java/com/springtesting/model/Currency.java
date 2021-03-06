package com.springtesting.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "currency")
@Data
public class Currency
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "iso_code")
    private String isoCode;


    public Currency()
    {
    }

    public Currency(String name, String symbol, String isoCode)
    {
        this.name = name;
        this.symbol = symbol;
        this.isoCode = isoCode;
    }
}
