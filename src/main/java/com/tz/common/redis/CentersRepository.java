package com.tz.common.redis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.tz.common.model.Center;
import com.tz.redis.Repository;

/**
 * @author TZ
 * 
 */

public class CentersRepository implements Repository<Center> {

	@Autowired
	private RedisTemplate<String, Center> redisTemplate;

	public RedisTemplate<String, Center> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Center> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void put(Center center) {
		redisTemplate.opsForHash()
				.put(center.getObjectKey(), center.getKey(), center);
	}

	@Override
	public void delete(Center key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
	}

	@Override
	public Center get(Center key) {
		return (Center) redisTemplate.opsForHash().get(key.getObjectKey(),
				key.getKey());
	}

	@Override
	public List<Center> getObjects() {
		List<Center> centers = new ArrayList<Center>();
		for (Object center : redisTemplate.opsForHash().values(Center.OBJECT_KEY)) {
			centers.add((Center) center);
		}
		return centers;
	}
}