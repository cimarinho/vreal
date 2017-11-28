package br.com.test.vreal.controller.test;

import br.com.test.vreal.VRealApplication;
import br.com.test.vreal.repository.ProvinceRepository;
import br.com.test.vreal.service.PropertyService;
import br.com.test.vreal.validator.PropertyValidator;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VRealApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles({"test"})
public class PropertyControllerTest  {

    @Autowired
    public MockMvc mvc;

    @Autowired
    PropertyService propertyService;

    @Autowired
    ProvinceRepository provinceRepository;

    @Autowired
    PropertyValidator propertyValidator;

    @Test
    public void create_unsucess() throws Exception {
        this.mvc.perform(
                post("/properties")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void create_sucess() throws Exception {


        this.mvc.perform(
                post("/properties")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"x\":32,\"y\":732,\"title\":\"Imóvel código 1, com 5 quartos e 4 banheiros\",\"price\":1250000,\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\",\"beds\":4,\"baths\":3,\"squareMeters\":210}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void get_error() throws Exception {
        this.mvc.perform(get("/properties/0"))
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    public void get_ok() throws Exception {
        this.mvc.perform(get("/properties/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAll_ok() throws Exception {
        this.mvc.perform(get("/properties?ax=1&ay=5&bx=7&by=91"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAll_nok_badrequest() throws Exception {
        this.mvc.perform(get("/properties?ax=1&ay=5&bx=7"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getAll_param_error() throws Exception {
        this.mvc.perform(get("/properties?ax=1&ay=5&bx=7&by=-1"))
                .andExpect(status().isUnprocessableEntity());
    }
}
