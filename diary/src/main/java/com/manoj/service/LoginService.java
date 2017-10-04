package com.manoj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import com.manoj.dao.LoginDao;
import com.manoj.model.Login;

@Service
public class LoginService  {
	
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

//	@Override
	@Transactional
	public void addLogin(Login p) {
		this.loginDao.addLogin(p);
	}

	//@Override
	@Transactional
	public void updateLogin(Login l) {
		this.loginDao.updateLogin(l);
	}

	//@Override
	@Transactional
	public List<Login> loginListPerson() {
		System.out.println("1. ");
		return this.loginDao.loginListPerson();
	}

	//@Override
/*	@Transactional
	public Login displayLogin(int id) {
		return this.personDao.displayPerson(id);
	}*/

	//@Override
	@Transactional
	public void removeLogin(int id) {
		this.loginDao.removeLogin(id);
	}

}