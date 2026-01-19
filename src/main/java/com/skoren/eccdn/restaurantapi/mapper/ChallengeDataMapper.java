package com.skoren.eccdn.restaurantapi.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jdk8.*;
import com.skoren.eccdn.restaurantapi.model.ChallengeData;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class ChallengeDataMapper {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        File challengeData = new File("src/main/resources/static/challengeData.json");

        ChallengeData data = mapper.readValue(challengeData, ChallengeData.class);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
