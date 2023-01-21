package com.globallogic.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String name;
    private String email;
    private String userName;
    private Address address;
    private String phone;
    private Geo geo;
    private Company company;
    private List<GloQuoraPost> gloQuoraPosts;
}
