package com.corvinicolas.bus_tracker.mappers;

import com.corvinicolas.bus_tracker.application.service.model.BusProximityModel;
import com.corvinicolas.bus_tracker.providers.tmb_app.dto.IBusResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusProximityMapper {
    BusProximityModel iBusToServiceModel(IBusResponse busResponse);
}
