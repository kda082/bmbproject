package com.go.bmb.app.board.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class boardController {

	@GetMapping("/app/board/web/board")
	public String moveBoard(){
		return "board/board";
	}
	
	@GetMapping("/app/board/web/write")
	public String moveWriteView() {
		return "board/write_view";
	}
	
	@GetMapping("/content_view/{bid}")
	public String content_view(@PathVariable String bid,Model model){
		model.addAttribute("BID",bid);
		return "board/content_view";
	}
	
	
	
	
	
}
