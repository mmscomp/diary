package com.manoj.daoImpl;

import com.manoj.dao.*;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.manoj.model.*;;

@Repository
public class DiaryImpl implements DiaryDao {
	
	private static final Logger logger = LoggerFactory.getLogger(DiaryImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

//	@Override
	public void addDiary(Diary d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(d);
		logger.info("Diary saved successfully, Diary Details="+d);
	}

//	@Override
	public void updateDiary(Diary d) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(d);
		logger.info("Diary updated successfully, Diary Details="+d);
	}

	@SuppressWarnings("unchecked")
//	@Override
	public List<Diary> listDiary() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Diary> diaryList = session.createQuery("from Diary").list();
		for(Diary d : diaryList){
			logger.info("Diary List::"+d);
		}
		return diaryList;
	}
 
	@SuppressWarnings("unchecked")
	public List<Diary> listDiary1(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Diary> diaryList = session.createQuery("from Diary where person_id='"+id+"'").list();
		for(Diary d : diaryList){
			d.setPerson_id(id);
			logger.info("Diary List::"+d);
		}
		return diaryList;
	}


//	@Override 
	public Diary displayDiary(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Diary d = (Diary) session.load(Diary.class, new Integer(id));
		logger.info("Diary loaded successfully, diary details="+d);
		return d;
	}

//	@Override
	public void removeDiary(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Diary d = (Diary) session.load(Diary.class, new Integer(id));
		if(null != d){
			session.delete(d);
		}
		logger.info("Diary deleted successfully, diary details="+d);
	}

} 