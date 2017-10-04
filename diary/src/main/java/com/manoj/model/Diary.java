package com.manoj.model;

import javax.persistence.*;
import java.time.*;
import java.util.*;
        
@Entity
@Table(name="diary")
public class Diary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Event_id")
	private int event_id;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="title")
	private String title;
	
	@Column(name="Description")
	private String desc;

	@Column(name="Person_id")
	private int person_id;
	
	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
