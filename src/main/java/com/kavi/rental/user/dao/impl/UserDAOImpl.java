package com.kavi.rental.user.dao.impl;

import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public User create(User user) {
        Integer newid = (Integer) getSession().save(user);
        return getSession().get(User.class, newid);
    }

    @Override
    public User get(int id) {
        return getSession().get(User.class, id);
    }

    @Override
    public List<User> get() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);

        TypedQuery<User> allQuery = getSession().createQuery(all);
        return allQuery.getResultList();
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
