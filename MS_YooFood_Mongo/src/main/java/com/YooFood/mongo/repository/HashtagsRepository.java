package com.YooFood.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.YooFood.mongo.entity.HashtagsEntity;

public interface HashtagsRepository extends MongoRepository<HashtagsEntity, String> {

	HashtagsEntity save(HashtagsEntity h);
	HashtagsEntity findByHashtag(String hashtag);
	
}
