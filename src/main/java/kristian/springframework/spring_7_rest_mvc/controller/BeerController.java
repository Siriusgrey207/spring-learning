package kristian.springframework.spring_7_rest_mvc.controller;

import kristian.springframework.spring_7_rest_mvc.model.Beer;
import kristian.springframework.spring_7_rest_mvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;


    @PutMapping(value = "/{beerId}")
    public ResponseEntity<HttpStatus> updateById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer) {
        beerService.updateBeerById(beerId, beer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<HttpStatus> handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.GET, value="")
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }


    @RequestMapping(method = RequestMethod.GET, value="/{beerId}")
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("Get Beer By Id - in controller - 1234");
        return beerService.getBeerById(beerId);
    }
}
