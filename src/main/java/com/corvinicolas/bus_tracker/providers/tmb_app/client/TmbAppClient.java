package com.corvinicolas.bus_tracker.providers.tmb_app.client;

import com.corvinicolas.bus_tracker.application.service.model.BusProximityModel;
import com.corvinicolas.bus_tracker.config.TmbCatConfig;
import com.corvinicolas.bus_tracker.mappers.BusProximityMapper;
import com.corvinicolas.bus_tracker.providers.tmb_app.dto.IBusStopPrevisionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TmbAppClient {
    private final WebClient webClient;
    private final TmbCatConfig tmbCatConfig;
    private final BusProximityMapper mapper;

    public Mono<BusProximityModel> getStopPrevision() {
        return webClient
                .get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/ibus/stops/{stopCode}");
                    uriBuilder.queryParam(TmbCatConfig.APP_ID_PARAM, tmbCatConfig.getAppId());
                    uriBuilder.queryParam(TmbCatConfig.APP_KEY_PARAM, tmbCatConfig.getAppKey());
                    return uriBuilder.build(Map.of("stopCode", "1775"));
                })
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(IBusStopPrevisionResponse.class))
                .map(mapper::iBusToServiceModel);
    }

}
