package com.lessard.codesamples.order;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.lessard.codesamples.order.model.SalesOrder;
import com.lessard.codesamples.order.repositories.SalesOrderRepository;
import com.lessard.codesamples.order.services.SalesOrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;


/**
 * Unit test for simple OrderController.
 */

public class SalesSalesOrderServiceTest {

	private MockMvc mockMvc;

    @Mock
    private SalesOrderRepository salesOrderRepository;

	@Before
	public void setup() {

        MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(new SalesOrderService(salesOrderRepository)).build();
        Mockito.when(salesOrderRepository.findByPrimaryKey(0)).thenReturn(new SalesOrder(0, "SalesOrder 0", "Date 0"));

        List<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();

        salesOrderList.add(new SalesOrder(0, "SalesOrder 0", "Date 0"));
        salesOrderList.add(new SalesOrder(1, "SalesOrder 1", "Date 1"));
        salesOrderList.add(new SalesOrder(2, "SalesOrder 2", "Date 2"));

        Mockito.when(salesOrderRepository.findAll()).thenReturn(salesOrderList);
	}

	@Test
	public void testHello() throws Exception{

		mockMvc.perform(get("/hello")).andExpect(status().isOk())
				.andExpect(content().string("Hello World"));
		
	}

/*
	@Test
	public void testOrder() throws Exception{

		mockMvc.perform(get("/order/0")).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andExpect( jsonPath("$.id").value("0")   ) .
                andExpect( jsonPath("$.description").value("SalesOrder 0")   ) ;
	}

    @Test
    public void testOrders() throws Exception{

        mockMvc.perform(get("/orders")).andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andExpect( jsonPath("$", hasSize(3)  )).
                andExpect( jsonPath("$.[0].id").value("0")  ) .
                andExpect( jsonPath("$.[0].description").value("SalesOrder 0")  ) .
                andExpect( jsonPath("$.[1].id").value("1")  ) .
                andExpect( jsonPath("$.[1].description").value("SalesOrder 1")  ) .
                andExpect( jsonPath("$.[2].id").value("2")  ).
                andExpect( jsonPath("$.[2].description").value("SalesOrder 2")  ) ;


    }
*/


}
