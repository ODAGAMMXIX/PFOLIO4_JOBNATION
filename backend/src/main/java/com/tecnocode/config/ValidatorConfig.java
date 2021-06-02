package com.tecnocode.config;

import com.tecnocode.validator.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ValidatorConfig {

    @Bean
    public Map<Operation, AddressValidator> addressValidators(
            final @Qualifier("addressInsertValidator") AddressValidator addressInsertValidator,
            final @Qualifier("addressUpdateValidator") AddressValidator addressUpdateValidator) {
        final Map<Operation, AddressValidator> map = new HashMap<>();
        map.put(Operation.INSERT, addressInsertValidator);
        map.put(Operation.UPDATE, addressUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, CandidateValidator> candidateValidators(
            final @Qualifier("candidateInsertValidator") CandidateValidator candidateInsertValidator,
            final @Qualifier("candidateUpdateValidator") CandidateValidator candidateUpdateValidator) {
        final Map<Operation, CandidateValidator> map = new HashMap<>();
        map.put(Operation.INSERT, candidateInsertValidator);
        map.put(Operation.UPDATE, candidateUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, BenefitValidator> benefitValidators(
            final @Qualifier("benefitInsertValidator") BenefitValidator benefitInsertValidator,
            final @Qualifier("benefitUpdateValidator") BenefitValidator benefitUpdateValidator) {
        final Map<Operation, BenefitValidator> map = new HashMap<>();
        map.put(Operation.INSERT, benefitInsertValidator);
        map.put(Operation.UPDATE, benefitUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, CompanyValidator> companyValidators(
            final @Qualifier("companyInsertValidator") CompanyValidator companyInsertValidator,
            final @Qualifier("companyUpdateValidator") CompanyValidator companyUpdateValidator) {
        final Map<Operation, CompanyValidator> map = new HashMap<>();
        map.put(Operation.INSERT, companyInsertValidator);
        map.put(Operation.UPDATE, companyUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, ExperienceValidator> experienceValidators(
            final @Qualifier("experienceInsertValidator") ExperienceValidator experienceInsertValidator,
            final @Qualifier("experienceUpdateValidator") ExperienceValidator experienceUpdateValidator) {
        final Map<Operation, ExperienceValidator> map = new HashMap<>();
        map.put(Operation.INSERT, experienceInsertValidator);
        map.put(Operation.UPDATE, experienceUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, LanguageValidator> languageValidators(
            final @Qualifier("languageInsertValidator") LanguageValidator languageInsertValidator,
            final @Qualifier("languageUpdateValidator") LanguageValidator languageUpdateValidator) {
        final Map<Operation, LanguageValidator> map = new HashMap<>();
        map.put(Operation.INSERT, languageInsertValidator);
        map.put(Operation.UPDATE, languageUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, QualificationValidator> qualificationValidators(
            final @Qualifier("qualificationInsertValidator") QualificationValidator qualificationInsertValidator,
            final @Qualifier("qualificationUpdateValidator") QualificationValidator qualificationUpdateValidator) {
        final Map<Operation, QualificationValidator> map = new HashMap<>();
        map.put(Operation.INSERT, qualificationInsertValidator);
        map.put(Operation.UPDATE, qualificationUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, SkillValidator> skillValidators(
            final @Qualifier("skillInsertValidator") SkillValidator skillInsertValidator,
            final @Qualifier("skillUpdateValidator") SkillValidator skillUpdateValidator) {
        final Map<Operation, SkillValidator> map = new HashMap<>();
        map.put(Operation.INSERT, skillInsertValidator);
        map.put(Operation.UPDATE, skillUpdateValidator);
        return Collections.unmodifiableMap(map);
    }

    @Bean
    public Map<Operation, VacancyValidator> vacancyValidators(
            final @Qualifier("vacancyInsertValidator") VacancyValidator vacancyInsertValidator,
            final @Qualifier("vacancyUpdateValidator") VacancyValidator vacancyUpdateValidator) {
        final Map<Operation, VacancyValidator> map = new HashMap<>();
        map.put(Operation.INSERT, vacancyInsertValidator);
        map.put(Operation.UPDATE, vacancyUpdateValidator);
        return Collections.unmodifiableMap(map);
    }
}
