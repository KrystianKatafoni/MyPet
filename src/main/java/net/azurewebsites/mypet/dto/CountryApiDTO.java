package net.azurewebsites.mypet.dto;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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

