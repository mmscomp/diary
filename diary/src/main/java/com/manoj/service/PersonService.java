package com.manoj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import com.manoj.dao.PersonDao;
import com.manoj.model.Person;

@Service
public class PersonService  {
	
	private PersonDao personDao;

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

//	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDao.addPerson(p);
	}

	//@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDao.updatePerson(p);
	}

	//@Override
	@Transactional
	public List<Person> listPerson() {
		System.out.println("1. ");
		return this.personDao.listPerson();
	}

	//@Override
	@Transactional
	public Person displayPerson(int id) {
		return this.personDao.displayPerson(id);
	}

	//@Override
	@Transactional
	public void removePerson(int id) {
		this.personDao.removePerson(id);
	}

}