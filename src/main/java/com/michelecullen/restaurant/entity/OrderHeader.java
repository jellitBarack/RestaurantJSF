/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.michelecullen.restaurant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author michelecullen
 */
@Entity
@Table(name = "order_header")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHeader.findAll", query = "SELECT o FROM OrderHeader o"),
    @NamedQuery(name = "OrderHeader.findByOrderHeaderId", query = "SELECT o FROM OrderHeader o WHERE o.orderHeaderId = :orderHeaderId"),
    @NamedQuery(name = "OrderHeader.findByOrderDate", query = "SELECT o FROM OrderHeader o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "OrderHeader.findByOrderTax", query = "SELECT o FROM OrderHeader o WHERE o.orderTax = :orderTax"),
    @NamedQuery(name = "OrderHeader.findByOrderSubtotal", query = "SELECT o FROM OrderHeader o WHERE o.orderSubtotal = :orderSubtotal"),
    @NamedQuery(name = "OrderHeader.findByOrderTotal", query = "SELECT o FROM OrderHeader o WHERE o.orderTotal = :orderTotal"),
    @NamedQuery(name = "OrderHeader.findByCustLastName", query = "SELECT o FROM OrderHeader o WHERE o.custLastName = :custLastName"),
    @NamedQuery(name = "OrderHeader.findByCustFirstName", query = "SELECT o FROM OrderHeader o WHERE o.custFirstName = :custFirstName"),
    @NamedQuery(name = "OrderHeader.findByOrderHeadercol", query = "SELECT o FROM OrderHeader o WHERE o.orderHeadercol = :orderHeadercol")})
public class OrderHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_header_id")
    private Integer orderHeaderId;
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "order_tax")
    private BigDecimal orderTax;
    @Column(name = "order_subtotal")
    private BigDecimal orderSubtotal;
    @Column(name = "order_total")
    private BigDecimal orderTotal;
    @Size(max = 30)
    @Column(name = "cust_last_name")
    private String custLastName;
    @Size(max = 30)
    @Column(name = "cust_first_name")
    private String custFirstName;
    @Size(max = 45)
    @Column(name = "order_headercol")
    private String orderHeadercol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderHeader")
    private Collection<OrderDetails> orderDetailsCollection;

    public OrderHeader() {
    }

    public OrderHeader(Integer orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public Integer getOrderHeaderId() {
        return orderHeaderId;
    }

    public void setOrderHeaderId(Integer orderHeaderId) {
        this.orderHeaderId = orderHeaderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(BigDecimal orderTax) {
        this.orderTax = orderTax;
    }

    public BigDecimal getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(BigDecimal orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getOrderHeadercol() {
        return orderHeadercol;
    }

    public void setOrderHeadercol(String orderHeadercol) {
        this.orderHeadercol = orderHeadercol;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderHeaderId != null ? orderHeaderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHeader)) {
            return false;
        }
        OrderHeader other = (OrderHeader) object;
        if ((this.orderHeaderId == null && other.orderHeaderId != null) || (this.orderHeaderId != null && !this.orderHeaderId.equals(other.orderHeaderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.michelecullen.restaurant.entity.OrderHeader[ orderHeaderId=" + orderHeaderId + " ]";
    }
    
}
