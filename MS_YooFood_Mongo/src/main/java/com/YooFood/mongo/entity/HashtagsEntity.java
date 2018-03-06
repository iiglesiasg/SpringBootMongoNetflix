package com.YooFood.mongo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hashtags")
public class HashtagsEntity implements Serializable{

	@Id
	private String hashtag;
	
	public HashtagsEntity() {
		// TODO Auto-generated constructor stub
	}
	public String getHashtag() {
		return hashtag;
	}
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	
}
