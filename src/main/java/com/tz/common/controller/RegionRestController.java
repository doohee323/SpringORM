package com.tz.common.controller;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tz.common.dao.RegionsDAO;
import com.tz.common.model.Region;

/**
 * @author TZ
 * 
 */

@Controller
public class RegionRestController {

	@Autowired
	private RegionsDAO regionsDAO;

	@RequestMapping("/uip_regions")
	public @ResponseBody
	Map<String, Object> uipRegions() {
		Map<String, Object> list = new HashMap<String, Object>();
		List<Region> regions = regionsDAO.getAllRegions();
		list.put("uip_regions", regions);
		return list;
	}

	@RequestMapping(value = "/uip_regions", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> save(@RequestBody Region region) {
		Map<String, Object> list = new HashMap<String, Object>();
		int cnt = regionsDAO.save(region);
		list.put("uip_regions", region);
		return list;
	}

	@RequestMapping(value = "/uip_regions/{id}", method = RequestMethod.PATCH)
	public @ResponseBody
	Map<String, Object> update(@PathVariable("id") int id,
			@RequestBody Region region) {
		Map<String, Object> list = new HashMap<String, Object>();
		int cnt = regionsDAO.update(region);
		list.put("uip_regions", region);
		return list;
	}

	@RequestMapping(value = "/uip_regions/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Map<String, Object> delete(@PathVariable("id") int id,
			@RequestBody Region region) {
		Map<String, Object> list = new HashMap<String, Object>();
		regionsDAO.delete(id);
		list.put("uip_regions", region);
		return list;
	}
}
