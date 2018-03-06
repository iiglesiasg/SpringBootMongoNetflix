package com.YooFood.mongo.service;

import java.util.List;

import com.YooFood.mongo.entity.HashtagsEntity;

public interface HashtagsService {

	public abstract void save(List<HashtagsEntity> hashtags);
}
