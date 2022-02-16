package com.ashokit.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashokit.service.SsaService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SsnValidationRestController.class)
public class SsnValidationRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SsaService service;

	@Test
	public void validateTest() throws Exception {

		when(service.checkEnrollment(101l)).thenReturn("IN-VALID");

		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/getStateName/101");

		MvcResult result = mockMvc.perform(req).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String resString = response.getContentAsString();

		System.out.println("Response from API :: " + resString);

		assertEquals("IN-VALID", resString);
	}

}
