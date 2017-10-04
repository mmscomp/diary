package com.manoj.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.manoj.model.*;
import com.manoj.service.LoginService;

@Repository
public class LoginDao {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

//	@Override
	public void addLogin(Login p) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("8. "+p.getFirstName());
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

//	@Override
	public void updateLogin(Login l){
	Session session = this.sessionFactory.getCurrentSession();
		session.update(l);
		logger.info("Login updated successfully, Login Details="+l);
	}

	@SuppressWarnings("unchecked")
//	@Override
	public List<Login> loginListPerson() {
		System.out.println("2. ");
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("3. ");
		List<Login> loginList = session.createQuery("from Login").list();
		System.out.println(loginList);
		for(Login l : loginList){
			logger.info("Person List::"+l);
		}
		return loginList;
	}

//	@Override
/*	public Person displayPerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Diary loaded successfully, diary details="+p);
		return p;
	}
*/
//	@Override
	public void removeLogin(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Login l = (Login) session.load(Login.class, new Integer(id));
		if(null != l){
			session.delete(l);
		}
		logger.info("Diary deleted successfully, diary details="+l);
	}

} 