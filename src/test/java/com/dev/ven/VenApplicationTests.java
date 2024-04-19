package com.dev.ven;

import com.dev.ven.controller.FarmController;
import com.dev.ven.controller.ReportController;
import com.dev.ven.service.ReportService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class VenApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private ReportController reportController;

	@InjectMocks
	private FarmController farmController;

	@Test
	private void testGetFarmReport() throws Exception {
		String successSubString = "Report for Farm found";
		ResponseEntity<String> response = new ResponseEntity<>("Report for Farm found", HttpStatus.OK);

		when(restTemplate.getForEntity("http://localhost:8080/ven/report/getFarmReport/:farmId", String.class))
				.thenReturn(response);

		//instead of String return type, i could have retrurned ResponseEntity  from my API
		// and that also can be asseretd here
		//but leaving as it is now due to time constraint
		String actualResponse = this.reportController.getFarmReport("MyFarm1");

		//just checking if successString is present or not in the actual reponse which should be per my actual reponse
		assertTrue(actualResponse.contains(successSubString));

		//now since returning only string, for asserting HttpStatus code, can used MockMvc
		mockMvc.perform(get("http://localhost:8080/ven/report/getFarmReport/:farmId"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(successSubString)));

	}


	@Test
	private void testGetCropReport() throws Exception {
		String successSubString = "Report for Crop found";
		ResponseEntity<String> response = new ResponseEntity<>("Report for Farm found", HttpStatus.OK);

		when(restTemplate.getForEntity("http://localhost:8080/ven/report/getCropReport/:cropName", String.class))
				.thenReturn(response);

		//instead of String return type, i could have retrurned ResponseEntity  from my API
		// and that also can be asseretd here
		//but leaving as it is now due to time constraint
		String actualResponse = this.reportController.getCropReport("Corn");

		//just checking if successString is present or not in the actual reponse which should be per my actual reponse
		assertTrue(actualResponse.contains(successSubString));

		//now since returning only string, for asserting HttpStatus code, can used MockMvc
		mockMvc.perform(get("http://localhost:8080/ven/report/getCropReport/:cropName"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString(successSubString)));

	}


}
