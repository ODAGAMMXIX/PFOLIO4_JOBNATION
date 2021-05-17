package com.tecnocode.service;

import com.tecnocode.model.Skill;

import java.util.List;

public interface SkillService extends GenericService<Skill>{
    List<Skill> buscarTodosComEsteNome(String name);

    List<Skill> buscarTodosComEsteNivel(String level);
}
