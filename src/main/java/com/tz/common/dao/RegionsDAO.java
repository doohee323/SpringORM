package com.tz.common.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tz.common.model.Region;

/**
 * @author TZ
 * 
 */
@Repository
@Transactional
public class RegionsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Region getById(int id) {
		return (Region) sessionFactory.getCurrentSession()
				.get(Region.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Region> searchRegions(String name) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Region.class);
		criteria.add(Restrictions.ilike("name", name + "%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Region> getAllRegions() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				Region.class);
		return criteria.list();
	}

	public int save(Region region) {
		return (Integer) sessionFactory.getCurrentSession().save(region);
	}

	public Region update(Region region) {
		return (Region)sessionFactory.getCurrentSession().merge(region);
	}

	public void delete(int id) {
		Region c = getById(id);
		sessionFactory.getCurrentSession().delete(c);
	}

}
