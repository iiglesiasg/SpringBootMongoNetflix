package com.YooFood.mongo.service.impl;
import java.util.Arrays;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import com.YooFood.mongo.entity.Publicaciones;
import com.YooFood.mongo.model.DireccionModel;
import com.YooFood.mongo.service.DireccionesService;

@Service("direccionesServiceImpl")
public class DireccionesServiceImpl implements DireccionesService{
	
	final String user = "yofood";
	final String pass = "oracle";
	final String bd = "BD_YOOFOOD";
	final String host = "54.203.2.7";
	final int port = 27017;
	
	public GeoResults<Publicaciones> geoNear(DireccionModel dir){

        MongoCredential credential = MongoCredential.createCredential(user, bd, pass.toCharArray());		
        MongoClient client = new MongoClient(Arrays.asList(new ServerAddress(host, port)),Arrays.asList(credential));

		try {
			MongoOperations operation = new MongoTemplate(client,bd);
			Point location = new Point(dir.getLocation().get(0),dir.getLocation().get(1));
			NearQuery query = NearQuery.near(location).maxDistance(new Distance(5, Metrics.KILOMETERS));
			GeoResults<Publicaciones> p = operation.geoNear(query, Publicaciones.class);

			return p;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}

}
