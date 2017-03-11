package pl.itse.thread.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import pl.itse.thread.model.Email;

@Component
@Transactional
public class EmailDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void create(Email entity) {
		entityManager.persist(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Email> findAll() {

		return entityManager.createQuery("from " + Email.class.getName()).getResultList();		
	}

}
