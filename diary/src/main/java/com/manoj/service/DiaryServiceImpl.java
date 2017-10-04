package com.manoj.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;

import com.manoj.dao.DiaryDao;
import com.manoj.model.Diary;

@Service
public class DiaryServiceImpl implements DiaryService {
	
	private DiaryDao diaryDao;

	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}

//	@Override
	@Transactional
	public void addDiary(Diary d) {
		this.diaryDao.addDiary(d);
	}

	//@Override
	@Transactional
	public void updateDiary(Diary d) {
		this.diaryDao.updateDiary(d);
	}

	//@Override
	@Transactional
	public List<Diary> listDiary() {
		return this.diaryDao.listDiary();
	}

	@Transactional
	public List<Diary> listDiary1(int id) {
		return this.diaryDao.listDiary1(id);
	}

 	
	//@Override
	@Transactional
	public Diary displayDiary(int id) {
		return this.diaryDao.displayDiary(id);
	}

	//@Override
	@Transactional
	public void removeDiary(int id) {
		this.diaryDao.removeDiary(id);
	}

}