/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.controllers;

import com.dexdevs.controllers.exceptions.NonexistentEntityException;
import com.dexdevs.model.Customer;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.dexdevs.model.Sale;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Moieen
 */
public class CustomerJpaController implements Serializable {

    public CustomerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Customer customer) {
        if (customer.getSales() == null) {
            customer.setSales(new ArrayList<Sale>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Sale> attachedSales = new ArrayList<Sale>();
            for (Sale salesSaleToAttach : customer.getSales()) {
                salesSaleToAttach = em.getReference(salesSaleToAttach.getClass(), salesSaleToAttach.getId());
                attachedSales.add(salesSaleToAttach);
            }
            customer.setSales(attachedSales);
            em.persist(customer);
            for (Sale salesSale : customer.getSales()) {
                Customer oldCustomerOfSalesSale = salesSale.getCustomer();
                salesSale.setCustomer(customer);
                salesSale = em.merge(salesSale);
                if (oldCustomerOfSalesSale != null) {
                    oldCustomerOfSalesSale.getSales().remove(salesSale);
                    oldCustomerOfSalesSale = em.merge(oldCustomerOfSalesSale);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Customer customer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer persistentCustomer = em.find(Customer.class, customer.getId());
            List<Sale> salesOld = persistentCustomer.getSales();
            List<Sale> salesNew = customer.getSales();
            List<Sale> attachedSalesNew = new ArrayList<Sale>();
            for (Sale salesNewSaleToAttach : salesNew) {
                salesNewSaleToAttach = em.getReference(salesNewSaleToAttach.getClass(), salesNewSaleToAttach.getId());
                attachedSalesNew.add(salesNewSaleToAttach);
            }
            salesNew = attachedSalesNew;
            customer.setSales(salesNew);
            customer = em.merge(customer);
            for (Sale salesOldSale : salesOld) {
                if (!salesNew.contains(salesOldSale)) {
                    salesOldSale.setCustomer(null);
                    salesOldSale = em.merge(salesOldSale);
                }
            }
            for (Sale salesNewSale : salesNew) {
                if (!salesOld.contains(salesNewSale)) {
                    Customer oldCustomerOfSalesNewSale = salesNewSale.getCustomer();
                    salesNewSale.setCustomer(customer);
                    salesNewSale = em.merge(salesNewSale);
                    if (oldCustomerOfSalesNewSale != null && !oldCustomerOfSalesNewSale.equals(customer)) {
                        oldCustomerOfSalesNewSale.getSales().remove(salesNewSale);
                        oldCustomerOfSalesNewSale = em.merge(oldCustomerOfSalesNewSale);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = customer.getId();
                if (findCustomer(id) == null) {
                    throw new NonexistentEntityException("The customer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Customer customer;
            try {
                customer = em.getReference(Customer.class, id);
                customer.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The customer with id " + id + " no longer exists.", enfe);
            }
            List<Sale> sales = customer.getSales();
            for (Sale salesSale : sales) {
                salesSale.setCustomer(null);
                salesSale = em.merge(salesSale);
            }
            em.remove(customer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Customer> findCustomerEntities() {
        return findCustomerEntities(true, -1, -1);
    }

    public List<Customer> findCustomerEntities(int maxResults, int firstResult) {
        return findCustomerEntities(false, maxResults, firstResult);
    }

    private List<Customer> findCustomerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Customer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer findCustomer(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    public int getCustomerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Customer> rt = cq.from(Customer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
