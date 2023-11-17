package com.example.ApiDigimon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ApiDigimon.Dto.DigimonDto;
import com.example.ApiDigimon.Dto.TypeDto;
import com.example.ApiDigimon.Model.Digimon;
import com.example.ApiDigimon.Service.DigimonService;

@RestController
public class DigimonController {
	
	@Autowired
	private DigimonService digimonService;
	
	
	@PostMapping("/digimon")
	public ResponseEntity<DigimonDto> createDigimon ( @RequestBody Digimon digimon){
		return digimonService.saveDigimon(digimon);
	}
	
	@GetMapping("/digimon/{NameDigimon}")
	public ResponseEntity<DigimonDto> getDigimon ( @PathVariable String NameDigimon){
		return digimonService.getDigimonByName(NameDigimon);
	} 
	
	@GetMapping("/digimon/type/{typeIdentifier}")
	public ResponseEntity<TypeDto> getType ( @PathVariable String typeIdentifier){
		return digimonService.getType(typeIdentifier);
	} 

}
