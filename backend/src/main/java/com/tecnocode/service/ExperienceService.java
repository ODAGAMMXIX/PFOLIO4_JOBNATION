package com.tecnocode.service;

import java.time.LocalDate;
import java.util.List;

import com.tecnocode.model.Experience;

public interface ExperienceService extends GenericService <Experience> {
	List<Experience> buscarTodasExperienciasComEssaEmpresa(final String company);
	
	List<Experience> buscarTodasExperienciasComEssaCidade(final String city);
	
	List<Experience> buscarTodasExperienciasComEssaDataDeInicio(final LocalDate start);
	
	List<Experience> buscarTodasExperienciasComEssaDataDeFim(final LocalDate end);
	
	List<Experience> buscarTodasExperienciasComEsseTitulo(final String title);
	
	List<Experience> buscarTodasExperienciasComEsseAchiev(final String achiev);

}
