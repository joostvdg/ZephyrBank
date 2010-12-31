package net.byonder.zephyrbank.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.byonder.zephyrbank.dao.BaseDao;
import org.apache.log4j.Logger;

/**
 * Base Dao Implementatie.
 * 
 * @author jvdgriendt
 */
public abstract class AbstractBaseDao<T> implements BaseDao<T> {

	@PersistenceContext(name = "ZephyrBank" )
	protected EntityManager entityManager;
	
	private Logger log;

	private final Class<T> clazz;

	protected AbstractBaseDao(Class<T> clazz) {
		this.clazz = clazz;
		this.log = Logger.getLogger(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.byonder.zephyrbank.dao.BaseDao#haalOp(long)
	 */
	@Override
	public T haalOp(long id) {
		log.info(String.format("Ophalen van een %s met id %d.",clazz.getSimpleName(), id  ));
		return entityManager.find(clazz, id);
	}

	/* (non-Javadoc)
	 * @see net.byonder.zephyrbank.dao.BaseDao#bewaar(java.lang.Object)
	 */
	@Override
	public boolean bewaar(T t) {
		log.info(String.format("Opslaan van een %s.",clazz.getSimpleName() ));
		entityManager.persist(t);
		return true;
	}

	/* (non-Javadoc)
	 * @see net.byonder.zephyrbank.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public boolean update(T t){
		log.info(String.format("Opslaan van een %s.",clazz.getSimpleName() ));
		entityManager.merge(t);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see net.byonder.zephyrbank.dao.BaseDao#vindAlle()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> vindAlle() {
		String className = clazz.getSimpleName();
		String classNameLower = clazz.getSimpleName().toLowerCase();
		log.info(String.format("Ophalen van een lijst met alle %s.",className));
		String queryString = String.format("SELECT %s FROM %s %s",classNameLower, className, classNameLower );
		Query query = entityManager.createQuery(queryString);
		List<T> lijst = (List<T>)query.getResultList();
		log.info(String.format("Aantal resultaten gevonden: %d.", lijst.size()));
		return lijst;
	}

	/* (non-Javadoc)
	 * @see net.byonder.zephyrbank.dao.BaseDao#vindAllePaged(net.byonder.zephyrbank.dao.impl.PagingInstructions)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> vindAllePaged(PagingInstructions pagingInstructions) {
		// TODO : nog geen pagingInstructions geimplementeerd
		String className = clazz.getSimpleName();
		String classNameLower = clazz.getSimpleName().toLowerCase();
		log.info(String.format("Ophalen van een lijst met alle %s.",className));
		String queryString = String.format("SELECT %s FROM %s %s",classNameLower, className, classNameLower );
		Query query = entityManager.createQuery(queryString);
		List<T> lijst = (List<T>)query.getResultList();
		log.info(String.format("Aantal resultaten gevonden: %d.", lijst.size()));
		return lijst;
	}

}
