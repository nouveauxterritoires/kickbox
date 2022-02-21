package com.nouveauxterritoires.services.kickbox.serialize;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author szagriichuk.
 */
public class Serializer {
	
    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T deserialize(String data, Class<T> clazz) {
        try {
            setUpMapperVisibility();
            return mapper.readValue(data, clazz);
        } catch (IOException e) {
            throw new SerializerException(e);
        }
    }

    private static void setUpMapperVisibility() {
        mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.ANY)
                .withSetterVisibility(JsonAutoDetect.Visibility.ANY)
                .withCreatorVisibility(JsonAutoDetect.Visibility.ANY));
    }

    public static JsonNode deserialize(String data) {
        try {
            return mapper.readTree(data);
        } catch (IOException e) {
            throw new SerializerException(e);
        }
    }

    public static <T> String serialize(T data) {
        try {
            return mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(data);
        } catch (IOException e) {
            throw new SerializerException(e);
        }
    }
}
