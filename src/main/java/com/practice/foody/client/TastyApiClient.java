package com.practice.foody.client;

import com.practice.foody.config.TastyApiConfig;
import com.practice.foody.domain.MealType;
import com.practice.foody.domain.Preferences;
import com.practice.foody.domain.RecipesDto;
import com.practice.foody.domain.TastyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TastyApiClient {
    private final RestTemplate restTemplate;
    private final TastyApiConfig tastyApiConfig;

    public List<RecipesDto> getRecipes (Preferences preferences, MealType mealType) {
        List<String> tags = preferences.getPreferences().stream()
                .map(tag -> tag.getChose())
                .collect(Collectors.toList());
        tags.add(mealType.getTag());
        URI uri = UriComponentsBuilder.fromHttpUrl(tastyApiConfig.getTastyApiEndpoint())
                .queryParam("from", "0")
                .queryParam("size", "40")
                .queryParam("tags", tags)
                .build().encode().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", tastyApiConfig.getTastyApiKey());
        headers.set("X-RapidAPI-Host", tastyApiConfig.getTastyApiHost());
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<TastyResponseDto> response = restTemplate.exchange(uri, HttpMethod.GET,entity, TastyResponseDto.class);
        return response.getBody().getRecipes();




    }
}
