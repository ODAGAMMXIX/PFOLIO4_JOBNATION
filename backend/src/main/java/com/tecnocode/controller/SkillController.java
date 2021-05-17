package com.tecnocode.controller;

import com.tecnocode.converter.SkillToDtoConverter;
import com.tecnocode.converter.DtoToSkillConverter;
import com.tecnocode.model.Benefit;
import com.tecnocode.model.Skill;
import com.tecnocode.payload.SkillDTO;
import com.tecnocode.service.SkillService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService service;
    private final DtoToSkillConverter dtoToSkillConverter;
    private final SkillToDtoConverter skillToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final SkillDTO skillDTO) {
        try {
            Skill skill = service.save(dtoToSkillConverter.convert(skillDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(skillToDtoConverter.convert(skill));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/{name}")
    public List<Skill> buscarTodosComEsteNome(@PathVariable("name") String name){
        return service.buscarTodosComEsteNome(name);
    }

    @GetMapping("/{level}")
    public List<Skill> buscarTodosComEsteNivel(@PathVariable("level") String level){
        return service.buscarTodosComEsteNivel(level);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
