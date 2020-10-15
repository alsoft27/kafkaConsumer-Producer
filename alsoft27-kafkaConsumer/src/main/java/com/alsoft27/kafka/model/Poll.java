package com.alsoft27.kafka.model;

import java.util.Date;

public class Poll {

	private String id;

	private String name;

	private String address;

	private Date date;

	private String description;

	public Poll() {
	}

	@Override
	public String toString() {
		return "Poll [id=" + id + ", name=" + name + ", address=" + address + ", date=" + date + ", description="
				+ description + "]";
	}

	public Poll(String id, String name, String address, Date date, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.date = date;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
