package com.tecnocode.service;

import com.tecnocode.model.Apply;
import com.tecnocode.validator.Operation;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface ApplyService  extends GenericService<Apply>{
    Apply saveNewApply(Apply apply, Operation operation)
            throws RuntimeException, IOException, JSONException;
}
