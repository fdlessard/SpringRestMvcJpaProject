package com.lessard.codesamples.order.services;

import com.lessard.codesamples.order.domain.SalesOrder;
import com.lessard.codesamples.order.repositories.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by fdlessard on 16-07-29.
 */
@Component
public class SalesOrderService {

    private SalesOrderRepository salesOrderRepository;


    public SalesOrderService() {
    }

    @Autowired
    public SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    public void createSalesOrder(SalesOrder salesOrder) {

        salesOrderRepository.save(salesOrder);
    }

    public SalesOrder getSalesOrder(Integer id) {
        SalesOrder salesOrder = salesOrderRepository.findByPrimaryKey(id);
        return salesOrder;
    }

    public Iterable<SalesOrder> getAllSalesOrder() {

        Iterable<SalesOrder> salesOrders = salesOrderRepository.findAll();

        return salesOrders;
    }


    public void delete(Integer id) {

        salesOrderRepository.delete(id);

    }

    public void updateSalesOrder(SalesOrder salesOrder) {

        salesOrderRepository.update(salesOrder);

    }

}
