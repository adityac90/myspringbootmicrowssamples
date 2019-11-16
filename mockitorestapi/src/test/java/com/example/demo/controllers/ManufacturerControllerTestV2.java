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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author aditya
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
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
}
