package com.lessard.codesamples.order.controllers;

import java.lang.Iterable;

import com.lessard.codesamples.order.model.SalesOrder;
import com.lessard.codesamples.order.repositories.SalesOrderRepository;
import com.lessard.codesamples.order.services.SalesOrderService;
import org.eclipse.persistence.internal.security.SecurableObjectHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SalesOrderController {


    private SalesOrderService salesOrderService;

    public SalesOrderController() {
    }

    @Autowired
    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    public SalesOrderService getSalesOrderService() {
        return salesOrderService;
    }

    public void setSalesOrderService(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> hello() {

        SecurableObjectHolder holder = new SecurableObjectHolder();
        String ePswd = holder.getSecurableObject().encryptPassword("12345678");
        System.out.println(">>" + ePswd + "<<");

        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }


    @RequestMapping(value = "/salesorders", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<SalesOrder> createSalesOrder(@RequestBody SalesOrder salesOrder) {

        salesOrderService.createSalesOrder(salesOrder);

        return new ResponseEntity<SalesOrder>(salesOrder, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/salesorders/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<SalesOrder> get(@PathVariable Integer id) {

        SalesOrder salesOrder = salesOrderService.getSalesOrder(id);

        return new ResponseEntity<SalesOrder>(salesOrder, HttpStatus.OK);
    }

    @RequestMapping(value = "/salesorders", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Iterable<SalesOrder>> getAll() {

        Iterable<SalesOrder> salesOrders = salesOrderService.getAllSalesOrder();

        return new ResponseEntity<Iterable<SalesOrder>>(salesOrders, HttpStatus.OK);
    }

    @RequestMapping(value = "/salesorders/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable Integer id) {

        salesOrderService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/salesorders", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<SalesOrder> updateSalesOrder(@RequestBody SalesOrder salesOrder) {

        salesOrderService.updateSalesOrder(salesOrder);

        return new ResponseEntity<SalesOrder>(salesOrder, HttpStatus.OK);
    }

}
