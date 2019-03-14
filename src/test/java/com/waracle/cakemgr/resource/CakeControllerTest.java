package com.waracle.cakemgr.resource;

import com.waracle.cakemgr.entity.Cake;
import com.waracle.cakemgr.repository.CakeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CakeControllerTest {

    private MockMvc mockMvc;
    private CakeController cakeController;
    @Mock
    private CakeRepository cakeRepository;

    @Before
    public void setup(){
        cakeController = new CakeController(cakeRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(cakeController).build();
    }

    @Test
    public void getCakes_willReturnACollectionOfCakesInJsonFormat() throws Exception {
        Mockito.when(cakeRepository.findAll()).thenReturn(testIterableData());

        MvcResult mockDownloadResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/"))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals(200, mockDownloadResult.getResponse().getStatus());
        assertEquals("application/json;charset=UTF-8", mockDownloadResult.getResponse().getContentType());
        assertEquals(getExpectedCakeJson(), mockDownloadResult.getResponse().getContentAsString());
    }



    @Test
    public void downloadCakeJsonFile_willDownloadCakesInSystemAsJsonFile() throws Exception {
        Mockito.when(cakeRepository.findAll()).thenReturn(testIterableData());

        MvcResult mockDownloadResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/cakes"))
                .andExpect(MockMvcResultMatchers.status().is(200)).andReturn();

        assertEquals("application/json", mockDownloadResult.getResponse().getContentType());
        assertEquals("attachment; filename=cakes.json", mockDownloadResult.getResponse().getHeader("Content-Disposition"));
    }

    private Iterable<Cake> testIterableData() {
        return Arrays.asList(
                new Cake(1L, "Cheesecake", "description 1", "image 1"),
                new Cake(2L, "Chocolate Cake", "description 2", "image 2"),
                new Cake(3L, "Strawberry Cake", "description 3", "image 3")
        );
    }

    private String getExpectedCakeJson() {
        return "[{\"id\":1,\"title\":\"Cheesecake\",\"description\":\"description 1\",\"image\":\"image 1\"},{\"id\":2,\"title\":\"Chocolate Cake\",\"description\":\"description 2\",\"image\":\"image 2\"},{\"id\":3,\"title\":\"Strawberry Cake\",\"description\":\"description 3\",\"image\":\"image 3\"}]";
    }

}
