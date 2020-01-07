package com.lms.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.service.LmsService;

@Controller
public class MainController {
	
	@Autowired
	private LmsService lmsService;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books", lmsService.findAllBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	@GetMapping("/updateBook")
	public String init(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("book", lmsService.findOne(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
}
