package com.springtesting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "country")
@Data
public class Country
{
    @Id
    @Column(name = "id")
    @ColumnDefault(value = "0")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    @Length(max = 200,min = 2)
    private String name;

    @Column(name = "code")
    @Length(max = 3,min = 2)
    private String code;

    @Column(name = "iso_code")
    @Length(max = 3,min = 2)
    private String isoCode;

/*    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<State> states=new ArrayList<>();*/

    @ManyToOne
    @JoinColumn(name = "region_id")
    @JsonManagedReference
    private Region region;

    public Country() {};

    public Country(String name)
    {
        this.name=name;
    }

    public Country(@Length(max = 100, min = 2) String name, Region region)
    {
        this.name = name;
        this.region = region;
    }

    public Country(@Length(max = 200, min = 2) String name, @Length(max = 200, min = 2) String code, @Length(max = 2, min = 2) String isoCode, Region region)
    {
        this.name = name;
        this.code = code;
        this.isoCode = isoCode;
        this.region = region;
    }

    public Country(@Length(max = 200, min = 2) String name, @Length(max = 200, min = 2) String code, @Length(max = 2, min = 2) String isoCode)
    {
        this.name = name;
        this.code = code;
        this.isoCode = isoCode;
    }
}
