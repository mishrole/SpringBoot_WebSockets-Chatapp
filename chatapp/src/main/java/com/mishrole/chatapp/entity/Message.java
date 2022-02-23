package com.mishrole.chatapp.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Message implements Serializable {
	
	private String content;
	private Date createdAt;
	
	private static final long serialVersionUID = 1095986755574711410L;
	
}
