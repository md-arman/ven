package com.dev.ven.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;

//used lombok jars to reduce boilerplate code

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class FarmDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //each farm name should be unique
    private String farmId;

    //in acres
    private Integer plantingArea;
    //type of crop, e.g. potato, corn, etc.
    private String cropType;

    //amount of expected prod.
    // in tons
    private Integer expectedAmount;

    //amount of harvested prod. in tons
    private Integer harvestedAmount;

}
