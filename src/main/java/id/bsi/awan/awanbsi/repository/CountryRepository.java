package id.bsi.awan.awanbsi.repository;

import io.spring.guides.gs_producing_web_service.Country;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository {

    Optional<Country> findCountry(String name);

}
