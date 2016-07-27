package com.lessard.codesamples.order.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "sales_order")
public class SalesOrder implements Serializable {

    @Id
    @Column(name="id")
	private Integer id;

    @Column(name="description", length=25)
	private String description;

    @Column(name="date", length=25)
	private String date;

	public SalesOrder() {

	}

    public SalesOrder(Integer id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrder)) return false;

        SalesOrder salesOrder = (SalesOrder) o;

        if (!id.equals(salesOrder.id)) return false;
        if (description != null ? !description.equals(salesOrder.description) : salesOrder.description != null) return false;
        return date != null ? date.equals(salesOrder.date) : salesOrder.date == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
