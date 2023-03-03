package com.revature.models;

import org.springframework.stereotype.Component;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String streetName;

    private String cityName;

    private String stateName;

    private int zipCode;
    private String countryFlagUrl;
}
