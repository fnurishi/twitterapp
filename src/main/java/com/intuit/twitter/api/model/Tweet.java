package com.intuit.twitter.api.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tweet")
public class Tweet {

	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private Integer user_id;
	
	@Column
	private String message;
	@Column
	private Timestamp create_time;
	
	@Override
	public String toString() {
		return "Tweet [id=" + id + ", user_id=" + user_id + ", message=" + message + ", create_time=" + create_time +"]";
	}
	
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Timestamp getCreate_time() {
			return create_time;
		}
		public void setCreate_time(Timestamp create_time) {
			this.create_time = create_time;
		}
	
}
