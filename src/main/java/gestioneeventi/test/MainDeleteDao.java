package gestioneeventi.test;

import gestioneeventi.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDeleteDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO dao = new EventoDAO(em);
        dao.delete(3L);

        em.close();
        emf.close();
    }
}
