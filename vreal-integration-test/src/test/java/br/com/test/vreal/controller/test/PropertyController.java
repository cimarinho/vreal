package br.com.test.vreal.controller.test;

import br.com.test.vreal.controller.test.util.AppConfig;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.jayway.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropertyController {

    private String JSON = "application/json; charset=utf-8";
    String URI = "/properties";
    static Long id = null;
    public static String JSON_OK = "{\"x\":601,\"y\":501,\"title\":\"Imóvel código 639, com 2 quartos e 1 banheiros.\",\"price\":212121,\"description\":\"Mollit exercitation eiusmod deserunt occaecat id deserunt nisi minim cillum mollit. Tempor cillum deserunt nisi mollit dolore est ex.\",\"beds\":2,\"baths\":1,\"squareMeters\":40}";

    @Before
    public void setUp() {
        RestAssured.baseURI = AppConfig.APP_HOST.asString();
        RestAssured.port = AppConfig.APP_PORT.asInt();
    }

    @Test
    public void create_unsucess() {
        given()
                .contentType(JSON)
                .when()
                .post(URI)
                .then()
                .statusCode(400);
    }

    @Test
    public void create_sucess() {
        String response = given()
                .contentType(JSON)
                .body(JSON_OK)
                .when()
                .post(URI)
                .then()
                .extract()
                .body().asString();

        if (propertyEntity_already_registered(response)) {
            find_id_property();
        } else {
            String idResponse = JsonPath.from(response).getString("id");
            this.id = Long.parseLong(idResponse);
        }
    }

    @Test
    public void get_error() throws Exception {
        given()
                .contentType(JSON)
                .when()
                .get(URI + "/0")
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }


    @Test
    public void get_ok() throws Exception {
        given()
                .contentType(JSON)
                .when()
                .get(URI + "/" + id)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAll_ok() throws Exception {
        given()
                .contentType(JSON)
                .when()
                .get(URI + "?ax=1&ay=5&bx=7&by=91")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getAll_nok_badrequest() throws Exception {
        given()
                .contentType(JSON)
                .when()
                .get(URI + "?ax=1&ay=5&bx=7")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void getAll_param_error() throws Exception {
        given()
                .contentType(JSON)
                .when()
                .get(URI + "?ax=1&ay=5&bx=7&by=-1")
                .then()
                .statusCode(HttpStatus.SC_UNPROCESSABLE_ENTITY);
    }

    private void find_id_property() {
        String response = given()
                .contentType(JSON)
                .when()
                .get("/integration/601/501")
                .then()
                .extract()
                .body().asString();

        String idResponse = JsonPath.from(response).getString("id");
        this.id = Long.parseLong(idResponse);

    }

    private Boolean propertyEntity_already_registered(String response) {
        if (response.contains("PropertyEntity already registered")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}