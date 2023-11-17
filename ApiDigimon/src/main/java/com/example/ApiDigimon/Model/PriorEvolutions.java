package com.example.ApiDigimon.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "priorEvolutions")
public class PriorEvolutions {

	@Id
	private long id;
	@Column
	private String digimon;
	@Column(name = "condition_text") 
	private String condition;
	@Column
	private String image;
	@Column
	private String url;
	
}
