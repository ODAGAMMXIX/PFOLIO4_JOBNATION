package com.tecnocode.converter;

import com.tecnocode.model.Apply;
import com.tecnocode.payload.ApplyDTO;
import com.tecnocode.repository.CandidateRepository;
import com.tecnocode.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoToApplyConverter implements Converter<ApplyDTO, Apply>  {
    private final VacancyRepository vacancyRepository;
    private final CandidateRepository candidateRepository;

    @Override
    public Apply convert(ApplyDTO applyDTO){
        return Apply.builder()
                .vacancy(vacancyRepository.findById(applyDTO.getVacancyId()).orElse(null))
                .candidate(candidateRepository.findById(applyDTO.getCandidateId()).orElse(null))
                .build();
    }
}
