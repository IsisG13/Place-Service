package br.com.isissouzaguimaraes.place_service.api;

import jakarta.validation.constraints.NotBlank;

public record PlaceRequest(
                @NotBlank String name,
                @NotBlank String state) {

}