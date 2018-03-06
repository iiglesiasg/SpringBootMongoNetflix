package com.YooFood.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.YooFood.mongo.entity.ComentarioEntity;
import com.YooFood.mongo.entity.Publicaciones;
import com.YooFood.mongo.model.DireccionModel;
import com.YooFood.mongo.repository.ComentariosRepository;

@CrossOrigin
@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

	@Autowired
    private ComentariosRepository comentariosRepository;
	
	@CrossOrigin
	@RequestMapping(value = "/user/{user}", method = RequestMethod.GET)
    public @ResponseBody List<ComentarioEntity> buscarXUser(@PathVariable java.lang.String user){
		List<ComentarioEntity> comentarios = comentariosRepository.findByUsrname(user);
        return comentarios;
    } 
	
	@CrossOrigin
	@RequestMapping(value = "/publicacion/{publicacion}", method = RequestMethod.GET)
    public @ResponseBody List<ComentarioEntity> buscarXPublicacion(@PathVariable java.lang.String publicacion){
		List<ComentarioEntity> comentarios = comentariosRepository.findByPublicacion(publicacion);
        return comentarios;
    } 
	
	@CrossOrigin
	@RequestMapping(value = "/comentario/{comentario}", method = RequestMethod.GET)
    public @ResponseBody ComentarioEntity buscarXId(@PathVariable java.lang.String comentario){
		ComentarioEntity c = comentariosRepository.findById(comentario);
        return c;
    } 
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ComentarioEntity guardarComentario(@RequestBody ComentarioEntity comentario){
		ComentarioEntity p = comentariosRepository.save(comentario);
		
        return p;
    }
	
	@CrossOrigin
	@RequestMapping(value = "/like/", method = RequestMethod.POST)
    public @ResponseBody ComentarioEntity darLike(@RequestBody ComentarioEntity comentario){
		comentario.setLikes(comentario.getLikes()+1);
		ComentarioEntity p = comentariosRepository.save(comentario);		
        return p;
    }
}
