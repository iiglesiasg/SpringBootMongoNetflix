package com.YooFood.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.health.DiskSpaceHealthIndicator;
import org.springframework.boot.actuate.health.DiskSpaceHealthIndicatorProperties;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.YooFood.mongo.entity.HashtagsEntity;
import com.YooFood.mongo.entity.Publicaciones;
import com.YooFood.mongo.repository.HashtagsRepository;
import com.YooFood.mongo.repository.PublicacionesRepository;
import com.YooFood.mongo.service.HashtagsService;


@CrossOrigin
@RestController
@RequestMapping("/hashtags")
public class HashtagsController {

	@Autowired
    @Qualifier("hashtagServiceImpl")
    private HashtagsService hashtagServiceImpl;
	
	@Autowired
    private PublicacionesRepository publicacionesRepository;
	
	@Autowired
	private HashtagsRepository hashtagsRepository;
	
	@CrossOrigin
	@RequestMapping(value = "/guardar/",method = RequestMethod.POST)
	public String post(@RequestBody List<HashtagsEntity> hashtags,
			UriComponentsBuilder ucBuilder) {
		hashtagServiceImpl.save(hashtags);
		return "Hashtag guardado";
	}
	
	@CrossOrigin
	@RequestMapping( method = RequestMethod.POST)
    public @ResponseBody List<Publicaciones> buscarXparecido(@RequestBody List<String> hashtags){
		List<Publicaciones> publicacion = publicacionesRepository.findAllByHashtagsContaining(hashtags);
        return publicacion;
    }
	
	@CrossOrigin
	@RequestMapping( value = "/list/",method = RequestMethod.POST)
    public @ResponseBody List<HashtagsEntity> listarTodos(){
		List<HashtagsEntity> hashtags = hashtagsRepository.findAll();
        return hashtags;
    }
	
	@Bean
	HealthIndicator springYoFood() {
		return new HealthIndicator() {
			
			@Override
			public Health health() {
				// TODO Auto-generated method stub
				return Health.status("Hola Health YoFood")
				.withDetail("timeStamp", System.currentTimeMillis())
				.build();
				
			}
		};
		
	}
	
	@Bean
	DiskSpaceHealthIndicator espacioEnDisco() {
		return new DiskSpaceHealthIndicator(new DiskSpaceHealthIndicatorProperties());
		
	}
}
