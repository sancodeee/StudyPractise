package com.ws.testAPI;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4099764540257553734L;
    private Integer id;

    private String author;

    private Integer age;

    private String adress;

}
