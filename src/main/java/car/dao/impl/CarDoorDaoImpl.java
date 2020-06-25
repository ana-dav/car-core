package car.dao.impl;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import car.dao.interfaces.GenericDao;
import car.model.CarDoor;
import car.model.CarWheel;
import car.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataProcessingException;

public class CarDoorDaoImpl implements GenericDao<CarDoor> {
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
