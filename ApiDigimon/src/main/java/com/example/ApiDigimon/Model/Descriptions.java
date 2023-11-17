package com.example.ApiDigimon.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Descriptions {
	private String origin;
	private String language;
	@Column(length = 500)
	private String description;

}
