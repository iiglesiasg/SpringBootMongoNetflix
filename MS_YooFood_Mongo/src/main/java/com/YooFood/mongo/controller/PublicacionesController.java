package com.YooFood.mongo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.YooFood.mongo.entity.HashtagsEntity;
import com.YooFood.mongo.entity.Publicaciones;  
import com.YooFood.mongo.repository.PublicacionesRepository;
import com.YooFood.mongo.service.HashtagsService;

@CrossOrigin
@RestController
@RequestMapping("/publicaciones")
public class PublicacionesController {

	@Autowired
    private PublicacionesRepository publicacionesRepository;
	
	@Autowired
    @Qualifier("hashtagServiceImpl")
    private HashtagsService hashtagServiceImpl;
	
	@CrossOrigin
	@RequestMapping(value = "/localizacion/{localizacion}", method = RequestMethod.GET)
    public @ResponseBody List<Publicaciones> buscarXlocalizacion(@PathVariable java.lang.String localizacion){
		List<Publicaciones> publicacion = publicacionesRepository.findByDir_Codlocation(localizacion);
        return publicacion;
    }  
	
	@CrossOrigin
	@RequestMapping(value = "/user/{user}", method = RequestMethod.GET)
    public @ResponseBody List<Publicaciones> buscarXUsuario(@PathVariable java.lang.String user){
		List<Publicaciones> publicacion = publicacionesRepository.findByUsrname(user);
        return publicacion;
    } 
	
	@CrossOrigin
	@RequestMapping(value = "/distrito/{distrito}", method = RequestMethod.GET)
    public @ResponseBody List<Publicaciones> buscarXDistrito(@PathVariable java.lang.String distrito){
		List<Publicaciones> publicacion = publicacionesRepository.findByDir_Distrito(distrito);
        return publicacion;
    } 
	
	@CrossOrigin
	@RequestMapping(value = "/guardar/",method = RequestMethod.POST)
	public Publicaciones post(@RequestBody Publicaciones publicacion,
			UriComponentsBuilder ucBuilder) {
		
		System.out.println("Guardando Publicacion");	
		// direccion de google maps en base a lng y lat
/*		if(publicacion.getDir()!=null) {
			String urlGoogleMap="https://maps.googleapis.com/maps/api/geocode/json?latlng="+publicacion.getDir().getLocation().get(0).toString()+","+publicacion.getDir().getLocation().get(1).toString()+"&key=AIzaSyAAMM_wWZsi71PD7mzJTRF48U7X2NEL9pQ";
			RestTemplate restTemplate = new RestTemplate();
			GoogleMapsJson1Model result = restTemplate.getForObject(urlGoogleMap, GoogleMapsJson1Model.class);
			if(result.getStatus().equals("OK")) {
				publicacion.getDir().setNumero(result.getResults().get(0).getAddress_components().get(0).getLong_name());
				publicacion.getDir().setCalle(result.getResults().get(0).getAddress_components().get(1).getLong_name());
				publicacion.getDir().setDistrito(result.getResults().get(0).getAddress_components().get(2).getLong_name());
				publicacion.getDir().setLocalidad(result.getResults().get(0).getAddress_components().get(3).getLong_name());
				publicacion.getDir().setDepartamento(result.getResults().get(0).getAddress_components().get(4).getLong_name());
				publicacion.getDir().setPais(result.getResults().get(0).getAddress_components().get(5).getLong_name());
			}else {
				System.out.println("Error en API de google maps");
			}
				
		}*/
		
		List<HashtagsEntity> listHash = new ArrayList<HashtagsEntity>();
		if(publicacion.getHashtags()!=null) {
			System.out.println("Guardando Hashtags");
			for(String h:publicacion.getHashtags()) {
				HashtagsEntity hash=new HashtagsEntity();
				hash.setHashtag(h);
				listHash.add(hash);			
			}
			hashtagServiceImpl.save(listHash);
		}
		
		Publicaciones p = publicacionesRepository.save(publicacion);
		System.out.println("Publicacion "+p.getId()+" guardada");
		return p;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/imagen/{imagen}/publicacion/{publicacion}", method = RequestMethod.GET)
    public @ResponseBody Publicaciones actualizarImage(@PathVariable java.lang.String imagen,
    														 @PathVariable java.lang.String publicacion){
		Publicaciones p = publicacionesRepository.findById(publicacion);
		p.setUrl_photo(imagen);
		publicacionesRepository.save(p);
        return p;
    }
	
	@CrossOrigin
	@RequestMapping(value = "/hashtag/", method = RequestMethod.POST)
    public @ResponseBody List<Publicaciones> buquedaPorHashtag(@RequestBody List<String> hashtag){
		List<Publicaciones> p = publicacionesRepository.findAllByHashtagsContaining(hashtag);
		
        return p;
    }
	
	@CrossOrigin
	@RequestMapping(value = "/like/", method = RequestMethod.POST)
    public @ResponseBody Publicaciones darLike(@RequestBody Publicaciones publicacion){
		publicacion.setLikes(publicacion.getLikes()+1);
		Publicaciones p = publicacionesRepository.save(publicacion);		
        return p;
    }
}
