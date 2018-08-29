package com.site.StickyBoard;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="stickynote")
public class StickyNote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public int id;
	
	@DateTimeFormat(pattern = "MM-DD-YYYY hh:mm:ss")
	@Column(name = "datecreated")
	public Date dateCreated;
}
