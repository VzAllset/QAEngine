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
 * Home object for domain model class QaResult.
 * @see .QaResult
 * @author Hibernate Tools
 */
public class QaResultHome  extends BaseDAO {

	private static final Log log = LogFactory.getLog(QaResultHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	/*protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}*/

	public void persist(QaResult transientInstance) {
		log.debug("persisting QaResult instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QaResult instance) {
		log.debug("attaching dirty QaResult instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QaResult instance) {
		log.debug("attaching clean QaResult instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QaResult persistentInstance) {
		log.debug("deleting QaResult instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QaResult merge(QaResult detachedInstance) {
		log.debug("merging QaResult instance");
		try {
			QaResult result = (QaResult) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QaResult findById(long id) {
		log.debug("getting QaResult instance with id: " + id);
		try {
			QaResult instance = (QaResult) sessionFactory.getCurrentSession().get("QaResult", id);
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

	public List findByExample(QaResult instance) {
		log.debug("finding QaResult instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("QaResult").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
