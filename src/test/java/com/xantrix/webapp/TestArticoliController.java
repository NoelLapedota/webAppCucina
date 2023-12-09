package com.xantrix.webapp;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.xantrix.webapp.dtos.ArticoliDto;
import com.xantrix.webapp.services.ArticoliService;

@SpringBootTest()
@ContextConfiguration(classes = Application.class)
public class TestArticoliController {
	
   private  MockMvc mockMvc;
   
   @MockBean
   private ArticoliService articoliService;
   
   @Autowired
   private WebApplicationContext wac;
   
   
   @BeforeEach
   public void setup()
   {
	   mockMvc = MockMvcBuilders
			   .webAppContextSetup(wac)
			   .build();
   }
   
   @Test
   public void testGetArticoli() throws Exception
   {
	   
	   // Mock data
       List<ArticoliDto> mockArticoli = new ArrayList<>();
       mockArticoli.add(new ArticoliDto());

       // Configura il comportamento del mock service
       when(articoliService.findAllArticle()).thenReturn(mockArticoli);

       mockMvc.perform(get("/articoli"))
              .andExpect(status().isOk())
              .andExpect(view().name("articoli"))
              .andExpect(model().attribute("articoli", mockArticoli));
   
   }
   
   @Test
   public void testGetArticoli1() throws Exception {
       // Mock data
       List<ArticoliDto> mockArticoli = Arrays.asList(new ArticoliDto(), new ArticoliDto());

       // Configura il comportamento del mock service
       when(articoliService.SelByDescrizione(anyString(), anyInt(), anyInt())).thenReturn(mockArticoli);
       // Esegui la richiesta HTTP e verifica il risultato
       mockMvc.perform(get("/cerca/descrizione/{filter}", "filter"))
              .andExpect(status().isOk())
              .andExpect(view().name("articoli"))
              .andExpect(model().attribute("articoli", mockArticoli));
   }
   
   
   
   @RunWith(SpringRunner.class)
   @WebMvcTest(TestArticoliController.class)
   public class YourControllerTest {

       @Autowired
       private MockMvc mockMvc;

       @MockBean
       private ArticoliService articoliService;

       @Test
       public void testSearchItem() throws Exception {
           // Mock data
           List<ArticoliDto> mockArticoli = Arrays.asList(new ArticoliDto(/*...*/), new ArticoliDto(/*...*/));

           when(articoliService.findBySerch(anyString())).thenReturn(mockArticoli);

           mockMvc.perform(get("/articoli/search")
                   .param("filtro", "yourFilter"))
                  .andExpect(status().isOk())
                  .andExpect(view().name("articoli"))
                  .andExpect(model().attribute("articoli", mockArticoli));
       }
   }
}
   
   
   
   
   
   

