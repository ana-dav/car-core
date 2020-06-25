package car.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import car.dao.interfaces.GenericDao;
import car.lib.Dao;
import car.model.Car;
import car.model.CarDoor;
import car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataProcessingException;

@Dao
public class CarDaoImpl implements GenericDao<Car> {
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
