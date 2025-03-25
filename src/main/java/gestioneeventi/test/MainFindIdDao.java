package gestioneeventi.test;

import gestioneeventi.Evento;
import gestioneeventi.EventoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainFindIdDao {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO dao = new EventoDAO(em);
        Evento evento = dao.getById(1L);
        System.out.println("L'evento trovato: " + evento.getTitolo() + " e di tipo: " + evento.getTipoEvento() + " in data: " + evento.getDataEvento());

        em.close();
        emf.close();
    }
}
