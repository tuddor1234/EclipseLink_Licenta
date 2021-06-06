package com.company;

import com.company.Entities.Business;
import com.company.Entities.Product;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Main {

    public static void main(String[] args) {
	// write your code here

        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");
        var entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

//        var cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Business> cq = cb.createQuery(Business.class);
//        Root<Business> root = cq.from(Business.class);
//
//        cq.select(root);
//
//        var out = entityManager.createQuery(cq);
//        var out2 = out.getResultList();
//
//        out2.forEach(System.out::println);

//        Business business = new Business("NewName","123","Timisoara","2131451");
//        entityManager.persist(business);

          Product p1 = new Product();
          p1.setName("Produs1");
          p1.setDescription("SomeGrate super awesome description");
          p1.setPrice(123);
          p1.setCurrency("EUR");
          p1.setAvailability("Available");
          p1.setShippingArea(14);

          Product p2 = new Product();
          p2.setDescription("SomeGrate ptheadp[k;'daso super awesome description");
          p2.setName("Produs2");
          p2.setPrice(5);
          p2.setCurrency("EUR");
          p2.setAvailability("UnAvailable");
          p2.setShippingArea(14);


          entityManager.persist(p1);
          entityManager.persist(p2);




        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
