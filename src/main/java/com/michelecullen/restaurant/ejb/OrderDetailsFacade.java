/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.michelecullen.restaurant.ejb;

import com.michelecullen.restaurant.entity.OrderDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author michelecullen
 */
@Stateless
public class OrderDetailsFacade extends AbstractFacade<OrderDetails> {
    @PersistenceContext(unitName = "com.michelecullen_restaurant_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderDetailsFacade() {
        super(OrderDetails.class);
    }
    
}
