package com.example.ApiDigimon.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Fields {
	@Id
	private long id;
	@Column
	private String field;
	@Column
	private String image;
	

}
