package com.skyloken.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private Integer id;

	private String text;

	private Boolean is_done;

	public Todo(){
		super();
	}

	public Todo(String text, Boolean is_done){
		super();
		this.text = text;
		this.is_done= is_done;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setIs_done(Boolean is_done) {
		this.is_done = is_done;
	}
	
	public Boolean getIs_done() {
		return is_done;
	}

}
