package br.com.isissouzaguimaraes.place_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import br.com.isissouzaguimaraes.place_service.domain.PlaceRepository;
import br.com.isissouzaguimaraes.place_service.domain.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }
}
