package com.tz.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tz.common.dao.CentersDAO;
import com.tz.common.model.Center;
import com.tz.common.model.CenterFormValidator;
import com.tz.common.redis.CentersRepository;

/**
 * @author TZ
 * 
 */

@Controller
public class CenterRestController {

	@Autowired
	private CentersDAO centersDAO;

	@Autowired
	private CentersRepository centersRepository;

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
		centersDAO.save(center);

		// try {
		// URI redisUri = new
		// URI("redis://rediscloud:KWSKkL8OrXsgvizE@pub-redis-13710.us-east-1-4.1.ec2.garantiadata.com:13710");
		// JedisConnectionFactory redisConnectionFactory = new
		// JedisConnectionFactory();
		// redisConnectionFactory.setHostName(redisUri.getHost());
		// redisConnectionFactory.setPort(redisUri.getPort());
		// redisConnectionFactory.setTimeout(Protocol.DEFAULT_TIMEOUT);
		// redisConnectionFactory.setPassword(redisUri.getUserInfo().split(":",2)[1]);
		// redisConnectionFactory.getConnection();
		//
		// } catch (URISyntaxException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		centersRepository.put(center);
//		System.out
//				.println(" Step 1 output : " + centersRepository.getObjects());
//		centersRepository.put(center);
//		System.out
//				.println(" Step 2 output : " + centersRepository.getObjects());
//		centersRepository.delete(center);
//		System.out
//				.println(" Step 3 output : " + centersRepository.getObjects());

		list.put("uip_center", center);
		return list;
	}

	@RequestMapping(value = "/uip_centers/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Map<String, Object> update(@PathVariable("id") int id,
			@RequestBody Center center) {
		Map<String, Object> list = new HashMap<String, Object>();
		center = centersDAO.update(center);
		list.put("uip_center", center);
		return list;
	}

	@RequestMapping(value = "/uip_centers/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") int id) {
		centersDAO.delete(id);
	}
}
