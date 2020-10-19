package guru.springframework.brewery.web.controllers;

import guru.springframework.brewery.services.BeerService;
import guru.springframework.brewery.web.model.BeerDto;
import guru.springframework.brewery.web.model.BeerPagedList;
import guru.springframework.brewery.web.model.BeerStyleEnum;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(MockitoExtension.class)
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockBean
    BeerService beerService;

//    Con SpringBoot no hace falta inyectarlos, los inyecta directamente Spring boot al declarar la clase en la anotación @WebMvcTest
//    @InjectMocks
//    BeerController beerController;

    @Autowired //este autowired hace falta con SpringBoot. No hace falta si se utiliza @ExtendsWith
    MockMvc mockMvc;

    BeerDto beerDto;

    @BeforeEach
    void setUp(){
        beerDto=BeerDto.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("Beer1")
                .beerStyle(BeerStyleEnum.PALE_ALE)
                .price(new BigDecimal("12.99"))
                .quantityOnHand(4)
                .upc(123456789012L)
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build();
//    converter previo a la slecciones con Spring Boot. Con Spring Boot no es necesario configurar los mapper
//        mockMvc = MockMvcBuilders.standaloneSetup(beerController).setMessageConverters(jackson2CborHttpMessageConverter()).build();

    }

    @AfterEach
    void tearDown(){
        reset(beerService);
    }

    @Test
    void testGetBeerById() throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");

        given(beerService.findBeerById(any())).willReturn(beerDto);
        mockMvc.perform(get("/api/v1/beer/"+ beerDto.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(beerDto.getId().toString())))
                .andExpect(jsonPath("$.beerName", is("Beer1")))
                .andExpect(jsonPath("$.createdDate", is(dateTimeFormatter.format(beerDto.getCreatedDate()))))
        ;
    }

    @DisplayName("List Ops - ")
    @Nested
    public class TestListOperations{
        @Captor
        ArgumentCaptor<String> beerNameCaptor;

        @Captor
        ArgumentCaptor<BeerStyleEnum> beerStyleEnumArgumentCaptor;

        @Captor
        ArgumentCaptor<PageRequest> pageRequestArgumentCaptor;

        BeerPagedList beerPagedList;

        @BeforeEach
        void setUp(){
            List<BeerDto> beers = Lists.newArrayList(beerDto);
            beers.add(BeerDto.builder().id(UUID.randomUUID())
                    .version(1)
                    .beerName("Beer4")
                    .upc(123123123122L)
                    .beerStyle(BeerStyleEnum.PALE_ALE)
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(66)
                    .createdDate(OffsetDateTime.now())
                    .lastModifiedDate(OffsetDateTime.now())
                    .build());

            beerPagedList = new BeerPagedList(beers, PageRequest.of(1, 1), 2L);
            given(beerService.listBeers(beerNameCaptor.capture(), beerStyleEnumArgumentCaptor.capture(),
                    pageRequestArgumentCaptor.capture())).willReturn(beerPagedList);
        }

        @DisplayName("TEst List beers - no parameters")
        @Test
        void testListBeers() throws Exception {
            mockMvc.perform(get("/api/v1/beer").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(jsonPath("$.content", hasSize(2)))
                    .andExpect(jsonPath("$.content[0].id", is(beerDto.getId().toString())));
        }
    }

//    converter previo a la slecciones con Spring Boot. Con Spring Boot no es necesario configurar los mapper. Lo tenemos en la anotación WebMVc
//    public MappingJackson2HttpMessageConverter jackson2CborHttpMessageConverter(){
//        ObjectMapper objectMapper= new ObjectMapper();
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        objectMapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, true);
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//
//        objectMapper.registerModule(new JavaTimeModule());
//        return new MappingJackson2HttpMessageConverter(objectMapper);
//    }
}