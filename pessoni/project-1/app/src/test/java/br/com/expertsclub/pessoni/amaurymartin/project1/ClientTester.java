package br.com.expertsclub.pessoni.amaurymartin.project1;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ClientTester {

  private final String API_URI = "http://tester-global-cliente-api.herokuapp.com";

  @Test
  @DisplayName("Dado que requisito a lista de todos os clientes, então espero ver Experts Club User")
  public void checkClientsList() {
    final String GET_ALL_CLIENTS_ENDPOINT = "/clientes";
    final String EXPECTED_CLIENT_NAME = "Experts Club Client";

    given()
      .contentType(ContentType.JSON)
    .when()
      .get(API_URI.concat(GET_ALL_CLIENTS_ENDPOINT))
    .then()
      .statusCode(HttpStatus.SC_OK)
      .assertThat().body(containsString(EXPECTED_CLIENT_NAME));
  }

}