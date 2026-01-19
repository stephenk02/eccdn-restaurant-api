package com.skoren.eccdn.restaurantapi.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.skoren.eccdn.restaurantapi.model.ChallengeData;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

public class ChallengeDataMapper {
    private static final String dataPath = "src/main/resources/static/challengeData.json";

    public static ChallengeData LoadChallengeData(){
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        File fileData = new File(dataPath);

        try {
            return mapper.readValue(fileData, ChallengeData.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
