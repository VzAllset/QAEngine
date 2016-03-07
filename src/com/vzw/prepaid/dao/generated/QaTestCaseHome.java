// default package
// Generated Mar 1, 2016 4:05:52 PM by Hibernate Tools 4.3.1.Final
package com.vzw.prepaid.dao.generated;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.vzw.prepaid.dao.BaseDAO;

/**
 * Home object for domain model class QaTestCase.
 * @see .QaTestCase
 * @author Hibernate Tools
 */
public class QaTestCaseHome  extends BaseDAO {

	private static final Log log = LogFactory.getLog(QaTestCaseHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	/*protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}*/

	public void persist(QaTestCase transientInstance) {
		log.debug("persisting QaTestCase instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QaTestCase instance) {
		log.debug("attaching dirty QaTestCase instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QaTestCase instance) {
		log.debug("attaching clean QaTestCase instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QaTestCase persistentInstance) {
		log.debug("deleting QaTestCase instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QaTestCase merge(QaTestCase detachedInstance) {
		log.debug("merging QaTestCase instance");
		try {
			QaTestCase result = (QaTestCase) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QaTestCase findById(long id) {
		log.debug("getting QaTestCase instance with id: " + id);
		try {
			QaTestCase instance = (QaTestCase) sessionFactory.getCurrentSession().get("com.vzw.prepaid.dao.generated.QaTestCase", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(QaTestCase instance) {
		log.debug("finding QaTestCase instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("QaTestCase").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
