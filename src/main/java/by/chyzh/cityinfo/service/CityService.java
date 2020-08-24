package by.chyzh.cityinfo.service;

import by.chyzh.cityinfo.dto.CityDto;
import by.chyzh.cityinfo.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    City save(CityDto cityDto);

    void update(CityDto cityDto);

    void delete(Long id);

    CityDto findById(Long id);

    CityDto findByName(String name);

    List<CityDto> findAll();
}
