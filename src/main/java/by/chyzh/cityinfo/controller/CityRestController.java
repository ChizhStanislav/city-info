package by.chyzh.cityinfo.controller;

import by.chyzh.cityinfo.dto.CityDto;
import by.chyzh.cityinfo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityRestController {

    private final CityService cityService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityDto>> getCities() {
        return ResponseEntity.ok().body(cityService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityDto> getCity(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(cityService.findById(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> saveCity(@RequestBody CityDto cityDto) {
        return ResponseEntity.ok().body(cityService.save(cityDto).getId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> updateCity(@RequestBody CityDto cityDto) {
        cityService.update(cityDto);
        return ResponseEntity.ok().body(cityDto.getId());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteCity(@PathVariable("id") Long id) {
        cityService.delete(id);
        return ResponseEntity.ok().body(id);
    }

}
