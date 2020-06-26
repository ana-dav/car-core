package com.car.dao.impl;

import com.car.dao.interfaces.CarDao;
import com.car.lib.Dao;
import com.car.model.Car;
import com.car.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataProcessingException;

@Log
@Dao
public class CarDaoImpl implements CarDao {
    @Override
    public Car add(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Transaction failed");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Car> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Car> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(Car.class);
            criteriaQuery.from(Car.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all cars ", e);
        }
    }
}
