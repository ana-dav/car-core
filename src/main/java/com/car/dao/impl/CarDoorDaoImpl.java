package com.car.dao.impl;

import com.car.dao.interfaces.CarDoorDao;
import com.car.lib.Dao;
import com.car.model.CarDoor;
import com.car.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataProcessingException;

@Log
@Dao
public class CarDoorDaoImpl implements CarDoorDao {
    @Override
    public CarDoor add(CarDoor carDoor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carDoor);
            transaction.commit();
            return carDoor;
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
    public List<CarDoor> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<CarDoor> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarDoor.class);
            criteriaQuery.from(CarDoor.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all cars ", e);
        }
    }
}
