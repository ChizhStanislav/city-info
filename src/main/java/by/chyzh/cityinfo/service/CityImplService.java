package by.chyzh.cityinfo.service;

import by.chyzh.cityinfo.dto.CityDto;
import by.chyzh.cityinfo.entity.City;
import by.chyzh.cityinfo.exception.NotFoundException;
import by.chyzh.cityinfo.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CityImplService implements CityService {

    private final CityRepository cityRepository;

    @Override
    @Transactional
    public City save(CityDto cityDto) {
        return cityRepository.save(City.builder()
                .name(cityDto.getName())
                .description(cityDto.getDescription())
                .build());
    }

    @Override
    @Transactional
    public void update(CityDto cityDto) {
        if (cityRepository.existsById(cityDto.getId())) {
            cityRepository.update(cityDto.getId(), cityDto.getName(), cityDto.getDescription());
        } else {
            throw new NotFoundException("City with id " + cityDto.getId() + " not found");
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
        } else {
            throw new NotFoundException("City with id " + id + " not found");
        }
    }

    @Override
    public CityDto findById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new NotFoundException("City with id " + id + " not found"));
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .description(city.getDescription())
                .build();
    }

    @Override
    public CityDto findByName(String name) {
        City city = cityRepository.findByNameIgnoreCase(name).orElseThrow(() -> new NotFoundException("City with name " + name + " not found"));
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .description(city.getDescription())
                .build();
    }

    @Override
    public List<CityDto> findAll() {
        return cityRepository.findAll().stream()
                .map(city -> CityDto.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .description(city.getDescription())
                        .build())
                .collect(Collectors.toList());
    }
}
