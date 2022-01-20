package com.go.bmb.app.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class bookController {

	@GetMapping("/app/book/web/bookList")
	public String moveBookList() {
		return "book/bookList";	
	}
	
}
