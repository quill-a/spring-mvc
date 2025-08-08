package dev.quilla.springmvc;

import dev.quilla.springmvc.model.Alien;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlienDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Alien> getAliens() {
        Session session = sessionFactory.getCurrentSession();
        List<Alien> aliens = session.createQuery("from Alien", Alien.class).list();

        return aliens;
    }

    @Transactional
    public void addAlien(Alien alien) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(alien);
    }

    @Transactional
    public Alien getAlien(int id) {

        Session session = sessionFactory.getCurrentSession();
        Alien alien = session.find(Alien.class, id);

        return alien;
    }
}
