package com.YooFood.mongo.service;

import org.springframework.data.geo.GeoResults;

import com.YooFood.mongo.entity.Publicaciones;
import com.YooFood.mongo.model.DireccionModel;

public interface DireccionesService {

	public abstract GeoResults<Publicaciones> geoNear(DireccionModel dir);
}
