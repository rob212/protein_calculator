package com.woita.protein_calculator;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProteinCalculatorApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void proteinCalculatorShouldByAvailableViaValidHTTPGet() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calc?weight=68", String.class);
		assertThat(response.getBody()).contains("54.4");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void proteinCalculatorShouldReturnErrorForInvalidInputParamHTTPGet() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/calc?weight=-12", String.class);
		assertThat(response.getBody()).contains("weight must be a positive number.");
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	}

}
