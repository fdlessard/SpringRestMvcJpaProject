package com.lessard.codesamples.order.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "sales_order")
public class SalesOrder implements Serializable {

    @Id @GeneratedValue
    @Column(name="id")
	private Integer id;

    @Column(name="description")
	private String description;

    @Column(name="date")
	private Date date;

    @Column(name="amount")
    private BigDecimal total;


    public SalesOrder() {
    }

    public SalesOrder(Integer id, String description, Date date, BigDecimal total) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.total = total;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrder)) return false;

        SalesOrder that = (SalesOrder) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }
}
