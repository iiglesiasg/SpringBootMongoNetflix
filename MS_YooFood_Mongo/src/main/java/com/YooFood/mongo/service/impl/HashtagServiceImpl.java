package com.YooFood.mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YooFood.mongo.entity.HashtagsEntity;
import com.YooFood.mongo.repository.HashtagsRepository;
import com.YooFood.mongo.service.HashtagsService;

@Service("hashtagServiceImpl")
public class HashtagServiceImpl implements HashtagsService{

	@Autowired
    private HashtagsRepository hashtagsRepository;
	
	@Override
	public void save(List<HashtagsEntity> hashtags) {
		for(HashtagsEntity hashtag:hashtags) {
			HashtagsEntity h = hashtagsRepository.findByHashtag(hashtag.getHashtag());
			if(h==null)hashtagsRepository.save(hashtag);
		}
	}
}
