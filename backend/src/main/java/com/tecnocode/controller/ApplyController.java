package com.tecnocode.controller;

import com.tecnocode.converter.ApplyToDtoConverter;
import com.tecnocode.converter.DtoToApplyConverter;
import com.tecnocode.model.Apply;
import com.tecnocode.payload.ApplyDTO;
import com.tecnocode.service.ApplyService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            Apply apply = service.saveNewApply(dtoToApplyConverter.convert(applyDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(applyToDtoConverter.convert(apply));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
