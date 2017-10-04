package com.manoj.dao;

import com.manoj.dao.*;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.manoj.model.*;
import com.manoj.service.PersonService;

@Repository
public class PersonDao {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDao.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

//	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

//	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
//	@Override
	public List<Person> listPerson() {
		System.out.println("2. ");
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("3. ");
		List<Person> personList = session.createQuery("from Person").list();
		System.out.println(personList);
		for(Person p : personList){
			logger.info("Person List::"+p);
		}
		return personList;
	}

//	@Override
	public Person displayPerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Diary loaded successfully, diary details="+p);
		return p;
	}

//	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Diary deleted successfully, diary details="+p);
	}

} 