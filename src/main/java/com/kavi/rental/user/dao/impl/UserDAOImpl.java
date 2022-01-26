package com.kavi.rental.user.dao.impl;

import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
//    private HibernateTemplate  sessionFactory;

    @Override
    public User create(User user) {
        Integer newid  = (Integer) getCurrentSession().save(user);
        return getCurrentSession().get(User.class, newid);
    }

    @Override
    public User get(int id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> get() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);

        TypedQuery<User> allQuery = getCurrentSession().createQuery(all);
        return allQuery.getResultList();
    }

    // @TODO: get rid of this since it opens lot of sessions
    protected Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
        return sessionFactory.openSession();
    }
}
