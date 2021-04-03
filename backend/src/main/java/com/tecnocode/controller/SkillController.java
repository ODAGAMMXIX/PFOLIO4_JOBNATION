package com.tecnocode.controller;

import com.tecnocode.converter.SkillToDtoConverter;
        import com.tecnocode.converter.DtoToSkillConverter;
        import com.tecnocode.model.Skill;
        import com.tecnocode.payload.SkillDTO;
        import com.tecnocode.service.SkillService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService service;
    private final DtoToSkillConverter dtoToSkillConverter;
    private final SkillToDtoConverter skillToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(final SkillDTO skillDTO) {
        try {
            Skill skill = service.save(dtoToSkillConverter.convert(skillDTO));
            return ResponseEntity.status(HttpStatus.CREATED).body(skillToDtoConverter.convert(skill));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
