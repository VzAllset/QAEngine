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
 * Home object for domain model class QaDepData.
 * @see .QaDepData
 * @author Hibernate Tools
 */
public class QaDepDataHome  extends BaseDAO {

	private static final Log log = LogFactory.getLog(QaDepDataHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	/*protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}*/

	public void persist(QaDepData transientInstance) {
		log.debug("persisting QaDepData instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QaDepData instance) {
		log.debug("attaching dirty QaDepData instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QaDepData instance) {
		log.debug("attaching clean QaDepData instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QaDepData persistentInstance) {
		log.debug("deleting QaDepData instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QaDepData merge(QaDepData detachedInstance) {
		log.debug("merging QaDepData instance");
		try {
			QaDepData result = (QaDepData) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QaDepData findById(QaDepDataId id) {
		log.debug("getting QaDepData instance with id: " + id);
		try {
			QaDepData instance = (QaDepData) sessionFactory.getCurrentSession().get("QaDepData", id);
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

	public List findByExample(QaDepData instance) {
		log.debug("finding QaDepData instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("QaDepData").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
