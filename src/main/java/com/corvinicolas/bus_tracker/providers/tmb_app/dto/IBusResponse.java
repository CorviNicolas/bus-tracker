package com.corvinicolas.bus_tracker.providers.tmb_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IBusResponse {
    private String routeId;
    private String line;
    @JsonProperty(value = "text-ca")
    private String textCa;
    @JsonProperty(value = "t-in-s")
    private int timeInSeconds;
    @JsonProperty(value = "t-in-m")
    private int timeInMinutes;
}
