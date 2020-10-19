package guru.springframework.brewery.web.controllers;

import guru.springframework.brewery.web.model.BeerPagedList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerControllerITTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void testListBeer() {
        BeerPagedList beerPagedList= testRestTemplate.getForObject("/api/v1/beer", BeerPagedList.class);
        assertThat(beerPagedList.getContent()).hasSize(3);
    }
}