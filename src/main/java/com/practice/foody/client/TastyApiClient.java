package com.practice.foody.client;

import com.practice.foody.config.TastyApiConfig;
import com.practice.foody.domain.MealType;
import com.practice.foody.domain.Preferences;
import com.practice.foody.domain.RecipeDto;
import com.practice.foody.domain.TastyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TastyApiClient {
    private final RestTemplate restTemplate;
    private final TastyApiConfig tastyApiConfig;

    public List<RecipeDto> getRecipes (URI uri) {

        ResponseEntity<TastyResponseDto> response = restTemplate.exchange(uri, HttpMethod.GET,createHeaders(), TastyResponseDto.class);
        return Optional.ofNullable(response.getBody().getRecipes()).orElse(Collections.emptyList());
    }

    public URI createQuery(Preferences preferences, MealType mealType, int offset) {
        List<String> tags = new ArrayList<>();
        if(preferences != null) {
            tags = preferences.getPreferences().stream()
                    .map(tag -> tag.getChose())
                    .collect(Collectors.toList());
            tags.add(mealType.getTag());
        }else {
            tags.add(mealType.getTag());
        }

        return UriComponentsBuilder.fromHttpUrl(tastyApiConfig.getTastyApiEndpoint())
                .queryParam("from", offset)
                .queryParam("size", "1")
                .queryParam("tags", tags)
                .build().encode().toUri();
    }

    public int getRecipesCount(URI uri) {
        ResponseEntity<TastyResponseDto> response = restTemplate.exchange(uri, HttpMethod.GET,createHeaders(), TastyResponseDto.class);
        return response.getBody().getCount();
    }
    public HttpEntity createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", tastyApiConfig.getTastyApiKey());
        headers.set("X-RapidAPI-Host", tastyApiConfig.getTastyApiHost());
        return new HttpEntity<>(headers);
    }
}
