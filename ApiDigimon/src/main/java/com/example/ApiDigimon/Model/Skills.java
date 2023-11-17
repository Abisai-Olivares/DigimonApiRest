package com.example.ApiDigimon.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Skills {
	
	@Id
	private long id;
	@Column
	private String skill;
	@Column
	private String translation;
	@Column
	private String description;

}
