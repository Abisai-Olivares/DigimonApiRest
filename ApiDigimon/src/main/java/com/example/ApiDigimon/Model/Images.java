package com.example.ApiDigimon.Model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable

public class Images {
	
	private String href;
	private boolean transparent;

}
