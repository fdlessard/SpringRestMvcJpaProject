package io.fdlessard.codebites.order.repositories;


import io.fdlessard.codebites.order.domain.SalesOrder;

public interface SalesOrderRepository {

	SalesOrder findByPrimaryKey(Long id);

	Iterable<SalesOrder> findAll();

	void save(SalesOrder salesOrder);

	void delete(Long id);

	void update(SalesOrder salesOrder);
	
}
