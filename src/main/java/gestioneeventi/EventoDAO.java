package gestioneeventi;

import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

//    public void save(List<Evento> eventi) {
//        em.getTransaction().begin();
//
//        for (Evento evento : eventi) {
//            em.persist(evento);
//        }
//
//        em.getTransaction().commit();
//    }

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Long id) {
        Evento evento = em.find(Evento.class, id);
        if (evento != null) {
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
            System.out.println("Evento deleted: " + evento.getTitolo());
        } else {
            System.out.println("Evento with ID " + id + " not found.");
        }
    }
}
