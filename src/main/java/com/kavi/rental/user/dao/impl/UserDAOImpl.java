package com.kavi.rental.user.dao.impl;

import com.kavi.rental.user.dao.UserDAO;
import com.kavi.rental.user.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public User create(User user) {
        Integer newId = (Integer) getSession().save(user);
        return getSession().get(User.class, newId);
    }

    @Override
    public User get(int id) {
        return getSession().get(User.class, id);
    }

    @Override
    public List<User> get() {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.from(User.class);

        return getSession().createQuery(cq).getResultList();
    }

    @Override
    public User getByName(String name) {
        CriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.where(cb.equal(root.get(User.NAME), name));

        return Optional.ofNullable(getSession().createQuery(cq).uniqueResult()).orElse(null);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
