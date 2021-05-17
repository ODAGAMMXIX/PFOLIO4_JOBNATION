package com.tecnocode.controller;


import java.time.LocalDate;
import java.util.List;

import com.tecnocode.validator.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tecnocode.converter.DtoToExperienceConverter;
import com.tecnocode.converter.ExperienceToDtoConverter;
import com.tecnocode.model.Experience;
import com.tecnocode.payload.ExperienceDTO;
import com.tecnocode.service.ExperienceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/experience")
@RequiredArgsConstructor
public class ExperienceController {
	private final ExperienceService service;
	private final DtoToExperienceConverter dtoToExperienceConverter;
	private final ExperienceToDtoConverter experienceToDtoConverter;
	
	@PostMapping
	public ResponseEntity saveNew(@RequestBody final ExperienceDTO experienceDTO) {
		try {
			Experience experience = service.save(dtoToExperienceConverter.convert(experienceDTO), Operation.INSERT);
			return ResponseEntity.status(HttpStatus.CREATED).body(experienceToDtoConverter.convert(experience));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{company}")
	public List<Experience> buscarTodasExperienciasComEssaEmpresa (@PathVariable("company") String company){
		return service.buscarTodasExperienciasComEssaEmpresa(company);
	}
	
	@GetMapping("/{city}")
	public List<Experience> buscarTodasExperienciasComEssaCidade  (@PathVariable("city") String city){
		return service.buscarTodasExperienciasComEssaCidade(city);
	}
	
	@GetMapping("/{start}")
	public List<Experience> buscarTodasExperienciasComEssaDataDeInicio (@PathVariable("start") LocalDate start){
		return service.buscarTodasExperienciasComEssaDataDeInicio(start);
	}
	
	@GetMapping("/{end}")
	public List<Experience> buscarTodasExperienciasComEssaDataDeFim (@PathVariable("end") LocalDate end){
		return service.buscarTodasExperienciasComEssaDataDeFim(end);
	}
	
	@GetMapping("/{title}")
	public List<Experience> buscarTodasExperienciasComEsseTitulo (@PathVariable("title") String title){
		return service.buscarTodasExperienciasComEsseTitulo(title);
	}
	
	@GetMapping("/{achiev}")
	public List<Experience> buscarTodasExperienciasComEsseAchiev (@PathVariable("achiev") String achiev){
		return service.buscarTodasExperienciasComEsseAchiev(achiev);
	}	
	
}
