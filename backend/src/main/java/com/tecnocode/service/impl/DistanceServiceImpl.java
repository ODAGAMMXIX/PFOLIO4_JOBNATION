package com.tecnocode.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import com.tecnocode.model.Distance;
import com.tecnocode.service.DistanceService;
import com.tecnocode.validator.DistanceValidator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DistanceServiceImpl implements DistanceService {
    private final DistanceValidator distanceValidator;

    public String getDistance(Distance distance) throws IOException, JSONException {
        distanceValidator.validate(distance);
        URL url = new URL("https://jobnation-maps.herokuapp.com/transit-routes");
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;
        http.setRequestMethod("POST"); // PUT is another valid option
        http.setDoOutput(true);

        String json = "{\"destination\":\""+ distance.getDestination() +"\", \"origin\":\"" + distance.getOrigin() +"\"}";

        byte[] out = json .getBytes(StandardCharsets.UTF_8);

        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.connect();
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }

        InputStream response = http.getInputStream(); //Lendo a resposta
        System.out.println(response);
        String result = new BufferedReader(new InputStreamReader(response)) // Parsing em String \n
                .lines().collect(Collectors.joining("\n"));

        System.out.print(result);

        JSONObject json_str = new JSONObject(result);
        Integer transport_number = json_str.getInt("transport_number"); // Integer, IF NECESSARY
        JSONObject distance_json = (JSONObject) json_str.get("distance");
        String distance_text = distance_json.getString("text"); //String
        System.out.println("VTN" + transport_number);
        System.out.println("DISTANCE" + distance_text);

        return result;
    }
}