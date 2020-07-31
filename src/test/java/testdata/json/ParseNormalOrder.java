package testdata.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParseNormalOrder {

    public static ParseNormalOrder getNormalOrderData(String filename) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(filename), ParseNormalOrder.class);
    }

    @JsonProperty("fullname")
    String fullName;

    public String getFullName() {
        return fullName;
    }

    @JsonProperty("company")
    String company;

    public String getcompany() {
        return company;
    }
}
