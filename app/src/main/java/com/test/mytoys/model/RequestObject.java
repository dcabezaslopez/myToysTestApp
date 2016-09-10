package com.test.mytoys.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "navigationEntries"
})
public class RequestObject {

    @JsonProperty("navigationEntries")
    private List<NavigationEntry> navigationEntries = new ArrayList<NavigationEntry>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     *     The navigationEntries
     */
    @JsonProperty("navigationEntries")
    public List<NavigationEntry> getNavigationEntries() {
        return navigationEntries;
    }

    /**
     *
     * @param navigationEntries
     *     The navigationEntries
     */
    @JsonProperty("navigationEntries")
    public void setNavigationEntries(List<NavigationEntry> navigationEntries) {
        this.navigationEntries = navigationEntries;
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

