package com.go.bmb.app.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.go.bmb.app.board.dto.boardDto;
import com.go.bmb.app.board.vo.SearchVO;

public interface boardService {
	
	List<Map<String,Object>>  list (Map<String,Object> requestDto);

	void write(String bName, String bTitle, String bContent);

	Map<String,Object> content_view(String bid);

}
