
import com.company.Entities.Business;
import com.company.Entities.Product;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class Tests {
    static EntityManager entityManager;

    @BeforeAll
    static void setup()
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");
        entityManager = emFactory.createEntityManager();
    }

    @Test  // FIND ALL BUSINESS IN CLUJ
    public void BusinessWithLocationInCluj()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Business> cq = cb.createQuery(Business.class);
        Root<Business> root = cq.from(Business.class);

        cq.select(root).where(cb.equal(root.get("location"),"Cluj"));


        var allBusinessesInCluj  = entityManager.createQuery(cq).getResultList();
        // businessRepository.findAll(HasLocationInCluj());
        allBusinessesInCluj.forEach(System.out::println);

        assert(allBusinessesInCluj.size() > 0);
    }

    @Test
    public void FindAllCurrenciesForProduct()
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root.get("currency")).distinct(true).where(cb.equal(root.get("name"),"Produs1"));

        var results = entityManager.createQuery(cq).getResultList();
        results.forEach(System.out::println);

        assert (results.size() > 0);
    }



}