package com.payil.controller;

import java.text.BreakIterator;

import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.DumperOptions.LineBreak;

import com.payil.Model.User;
import com.payil.dao.userdao;

@Controller
public class UserController {
	@Autowired
	  userdao ud;
	
	@GetMapping("index")
	public String index() {
		return"index.html";
	}
	
@GetMapping("adduser")
	public String adduser(User user) {
	    ud.save(user);
		return"index.html";
	
	}

@GetMapping("getuser")
public ModelAndView getuser(@RequestParam int id) {
	ModelAndView mav=new ModelAndView("showUser.jsp");
	User user=ud.findById(id).orElse(new User());
	mav.addObject(user);
	return mav;
}

@GetMapping("deleteuser")
public ModelAndView deletuser(@RequestParam int id) {
	ModelAndView mav=new ModelAndView("deleteUser.jsp");
	User user=ud.findById(id).orElse(new User());
	ud.deleteById(id);
	mav.addObject(user);
	return mav;
}
@GetMapping("updateuser")
public ModelAndView updateuser(User user) {
	ModelAndView mav=new ModelAndView("updateUser.jsp");
	 user=ud.findById(user.getid()).orElse(new User());
	ud.deleteById(user.getid());
	mav.addObject(user);
	return mav;
}


}
