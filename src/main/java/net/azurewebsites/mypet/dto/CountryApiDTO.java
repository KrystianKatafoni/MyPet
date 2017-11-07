package net.azurewebsites.mypet.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Krystian Katafoni
 * @since 05.11.2017
 * Data Transfer Object class for CountryAPI.
 * CountryAPIDTO serves as a transformation for objects from
 * Api(JSON) to objects from back-end layer
 */
@Getter
@Setter
@NoArgsConstructor
public class CountryApiDTO implements Serializable {

    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8278683141842714905L;

    public String getName() {
            return name;
        }

    public void setName(String name) {
            this.name = name;
        }

    public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

    public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

}

