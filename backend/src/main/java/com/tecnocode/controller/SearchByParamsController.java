package com.tecnocode.controller;

import com.tecnocode.model.Candidate;
import com.tecnocode.payload.SearchDTO;
import com.tecnocode.service.SearchByParamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-by-params")
@RequiredArgsConstructor

public class SearchByParamsController {

    private final SearchByParamsService searchByParamsService;

    @PostMapping
    public List<Candidate> getCandidateByParams(@RequestBody final SearchDTO params) {
        return searchByParamsService.getCandidateByParams(
                params.getLat(),
                params.getLng(),
                params.getRange_distance(),
                params.getExperience_year(),
                params.getGenre(),
                params.getLanguage(),
                params.getSkill(),
                params.getQualification()
        );
    }
}
