package com.YooFood.mongo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.YooFood.mongo.model.DireccionModel;
import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "publicaciones")
public class Publicaciones implements Serializable{

	@Id
	private String id;
	private String usrname;
	private String usr_photo;	
	private String url_photo;
	private Integer likes;
	private Integer phttype;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss",timezone = "GMT-05:00")
	private Date pht_date;
	
	private String pht_name;
	private String pht_description;
	private Boolean pht_liked;
	private List<String> pht_comments;
	private List<String> hashtags;
	private DireccionModel dir;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getUsr_photo() {
		return usr_photo;
	}
	public void setUsr_photo(String usr_photo) {
		this.usr_photo = usr_photo;
	}

	public String getUrl_photo() {
		return url_photo;
	}
	public void setUrl_photo(String url_photo) {
		this.url_photo = url_photo;
	}

	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer pht_likes) {
		this.likes = pht_likes;
	}
	
	public Integer getPhttype() {
		return phttype;
	}
	public void setPhttype(Integer phttype) {
		this.phttype = phttype;
	}
	public Date getPht_date() {
		return pht_date;//new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(pht_date);
	}
	public void setPht_date(Date pht_date) {
		this.pht_date = pht_date;
	}
	public String getPht_name() {
		return pht_name;
	}
	public void setPht_name(String pht_name) {
		this.pht_name = pht_name;
	}
	public String getPht_description() {
		return pht_description;
	}
	public void setPht_description(String pht_description) {
		this.pht_description = pht_description;
	}	
	public Boolean getPht_liked() {
		return pht_liked;
	}
	public void setPht_liked(Boolean pht_liked) {
		this.pht_liked = pht_liked;
	}
	public List<String> getPht_comments() {
		return pht_comments;
	}
	public void setPht_comments(List<String> pht_comments) {
		this.pht_comments = pht_comments;
	}
	public List<String> getHashtags() {
		return hashtags;
	}
	public void setHashtags(List<String> hashtags) {
		this.hashtags = hashtags;
	}
	public DireccionModel getDir() {
		return dir;
	}
	public void setDir(DireccionModel dir) {
		this.dir = dir;
	}
		
}
