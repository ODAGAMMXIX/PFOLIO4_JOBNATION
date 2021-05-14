package com.tecnocode.service;

import com.tecnocode.model.Candidate;

import java.util.List;

public interface SearchByParamsService extends GenericService<Candidate> {

    List<Candidate> getCandidateByParams(final Float lat,
                                         final Float lgn,
                                         final Integer range_distance,
                                         final Integer experience_year,
                                         final String genre,
                                         final String[] language,
                                         final String[] skill,
                                         final String qualification
    );

}
