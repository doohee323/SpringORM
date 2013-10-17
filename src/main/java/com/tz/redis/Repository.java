package com.tz.redis;

import java.util.List;

/**
 * @author TZ
 * 
 */

public interface Repository<V extends DomainObject> {

	void put(V obj);

	V get(V key);

	void delete(V key);

	List<V> getObjects();
}
