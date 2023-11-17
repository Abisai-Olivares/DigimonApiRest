package com.example.ApiDigimon.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Attributes {
	@Id
	private long id;
	@Column
	private String attribute;
	

}
