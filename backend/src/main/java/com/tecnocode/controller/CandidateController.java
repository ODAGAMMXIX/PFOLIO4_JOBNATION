package com.tecnocode.controller;

import com.tecnocode.converter.CandidateToDtoConverter;
import com.tecnocode.converter.DtoToCandidateConverter;
import com.tecnocode.model.*;
import com.tecnocode.payload.CandidateDTO;
import com.tecnocode.payload.DistanceDTO;
import com.tecnocode.service.CandidateService;
import com.tecnocode.validator.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.DecodeException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService service;
    private final DtoToCandidateConverter dtoToCandidateConverter;
    private final CandidateToDtoConverter candidateToDtoConverter;

    @PostMapping
    public ResponseEntity saveNew(@RequestBody final CandidateDTO candidateDTO) {
        try {
            Candidate candidate = service.save(dtoToCandidateConverter.convert(candidateDTO), Operation.INSERT);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidateToDtoConverter.convert(candidate));
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{address}")
    public List<Candidate> buscarTodosCandidatosDesteEndereco(@PathVariable("address") Address address){
        return service.buscarTodosCandidatosDesteEndereco(address);
    }

    @GetMapping("/{experiences}")
    public List<Candidate> buscarTodosCandidatosComEstaExperiencia(@PathVariable("experience") Experience experience){
        return service.buscarTodosCandidatosComEstaExperiencia(experience);
    }

    @GetMapping("/{qualifications}")
    public List<Candidate> buscarTodosCandidatosComEstaQualificacao(@PathVariable("qualifications") Qualification qualifications){
        return service.buscarTodosCandidatosComEstaQualificacao(qualifications);
    }

    @GetMapping("/{skills}")
    public List<Candidate> buscarTodosCandidatosComEstaSkill(@PathVariable("qualifications") Skill skills){
        return service.buscarTodosCandidatosComEstaSkill(skills);
    }

    @GetMapping("/{languages}")
    public List<Candidate> buscarTodosCandidatosComEstaLingua(@PathVariable("languages") Language languages){
        return service.buscarTodosCandidatosComEstaLingua(languages);
    }

    @GetMapping("/{cpf}")
    public List<Candidate> buscarCandidatoComEsteCpf(@PathVariable("cpf") String cpf){
        return service.buscarCandidatoComEsteCpf(cpf);
    }

    @GetMapping("/{firstName}")
    public List<Candidate> buscarTodosCandidatosComEstePrimeiroNome(@PathVariable("firstName") String firstName){
        return service.buscarTodosCandidatosComEstePrimeiroNome(firstName);
    }

    @GetMapping("/{middleName}")
    public List<Candidate> buscarTodosCandidatosComEsteSobrenome(@PathVariable("middleName") String middleName){
        return service.buscarTodosCandidatosComEsteSobrenome(middleName);
    }

    @GetMapping("/{surname}")
    public List<Candidate> buscarTodosCandidatosComEsteUltimoNome(@PathVariable("surname") String surname){
        return service.buscarTodosCandidatosComEsteUltimoNome(surname);
    }

    @GetMapping("/{gender}")
    public List<Candidate> buscarTodosCandidatosComEsteGenero(@PathVariable("gender") String gender){
        return service.buscarTodosCandidatosComEsteGenero(gender);
    }

    @PostMapping("/get-distance")
    public String getDistance(@RequestBody final DistanceDTO body) throws IOException {
//    public List<Object> getDistance(@PathVariable("origin") String origin, @PathVariable("destination") String destination) throws IOException {

        String destination = body.getDestination();
        String origin = body.getOrigin();

        URL url = new URL("https://jobnation-maps.herokuapp.com/transit-routes");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        String json = "{\"destination\":\""+ destination +"\", \"origin\":\"" + origin +"\"}";

        byte[] out = json .getBytes(StandardCharsets.UTF_8);

        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        InputStream response = http.getInputStream();

        String result = new BufferedReader(new InputStreamReader(response))
                .lines().collect(Collectors.joining("\n"));

        System.out.print(result);

        return result;
    }
}
