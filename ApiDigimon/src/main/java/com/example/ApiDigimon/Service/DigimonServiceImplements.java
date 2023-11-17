package com.example.ApiDigimon.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.ApiDigimon.Dto.DigimonDto;
import com.example.ApiDigimon.Dto.TypeDto;
import com.example.ApiDigimon.Model.Digimon;
import com.example.ApiDigimon.Model.Type;
import com.example.ApiDigimon.Model.Types;
import com.example.ApiDigimon.Repository.DigimonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DigimonServiceImplements implements DigimonService {
	
	@Value("${spring.external.service.base-url}")
	private String basePath;
	
	@Autowired
	private DigimonRepository digimonRepository;
	
	private final RestTemplate restTemplate;
	
	
	@Override
	public ResponseEntity<DigimonDto> getDigimonByName(String digimonIdentifier) {
		DigimonDto digimonDto = new DigimonDto();
	try {
		digimonDto.setDigimon(restTemplate.getForObject(basePath+"/digimon/"+digimonIdentifier, Digimon.class));
		digimonDto.setMessage("Digimon localizado");
		
		return ResponseEntity.status(HttpStatus.OK).body(digimonDto); 
	}catch(HttpClientErrorException ex){
		digimonDto.setDigimon(new Digimon());
		digimonDto.setMessage("Digimon extraviado");
		return ResponseEntity.status(ex.getStatusCode()).body(digimonDto);

	}
	
	}

	
	@Override
	public ResponseEntity<DigimonDto> saveDigimon(Digimon digimon) {
	    DigimonDto digimonDto = new DigimonDto();
	    String nameDigimon = digimon.getName();

	    try {
	        ResponseEntity<DigimonDto> currentDigimonResponse = getDigimonByName(nameDigimon);

	        if (currentDigimonResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
	            digimonDto.setMessage("Digimon extraviado");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(digimonDto);
	        }

	        digimonDto.setMessage("Digimon localizado, se guardo exitosamente");
	        Digimon currentDigimon = digimonRepository.save(digimon);
	        digimonDto.setDigimon(currentDigimon);
	        return ResponseEntity.status(HttpStatus.OK).body(digimonDto);
	    } catch (HttpClientErrorException ex) {
	        digimonDto.setMessage("Ocurrió un error con el universo digimon");
	        return ResponseEntity.status(ex.getStatusCode()).body(digimonDto);
	    }
	}
	
	@Override public ResponseEntity<TypeDto> getType(String typeIdentifier){
		TypeDto typeDto = new TypeDto();
		try {
			 typeDto.setTypes(restTemplate.getForObject(basePath+"/type/"+typeIdentifier, Type.class));
			 typeDto.setMessage("Typo localizado");
			return ResponseEntity.status(HttpStatus.OK).body(typeDto); 

		}catch( HttpClientErrorException ex) {
			typeDto.setTypes(new Type());
			typeDto.setMessage("Digimon extraviado");
			return ResponseEntity.status(ex.getStatusCode()).body(typeDto);
		}
	
	}


}
