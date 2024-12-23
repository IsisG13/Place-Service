package br.com.isissouzaguimaraes.place_service.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isissouzaguimaraes.place_service.api.PlaceRequest;
import br.com.isissouzaguimaraes.place_service.api.PlaceResponse;
import br.com.isissouzaguimaraes.place_service.domain.PlaceService;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request) {
        var PlaceResponse = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(PlaceResponse);
    }

    @GetMapping
    public ResponseEntity<Mono<List<PlaceResponse>>> findAll() {
        var places = placeService.findAll()  // Supõe que PlaceService tenha o método findAll()
                .map(PlaceMapper::fromPlaceToResponse)
                .collectList();
        return ResponseEntity.ok(places);
    }
}
