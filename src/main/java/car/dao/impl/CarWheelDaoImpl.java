package car.dao.impl;

import car.dao.interfaces.GenericDao;
import car.model.CarWheel;
import car.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataProcessingException;

public class CarWheelDaoImpl implements GenericDao<CarWheel> {
    @Override
    public CarWheel add(CarWheel carWheel) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carWheel);
            transaction.commit();
            return carWheel;
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
    public List<CarWheel> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<CarWheel> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarWheel.class);
            criteriaQuery.from(CarWheel.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all cars ", e);
        }
    }
}
