package com.manoj.service;

import com.manoj.model.Diary;
import java.util.*;

public interface DiaryService {
	
		
		public void addDiary(Diary d);
		
		public void updateDiary(Diary d);
		
		public Diary displayDiary(int id);
		
		public void removeDiary(int id);
		
		List<Diary> listDiary();

		List<Diary> listDiary1(int id);

	}



