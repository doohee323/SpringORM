package com.tz.common.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.tz.common.model.Region;
import com.tz.redis.Repository;

/**
 * @author TZ
 * 
 */

public class RegionsRepository implements Repository<Region> {

	@Autowired
	private RedisTemplate<String, Region> redisTemplate;

	public RedisTemplate<String, Region> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Region> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void put(Region region) {
		redisTemplate.opsForHash()
				.put(region.getObjectKey(), region.getKey(), region);
	}

	@Override
	public void delete(Region key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
	}

	@Override
	public Region get(Region key) {
		return (Region) redisTemplate.opsForHash().get(key.getObjectKey(),
				key.getKey());
	}

	@Override
	public List<Region> getObjects() {
		List<Region> regions = new ArrayList<Region>();
		for (Object region : redisTemplate.opsForHash().values(Region.OBJECT_KEY)) {
			regions.add((Region) region);
		}
		return regions;
	}
}