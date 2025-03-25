package gestioneeventi.test;

import gestioneeventi.Evento;
import gestioneeventi.EventoDAO;
import gestioneeventi.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class MainInsertConDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        Evento evento1 = new Evento("meetup", LocalDate.now(), TipoEvento.PRIVATO, 50);
        Evento evento2 = new Evento("conferenza", LocalDate.now(), TipoEvento.PUBBLICO, 100);
        Evento evento3 = new Evento("workshop", LocalDate.now(), TipoEvento.PRIVATO, 20);

        EventoDAO dao = new EventoDAO(em);
//        dao.save(List.of(evento1, evento2, evento3));
        dao.save(evento1);
        dao.save(evento2);
        dao.save(evento3);

        System.out.println("Saved Events:");
        System.out.println("Evento 1 ID: " + evento1.getId());
        System.out.println("Evento 2 ID: " + evento2.getId());
        System.out.println("Evento 3 ID: " + evento3.getId());

        em.close();
        emf.close();
    }
}
