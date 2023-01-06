package com.redis.springdataredis.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student implements Serializable{
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 6251257603030103064L;
	private Long id;
    // private String id;
    private String name;
    private String gender;
    private String email;
    private String address;

    
}
