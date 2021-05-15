package com.tecnocode.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tecnocode.model.Qualification;
import com.tecnocode.repository.QualificationRepository;
import com.tecnocode.service.QualificationService;
import com.tecnocode.validator.Operation;
import com.tecnocode.validator.QualificationValidator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QualificationServiceImpl implements QualificationService {
	private final QualificationRepository repository;
	private final QualificationValidator validator;

	@Override
	public Qualification save(final Qualification qualification, Operation operation) {
		validator.validate(qualification);
		return repository.saveAndFlush(qualification);
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Qualification> buscarTodosComEstaQualificacao(String name) {
		return repository.findAllByName(name);
	}

	@Override
	public List<Qualification> buscarTodosComEsteNivel(String level) {
		return repository.findAllByLevel(level);
	}

	@Override
	public List<Qualification> buscarTodosComEstaInstituicao(String institution) {
		return repository.findAllByInstitution(institution);
	}

	@Override
	public List<Qualification> buscarTodosComEsteStatus(String status) {
		return repository.findAllByStatus(status);
	}
}
