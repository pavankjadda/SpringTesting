package com.springtesting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "address_type_id")
    private AddressType addressType;

    public Address() { }

    public Address(String streetName, String apartment, City city, State state, Country country, String zipCode, AddressType addressType)
    {
        this.streetName = streetName;
        this.apartment = apartment;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.addressType = addressType;
    }
}
