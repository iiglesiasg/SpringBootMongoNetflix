package com.YooFood.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.GeoResults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.YooFood.mongo.entity.Publicaciones;
import com.YooFood.mongo.model.DireccionModel;
import com.YooFood.mongo.service.DireccionesService;

@CrossOrigin
@RestController
@RequestMapping("/direcciones")
public class DireccionesController {

	@Autowired
    @Qualifier("direccionesServiceImpl")
    private DireccionesService direccionesService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
    public @ResponseBody GeoResults<Publicaciones> buquedaPorDireccion(@RequestBody DireccionModel dir){
		GeoResults<Publicaciones> p = direccionesService.geoNear(dir);
		
        return p;
    }
}
