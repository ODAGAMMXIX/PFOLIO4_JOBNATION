package com.tecnocode.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tecnocode.model.Company;
import com.tecnocode.model.Experience;
import com.tecnocode.model.Vacancy;
import com.tecnocode.repository.ExperienceRepository;
import com.tecnocode.service.ExperienceService;
import com.tecnocode.validator.ExperienceValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService{
	private final ExperienceRepository repository;
	private final ExperienceValidator validator;
	
	@Override
	public Experience save(final Experience experience) {
		validator.validate(experience);
		return repository.saveAndFlush(experience);
		
	}
	
	@Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

	
	@Override
	public List<Experience> buscarTodasExperienciasComEssaEmpresa (final String company){
		return repository.findAllByCompany(company);
	}
	
	@Override
	public List<Experience> buscarTodasExperienciasComEssaCidade (final String city){
		return repository.findAllByCity(city);
	}
	
	@Override
	public List<Experience> buscarTodasExperienciasComEssaDataDeInicio (final LocalDate start){
		return repository.findAllByInit(start);
	}

	@Override
	public List<Experience> buscarTodasExperienciasComEssaDataDeFim(LocalDate end) {
		return repository.findAllByFinish(end);		
	}

	@Override
	public List<Experience> buscarTodasExperienciasComEsseTitulo(String title) {
		return repository.findAllByTitle(title);		
	}

	@Override
	public List<Experience> buscarTodasExperienciasComEsseAchiev(String achiev) {
		return repository.findAllByAchiev(achiev);		
	}

}
