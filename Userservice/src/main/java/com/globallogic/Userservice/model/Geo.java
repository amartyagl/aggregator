package com.globallogic.Userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int geoId;
    private String latitude;
    private String longitude;
}
