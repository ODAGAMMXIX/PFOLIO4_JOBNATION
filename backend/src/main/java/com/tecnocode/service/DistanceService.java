package com.tecnocode.service;

import java.io.IOException;

import com.tecnocode.model.Distance;

import org.json.JSONException;

public interface DistanceService {
    String getDistance(Distance distance) throws IOException, JSONException;
}