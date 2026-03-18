package kristian.springframework.spring_7_rest_mvc.controller;

import kristian.springframework.spring_7_rest_mvc.model.Beer;
import kristian.springframework.spring_7_rest_mvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {

    private final BeerService beerService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Beer>listBeer() {
        return beerService.listBeers();
    }


    @RequestMapping(value = "/{beerId}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {
        log.debug("getBeerById - in BeerController");
        return beerService.getBeerById(beerId);
    }
}
