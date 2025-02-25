package exercise;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRepresentation = objectMapper.writeValueAsString(this);
        return jsonRepresentation;
    }

    public static Car deserialize(String jsonRepresentation) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonRepresentation, Car.class);
    }
    // END
}
