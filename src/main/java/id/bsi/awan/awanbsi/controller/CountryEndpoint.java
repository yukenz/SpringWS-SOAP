package id.bsi.awan.awanbsi.controller;

import id.bsi.awan.awanbsi.repository.CountryRepository;
import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@RequiredArgsConstructor
@Slf4j
public class CountryEndpoint {

    private final CountryRepository countryRepository;

    public static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(
            namespace = NAMESPACE_URI,
            localPart = "getCountryRequest"
    )
    @ResponsePayload

    public GetCountryResponse getCountry(
            @RequestPayload GetCountryRequest request
    ) {

        Country country = countryRepository.findCountry(request.getName()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        GetCountryResponse response = new GetCountryResponse();
        log.info("method called");
        response.setCountry(country);
        return response;
    }

}
