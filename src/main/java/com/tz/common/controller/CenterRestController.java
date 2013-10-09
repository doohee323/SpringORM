package com.tz.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tz.common.dao.CentersDAO;
import com.tz.common.model.Center;
import com.tz.common.model.CenterFormValidator;

/**
 * @author TZ
 * 
 */

@Controller
public class CenterRestController {

	@Autowired
	private CentersDAO centersDAO;

	@Autowired
	private CenterFormValidator validator;

	@RequestMapping("/uip_centers")
	public @ResponseBody
	Map<String, Object> uipCenters() {
		Map<String, Object> list = new HashMap<String, Object>();
		List<Center> centers = centersDAO.getAllCenters();
		list.put("uip_centers", centers);
		return list;
	}

	@RequestMapping(value = "/uip_centers", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save(@RequestBody Center center) {
		Map<String, Object> list = new HashMap<String, Object>();
		int cnt = centersDAO.save(center);
		list.put("uip_centers", center);
		return list;
	}

	@RequestMapping(value = "/uip_centers/{id}", method = RequestMethod.PATCH)
	public @ResponseBody
	Map<String, Object> update(@PathVariable("id") int itemId,
			@RequestBody Center center) {
		Map<String, Object> list = new HashMap<String, Object>();
		int cnt = centersDAO.update(center);
		list.put("uip_centers", center);
		return list;
	}

	@RequestMapping(value = "/uip_centers/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Map<String, Object> delete(@PathVariable("id") int id,
			@RequestBody Center center) {
		Map<String, Object> list = new HashMap<String, Object>();
		centersDAO.delete(id);
		list.put("uip_centers", center);
		return list;
	}
}
