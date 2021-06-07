package com.tecnocode.service.impl;

import com.tecnocode.converter.DtoToDistanceConverter;
import com.tecnocode.model.Apply;
import com.tecnocode.model.Candidate;
import com.tecnocode.model.Distance;
import com.tecnocode.model.Vacancy;
import com.tecnocode.repository.ApplyRepository;
import com.tecnocode.repository.CandidateRepository;
import com.tecnocode.repository.VacancyRepository;
import com.tecnocode.service.ApplyService;
import com.tecnocode.service.DistanceService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;

import org.json.JSONException;
import org.json.JSONObject;
//import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {
    private final ApplyRepository repository;
    private final DistanceService distanceService;
    private final DtoToDistanceConverter dtoToDistanceConverter;


    @Override
    public Apply save(final Apply apply, Operation operation) {
        return repository.saveAndFlush(apply);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Apply saveNewApply(Apply apply, Operation operation) throws RuntimeException, IOException,
            JSONException {
        Vacancy vacancy = apply.getVacancy();
        Candidate candidate = apply.getCandidate();

        Distance distance = new Distance();
        distance.setDestination(vacancy.getAddress().getCep());
        distance.setOrigin(candidate.getAddress().getCep());

        String response = distanceService.getDistance(distance);

        JSONObject json_str = new JSONObject(response);
        Integer transport_number = json_str.getInt("transport_number");
        JSONObject distance_json = (JSONObject) json_str.get("distance");
        String distance_text = distance_json.getString("text");
        System.out.println("VTN" + transport_number);
        System.out.println("DISTANCE" + distance_text);

        apply.setVtn(transport_number);

        return this.save(apply, operation);
    }
}