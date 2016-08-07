package com.lessard.codesamples.order.controllers;


import com.lessard.codesamples.order.JpaTestConfiguration;
import com.lessard.codesamples.order.domain.SalesOrder;
import com.lessard.codesamples.order.services.SalesOrderService;
import io.restassured.http.ContentType;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.*;


@ContextConfiguration(classes = {JpaTestConfiguration.class})
@WebAppConfiguration
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class SalesOrderControllerIT {


    @Before
    public void setup() {
    }

    @Test
    public void testGetSalesOrder() throws Exception

    {
        System.out.println("TEST INTEGRATION");

        when().
                get("http://localhost:8080/RestSpringMvcJpaApp/salesorders/100").
                then().statusCode(200).body("id" , equalTo("200"));
                //contentType(ContentType.JSON);


        System.out.println("TEST INTEGRATION END");
    }


    @Test
    public void testGetAllSalesOrder() throws Exception

    {
        System.out.println("TEST INTEGRATION");

        when().
                get("http://localhost:8080/RestSpringMvcJpaApp/salesorders").
                then().statusCode(200).body("id" , equalTo("200"));
        //contentType(ContentType.JSON);


        System.out.println("TEST INTEGRATION END");
    }

}