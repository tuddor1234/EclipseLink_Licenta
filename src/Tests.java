
import com.company.Entities.Business;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.eclipse.persistence.jpa.PersistenceProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class Tests {


    static EntityManager entityManager;

    @BeforeAll
    static void setup()
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("default");
        entityManager = emFactory.createEntityManager();
    }


    @Test
    void test1()
    {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Business> cq = criteriaBuilder.createQuery(Business.class);
//        Root<Business> root = cq.from(Business.class);
//
//        cq.select(root);

    //    var out = entityManager.createQuery(cq).getResultList();
//        out.forEach(System.out::println);
    try {
        var out = entityManager.createQuery( "SELECT * FROM business",Business.class).getResultList();

    }catch (Exception e)
    {
        assert(false);
    }


        assert (true);
    }


}