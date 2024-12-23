package br.com.isissouzaguimaraes.place_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.isissouzaguimaraes.place_service.domain.PlaceRepository;
import br.com.isissouzaguimaraes.place_service.domain.PlaceService;

@Configuration
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }
}
