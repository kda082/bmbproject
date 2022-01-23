package com.go.bmb.app.board.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.go.bmb.app.board.vo.SearchVO;

import lombok.RequiredArgsConstructor;

import com.go.bmb.app.board.dto.boardDto;
import com.go.bmb.app.board.service.boardService;

@RestController
@RequiredArgsConstructor
public class boardRestController {
	
	@Autowired
	private boardService boardService;
	
	@RequestMapping("/list")
	public List<Map<String,Object>>  list(@RequestBody Map<String,Object> requestDto) { 
			return boardService.list(requestDto);
	}
	
	
	@RequestMapping("/write")
	public void write(@RequestBody Map<String,Object> requestDto) {
		String bName= (String) requestDto.get("bName");
		String bTitle = (String) requestDto.get("bTitle");
		String bContent= (String) requestDto.get("bContent");
		boardService.write(bName,bTitle,bContent);
	}
	
	@RequestMapping("/content_view/load/{bid}")
	public Map<String,Object> content_view(@PathVariable String bid) {
			return boardService.content_view(bid);
	}

	

}
