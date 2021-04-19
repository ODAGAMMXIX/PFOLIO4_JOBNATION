package com.tecnocode.converter;

import com.tecnocode.model.Experience;
import com.tecnocode.payload.ExperienceDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ExperienceToDtoConverter implements Converter<Experience, ExperienceDTO> {
	@Override
	public ExperienceDTO convert(Experience experience){
		return ExperienceDTO.builder()
				.company(experience.getCompany())
				.city(experience.getCity())
				.start(experience.getStart())
				.end(experience.getEnd())
				.title(experience.getTitle())
				.achiev(experience.getAchiev())
				.build();		
	}
}
