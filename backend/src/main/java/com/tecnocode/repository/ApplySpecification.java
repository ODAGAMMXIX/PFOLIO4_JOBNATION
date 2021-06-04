package com.tecnocode.repository;

import com.tecnocode.model.Apply;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.apache.logging.log4j.util.Strings.isBlank;

@RequiredArgsConstructor
public class ApplySpecification implements Specification<Apply> {
    private final Integer vacancyId;
    private final String gender;
    private final Set<String> language;
    private final Set<String> qualification;
    private final Set<String> skill;
    private List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(final Root<Apply> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
        predicates.add(builder.equal(root.join("vacancy").get("id"), vacancyId));
        genderFilter(root, builder);
        languageFilter(root, query, builder);
        qualificationFilter(root, builder);
        skillFilter(root, builder);
        Predicate[] predicatesArray = new Predicate[predicates.size()];
        predicatesArray = predicates.toArray(predicatesArray);
        return builder.and(predicatesArray);
    }

    private void languageFilter(Root<Apply> root, final CriteriaQuery<?> query, CriteriaBuilder builder) {
        if(language.isEmpty()) {
            return;
        }
        predicates.add(builder.in(root.join("candidate").join("languages").get("name")).value(language));
    }

    private void qualificationFilter(Root<Apply> root, CriteriaBuilder builder) {
        if(qualification.isEmpty()) {
            return;
        }
        predicates.add(builder.in(root.join("candidate").join("qualifications").get("name")).value(qualification));
    }

    private void skillFilter(Root<Apply> root, CriteriaBuilder builder) {
        if(skill.isEmpty()) {
            return;
        }
        predicates.add(builder.in(root.join("candidate").join("skills").get("name")).value(skill));
    }

    private void genderFilter(final Root<Apply> root, final CriteriaBuilder builder) {
        if(isBlank(gender)) {
            return;
        }
        predicates.add(builder.like(root.join("candidate").get("gender"), gender));
    }
}
