package com.tz.common.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tz.common.dao.CentersDAO;
import com.tz.common.model.Center;
import com.tz.common.model.CenterFormValidator;

/**
 * @author TZ
 * 
 */

@Controller
public class CentersControllers {

	@Autowired
	private CentersDAO centersDAO;

	@Autowired
	private CenterFormValidator validator;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping("/searchCenters")
	public ModelAndView searchCenters(
			@RequestParam(required = false, defaultValue = "") String name) {
		ModelAndView mav = new ModelAndView("showCenters");
		List<Center> centers = centersDAO.searchCenters(name.trim());
		mav.addObject("SEARCH_CENTERS_RESULTS_KEY", centers);
		return mav;
	}

	@RequestMapping("/viewAllCenters")
	public ModelAndView getAllCenters() {
		ModelAndView mav = new ModelAndView("showCenters");
		List<Center> centers = centersDAO.getAllCenters();
		mav.addObject("SEARCH_CENTERS_RESULTS_KEY", centers);
		return mav;
	}

	@RequestMapping(value = "/saveCenter", method = RequestMethod.GET)
	public ModelAndView newCenter() {
		ModelAndView mav = new ModelAndView("newCenter");
		Center center = new Center();
		mav.getModelMap().put("newCenter", center);
		return mav;
	}

	@RequestMapping(value = "/saveCenter", method = RequestMethod.POST)
	public String create(@ModelAttribute("newCenter") Center center,
			BindingResult result, SessionStatus status) {
		validator.validate(center, result);
		if (result.hasErrors()) {
			return "newCenter";
		}
		centersDAO.save(center);
		status.setComplete();
		return "redirect:viewAllCenters.do";
	}

	@RequestMapping(value = "/updateCenter", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("editCenter");
		Center center = centersDAO.getById(id);
		mav.addObject("editCenter", center);
		return mav;
	}

	@RequestMapping(value = "/updateCenter", method = RequestMethod.POST)
	public String update(@ModelAttribute("editCenter") Center center,
			BindingResult result, SessionStatus status) {
		validator.validate(center, result);
		if (result.hasErrors()) {
			return "editCenter";
		}
		centersDAO.update(center);
		status.setComplete();
		return "redirect:viewAllCenters.do";
	}

	@RequestMapping("deleteCenter")
	public ModelAndView delete(@RequestParam("id") Integer id) {
		ModelAndView mav = new ModelAndView("redirect:viewAllCenters.do");
		centersDAO.delete(id);
		return mav;
	}

}
