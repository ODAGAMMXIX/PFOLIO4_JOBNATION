package com.tecnocode.validator;

import org.springframework.stereotype.Component;

import com.tecnocode.model.Experience;

import lombok.RequiredArgsConstructor;
import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class ExperienceValidator implements AbstractValidator<Experience>{
	
	@Override
	public void validate(Experience experience) {
		if(experience.getCompany().isEmpty()){
			throw new RuntimeException("Empresa não pode ser vazio.");
		}
		
		if(experience.getCity().isEmpty()) {
			throw new RuntimeException("Cidade não pode ser vazio.");
		}
		
 		if(isNull(experience.getStart())) {
 			throw new RuntimeException("A data de início não pode ser vazia.");
 		}
 		
 		if(isNull(experience.getEnd())) {
 			throw new RuntimeException("A data de fim não pode ser vazia.");
 		}
		
		if(experience.getTitle().isEmpty()) {
			throw new RuntimeException("A cidade não pode ser vazia");
		}
		
		if(experience.getAchiev().isEmpty()) {
			throw new RuntimeException("A descrição não pode ser vazia");
		}
	}
}
