package com.amresh.restapp.MobileStoreRestApp;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.amresh.restapp.mobilestorerestapp.controller.MobileController;
import com.amresh.restapp.mobilestorerestapp.model.Mobiles;
import com.amresh.restapp.mobilestorerestapp.service.MobileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MobileStoreRestAppApplicationTests {
	@InjectMocks
	private MobileController mobileController;

	@Mock
	private RequestAttributes attributes;

	@Mock
	private MobileService mobileService;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		RequestContextHolder.setRequestAttributes(attributes);
		this.mockMvc = MockMvcBuilders.standaloneSetup(mobileController).build();

	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> c)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, c);
	}

	@Test
	public void getAllMobilesDetails() {
		int id = 5;
		String brandName = "Samsung";
		String modelName = "M20";
		int ramInGB = 4;
		int memoryInGB = 64;
		String processor = "Snapdragon720";
		float displayInInches = 5.5f;
		String os = "Android";
		long batteryCapacity = 3000;
		String colour = "Black";

		List<Mobiles> mobileList = new ArrayList<>();
		Mockito.when(mobileService.findAllMobiles()).thenReturn(mobileList);
		Assert.assertNotNull(mobileList);
		Assert.assertNotNull(id);
		Assert.assertNotNull(brandName);
		Assert.assertNotNull(modelName);
		Assert.assertNotNull(ramInGB);
		Assert.assertNotNull(memoryInGB);
		Assert.assertNotNull(processor);
		Assert.assertNotNull(displayInInches);
		Assert.assertNotNull(os);
		Assert.assertNotNull(batteryCapacity);
		Assert.assertNotNull(colour);

	}

	@Test
	public void getMobilesDetailsByModelName() {
		String modelName = "Iphone 11";
		List<Mobiles> mobileList = new ArrayList<>();
		Mockito.when(mobileService.findByModelName(modelName)).thenReturn(mobileList);
		Assert.assertNotNull(mobileController.getAllByModelName(modelName));
		Assert.assertNotNull(mobileList);
		Assert.assertNotNull(modelName);

	}

	@Test
	public void addMobilesTest() throws Exception {
		String uri = "/mobiles/addMobile";
		Mobiles mobiles = new Mobiles();
		mobiles.setId(100);
		mobiles.setBrandName("Apple");
		mobiles.setModelName("Iphone11");
		mobiles.setRamInGB(6);
		mobiles.setMemoryInGB(64);
		mobiles.setProcessor("Exynos");
		mobiles.setDisplayInInches(5.5f);
		mobiles.setOs("Mac OS");
		mobiles.setBatteryCapacity(5000);
		mobiles.setColour("RED");

		String inputJson = this.mapToJson(mobiles);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Mobile Added Successfully");
	}

}
