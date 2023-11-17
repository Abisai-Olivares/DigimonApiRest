package com.example.ApiDigimon.Service;

import org.springframework.http.ResponseEntity;

import com.example.ApiDigimon.Dto.DigimonDto;
import com.example.ApiDigimon.Dto.TypeDto;
import com.example.ApiDigimon.Model.Digimon;

public interface DigimonService {
	ResponseEntity<DigimonDto> getDigimonByName(String nameDigimon);
	ResponseEntity<DigimonDto> saveDigimon( Digimon digimon);
	ResponseEntity<TypeDto> getType(String typeIdentifier);
}
