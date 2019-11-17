/**
 * 
 */
package com.example.demo.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Manufacturer;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author aditya
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
//Transactional makes a rollback by default after test completes
class ManufacturerControllerTestV2 {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnAManufacturer() throws Exception {
		this.mockMvc.perform(get("/manufacturer/{manufacturerId}", 5)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("FORD")));
	}

	@Test
	public void shouldReturnApiError() throws Exception {
		this.mockMvc.perform(get("/manufacturer/{manufacturerId}", 25)).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void shouldCreateANewManufacturer() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/manufacturer")
				.content(asJsonString(new Manufacturer(40, "yyy", "uuiuii", "dd@dada.com")))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}

	@Test
	public void shouldNotCreateANewManufacturer() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/manufacturer")
				.content(asJsonString(new Manufacturer(40, "yyyyyyyyyyyyyyy", "uuiuii", "dd@dada.com")))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	private static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
