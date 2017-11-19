package br.com.test.vreal.controller;

import br.com.test.vreal.VRealApplicationTests;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PropertyControllerTest extends VRealApplicationTests {

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
                        .content("{\"x\":500,\"y\":700,\"title\":\"Imóvel código 1, com 5 quartos e 4 banheiros\",\"price\":1250000,\"description\":\"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\",\"beds\":4,\"baths\":3,\"squareMeters\":210}"))
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
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.errorMessage").value("Id >1< not exist."));
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
