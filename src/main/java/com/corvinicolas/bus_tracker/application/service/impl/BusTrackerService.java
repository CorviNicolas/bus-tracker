package com.corvinicolas.bus_tracker.application.service.impl;

import com.corvinicolas.bus_tracker.providers.tmb_app.client.TmbAppClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BusTrackerService implements InitializingBean, SchedulingConfigurer {

    private final TmbAppClient tmbAppClient;

    @Override
    public void afterPropertiesSet() throws Exception {
        try{
            tmbAppClient.getStopPrevision()
        } catch (Exception e) {
            LOGGER.error("Error");
        }
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> , triggerContext -> triggerContext.);
    }
}
