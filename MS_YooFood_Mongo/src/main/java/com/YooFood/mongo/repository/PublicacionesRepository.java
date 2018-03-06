package com.YooFood.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.YooFood.mongo.entity.Publicaciones;


public interface PublicacionesRepository extends MongoRepository<Publicaciones, String> {

	List<Publicaciones> findByUsrname(String usr_name);
	List<Publicaciones> findByDir_Codlocation(String codlocation);
	//Publicaciones insert(Publicaciones p);
	Publicaciones save(Publicaciones p);
	Publicaciones findById(String id);
	List<Publicaciones> findAllByHashtagsContaining(List<String> list);	
	List<Publicaciones> findByDir_Distrito(String distrito);
}
