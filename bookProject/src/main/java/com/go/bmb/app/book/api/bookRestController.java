package com.go.bmb.app.book.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.bmb.app.book.service.bookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class bookRestController {
	
	@Autowired
	bookService bookservice;
	
	@GetMapping("/app/book/api/getList")
	public List<Map<String,Object>> getList(){
		return bookservice.findAll();
	}

}
