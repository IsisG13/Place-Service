package br.com.isissouzaguimaraes.place_service.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isissouzaguimaraes.place_service.domain.Place;
import br.com.isissouzaguimaraes.place_service.domain.PlaceService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<Place>> create(@RequestBody Place place) {
        var createdPlace = placeService.created(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);
    }
}
