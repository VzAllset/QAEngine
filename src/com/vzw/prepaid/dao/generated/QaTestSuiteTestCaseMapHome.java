// default package
package com.vzw.prepaid.dao.generated;
// Generated Mar 1, 2016 4:05:52 PM by Hibernate Tools 4.3.1.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.vzw.prepaid.dao.BaseDAO;

/**
 * Home object for domain model class QaTestSuiteTestCaseMap.
 * @see .QaTestSuiteTestCaseMap
 * @author Hibernate Tools
 */
public class QaTestSuiteTestCaseMapHome  extends BaseDAO {

	private static final Log log = LogFactory.getLog(QaTestSuiteTestCaseMapHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	/*protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}*/

	public void persist(QaTestSuiteTestCaseMap transientInstance) {
		log.debug("persisting QaTestSuiteTestCaseMap instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QaTestSuiteTestCaseMap instance) {
		log.debug("attaching dirty QaTestSuiteTestCaseMap instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QaTestSuiteTestCaseMap instance) {
		log.debug("attaching clean QaTestSuiteTestCaseMap instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QaTestSuiteTestCaseMap persistentInstance) {
		log.debug("deleting QaTestSuiteTestCaseMap instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QaTestSuiteTestCaseMap merge(QaTestSuiteTestCaseMap detachedInstance) {
		log.debug("merging QaTestSuiteTestCaseMap instance");
		try {
			QaTestSuiteTestCaseMap result = (QaTestSuiteTestCaseMap) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QaTestSuiteTestCaseMap findById(long id) {
		log.debug("getting QaTestSuiteTestCaseMap instance with id: " + id);
		try {
			QaTestSuiteTestCaseMap instance = (QaTestSuiteTestCaseMap) sessionFactory.getCurrentSession()
					.get("QaTestSuiteTestCaseMap", id);
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

	public List findByExample(QaTestSuiteTestCaseMap instance) {
		log.debug("finding QaTestSuiteTestCaseMap instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("QaTestSuiteTestCaseMap")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
