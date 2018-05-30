package com.crizen.guest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="guestbook")
public class Guestbook {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer no;

	@Column(name="name", nullable=false, length=100)
	private String name;

	@Column(name="pwd", nullable=false, length=64)
	private String pwd;

	@Column(name="message", nullable=false)
	private String message;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_date")
	private Date regDate;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
