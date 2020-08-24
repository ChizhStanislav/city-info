package by.chyzh.cityinfo.repository;

import by.chyzh.cityinfo.entity.City;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    List<City> findAll();

    Optional<City> findByName(String name);

    @Modifying
    @Query("update City c set c.name =:name, c.description =:description where c.id =:id")
    void update(@Param("id") Long id,
                @Param("name") String name,
                @Param("description") String description);

}
