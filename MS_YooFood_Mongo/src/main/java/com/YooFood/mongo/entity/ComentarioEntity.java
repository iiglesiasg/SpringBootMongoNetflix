package com.YooFood.mongo.entity;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "comentarios")
public class ComentarioEntity implements Serializable{

	@Id
	private String id;
	private String usrname;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss",timezone = "GMT-05:00")
	private Date fecha;
	
	private String comentario;
	private String publicacion;
	private String comentarioOrigen;
	private Integer likes;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}
	public String getComentarioOrigen() {
		return comentarioOrigen;
	}
	public void setComentarioOrigen(String comentarioOrigen) {
		this.comentarioOrigen = comentarioOrigen;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	
	
}
