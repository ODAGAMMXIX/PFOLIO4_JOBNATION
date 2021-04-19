package com.tecnocode.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.tecnocode.model.Experience;
import com.tecnocode.payload.ExperienceDTO;

@Component
public class DtoToExperienceConverter implements Converter<ExperienceDTO, Experience>{
	@Override
	public Experience convert(ExperienceDTO experienceDTO) {
		return Experience.builder()
				.company(experienceDTO.getCompany())
				.city(experienceDTO.getCity())
				.start(experienceDTO.getStart())
				.end(experienceDTO.getEnd())
				.title(experienceDTO.getTitle())
				.achiev(experienceDTO.getAchiev())
				.build();	
	}
}
