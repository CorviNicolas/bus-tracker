package com.corvinicolas.bus_tracker.providers.tmb_app.client;

import com.corvinicolas.bus_tracker.mappers.BusProximityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class TmbAppClient {
    private final WebClient webClient;
    private final BusProximityMapper mapper;


}
