package com.intuit.twitter.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_follow")
public class Follow {

	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer user_id;
	@Column
	private Integer follow_user_id;

	public Integer getFollow_user_id() {
		return follow_user_id;
	}
	public void setFollow_user_id(Integer follow_user_id) {
		this.follow_user_id = follow_user_id;
	}
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}		
}
