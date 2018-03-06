package com.YooFood.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.YooFood.mongo.entity.ComentarioEntity;

public interface ComentariosRepository extends MongoRepository<ComentarioEntity, String> {

	List<ComentarioEntity> findByUsrname(String usr_name);
	List<ComentarioEntity> findByPublicacion(String publicacion);
	ComentarioEntity findById(String id);
	ComentarioEntity save(ComentarioEntity comentario);
}
