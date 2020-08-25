
package com.mathworks.headcount.api.response.addproposed;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "nameRollup",
    "country",
    "eligibilityRule"
})
public class Location {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameRollup")
    private String nameRollup;
    @JsonProperty("country")
    private String country;
    @JsonProperty("eligibilityRule")
    private String eligibilityRule;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nameRollup")
    public String getNameRollup() {
        return nameRollup;
    }

    @JsonProperty("nameRollup")
    public void setNameRollup(String nameRollup) {
        this.nameRollup = nameRollup;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("eligibilityRule")
    public String getEligibilityRule() {
        return eligibilityRule;
    }

    @JsonProperty("eligibilityRule")
    public void setEligibilityRule(String eligibilityRule) {
        this.eligibilityRule = eligibilityRule;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
