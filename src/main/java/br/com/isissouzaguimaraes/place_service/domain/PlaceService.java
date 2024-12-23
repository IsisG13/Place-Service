package br.com.isissouzaguimaraes.place_service.domain;

import com.github.slugify.Slugify;

import br.com.isissouzaguimaraes.place_service.api.PlaceRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slg;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(null, placeRequest.name(),
                slg.slugify(placeRequest.name()), placeRequest.state(), null,
                null);
        return placeRepository.save(place);
    }

    public Flux<Place> findAll() {
        return placeRepository.findAll(); // Supondo que o repositório seja reativo
    }

}
