package com.tecnocode.service.impl;

import com.tecnocode.model.Candidate;
import com.tecnocode.repository.SearchByParamsRepository;
import com.tecnocode.service.SearchByParamsService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchByParamsServiceImpl implements SearchByParamsService {

    private final SearchByParamsRepository searchByParamsRepository;

    @Override
    public List<Object> getCandidateByParams(Float lat, Float lgn, Integer range_distance, Integer experience_year, String genre, String[] language, String[] skill, String qualification) {
//        StringBuilder query = new StringBuilder();
//
//        if(experience_year != null ||
//                genre != null ||
//                language != null ||
//                qualification != null ||
//                (skill != null && skill.length > 0) ||
//                range_distance != null ||
//                experience_year != null
//        ){

//            query.append("where ");

//            if(experience_year != null){
//                query.append("candidate_profile.cdt_id = candidate_experience.cdt_id ");
//                query.append("and experience.exp_id = candidate_experience.exp_id ");
//            }
//
//            if(genre != null){
//                query.append("and candidate_profile.cdt_gender = '" + genre + "' ");
//            }
//
//            if(language != null){
//                query.append("and candidate_language.cdt_id = candidate_profile.cdt_id ");
//                query.append("and candidate_language.lan_id = language.lan_id ");
//                query.append("and language.lan_name = '" + language + "' ");
//            }
//
//            if(qualification != null){
//                query.append("and candidate_qualification.qua_id = qualification.qua_id ");
//                query.append("and candidate_qualification.cdt_id = candidate_profile.cdt_id ");
//                query.append("and qualification.qua_level_degr = '" + qualification + "' ");
//            }
//
//            if(skill != null && skill.length > 0){
//                query.append("and candidate_skill.ski_id = skill.ski_id ");
//                query.append("and candidate_skill.cdt_id = candidate_profile.cdt_id ");
//                query.append("and skill.ski_name = '" + skill[0] + "' ");
//            }
//
//            if(range_distance != null){
//                query.append("and candidate_profile.address_adr_id = endereco.adr_id ");
//            }

//            if(experience_year != null){
//                query.append("and (to_date(exp_end,'dd/mm/yyyy') - to_date(exp_start,'dd/mm/yyyy')) >= (365 * " + experience_year + ")");
//            }
//
//        }

        List <Object> candidates = searchByParamsRepository.searchAllCandidates(
                Arrays.asList("SUPERIOR"),
                Arrays.asList("HTML"),
                Arrays.asList("INGLES"),
                "MASCULINO"
        );


//        query.append(";");
            //System.out.print(query.toString());

        //List<Object> candidates = searchByParamsRepository.searchByParams(" 1 = 1 ;", lat, lgn, range_distance);

        // return candidates;
        // System.out.print(searchByParamsRepository.searchByParams(query.toString(), lat, lgn, range_distance).toString());

        return null;
    }

    @Override
    public Candidate save(Candidate candidate, Operation operation) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
