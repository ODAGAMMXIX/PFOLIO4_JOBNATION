package com.tecnocode.controller;

import com.tecnocode.converter.ApplyToDtoConverter;
import com.tecnocode.converter.DtoToApplyConverter;
import com.tecnocode.model.Address;
import com.tecnocode.model.Apply;
import com.tecnocode.payload.ApplyDTO;
import com.tecnocode.service.ApplyService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/apply")
@RequiredArgsConstructor
public class ApplyController {
    private final ApplyService service;
    private final DtoToApplyConverter dtoToApplyConverter;
    private final ApplyToDtoConverter applyToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final ApplyDTO applyDTO) {
        try {
            Apply apply = service.save(dtoToApplyConverter.convert(applyDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(applyToDtoConverter.convert(apply));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping
    public List<Apply> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/search/{vacancy_id}")
    public List<Apply> search(@PathVariable("vacancy_id") final Integer vacancyId,
                              @PathParam("gender") final String gender,
                              @PathParam("languages") final String[] languages,
                              @PathParam("qualifications") final String[] qualifications,
                              @PathParam("skills") final String[] skills){
        return service.search(vacancyId, gender, new HashSet(asList(languages)), new HashSet(asList(qualifications)), new HashSet(asList(skills)));
    }
}
