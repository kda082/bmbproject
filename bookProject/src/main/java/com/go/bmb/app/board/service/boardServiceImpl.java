package com.go.bmb.app.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.go.bmb.app.board.dto.boardDto;
import com.go.bmb.app.board.mapper.boardMapper;
import com.go.bmb.app.board.vo.SearchVO;
import com.go.bmb.app.board.web.boardController;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class boardServiceImpl implements boardService {
	
	@Autowired
	private boardMapper boardmapper;
	


	@Override
	public List<Map<String,Object>> list(Map<String,Object> requestDto) {
	
		List<Map<String,Object>>  result = null;
	
		System.out.println("=========pass by list()=============");

		boolean btitle = (boolean) requestDto.get("btitle");
		boolean bcontent = (boolean) requestDto.get("bcontent"); 
		String searchKeyword = (String) requestDto.get("searchKeyword"); 
		
		
		int listValue;
		if(requestDto.get("listValue") == null) {
			listValue = 1;
		}else {
			listValue = Integer.parseInt(requestDto.get("listValue").toString());
		}
		

		
		int page = listValue;
		
		SearchVO searchVO = new SearchVO();
		searchVO.setPage(page);
	
		int total = 0; //초기화 시키고
		if (btitle == true && bcontent == false) { //타이틀이 선택되고 컨텐트가 선택안돼있을떄
			total=boardmapper.selectBoardTotCount1(searchKeyword);
		}else if (btitle == false && bcontent == true ) { //컨탠트만 선택
			total=boardmapper.selectBoardTotCount2(searchKeyword);
		}else if (btitle == true && bcontent == true ) { //둘다 선택됨
			total=boardmapper.selectBoardTotCount3(searchKeyword);
		}else if ( bcontent == false  && bcontent == false ) { //모두 선택 안됌
			total=boardmapper.selectBoardTotCount0(searchKeyword);
		}

    	searchVO.pageCalculate(total);
	
		int rowStart = searchVO.getRowStart();
		int rowEnd = searchVO.getRowEnd();

		
	
		
	
		/*4개의 경우가생긴다.*/
		if (btitle == true && bcontent == false) { //타이틀이 선택되고 컨텐트가 선택안돼있을떄
			result = boardmapper.list(rowStart, rowEnd, searchKeyword, "1");
		}else if (btitle == false && bcontent == true ) { //컨탠트만 선택
			result = boardmapper.list(rowStart, rowEnd, searchKeyword, "2");
		}else if (btitle == true && bcontent == true ) { //둘다 선택됨
			result = boardmapper.list(rowStart, rowEnd, searchKeyword, "3");
		}else if ( bcontent == false  && bcontent == false ) { //모두 선택 안됌
			result = boardmapper.list(rowStart, rowEnd, searchKeyword, "0");
		}

		System.out.println("Totpage : "+total);
		System.out.println("clickPage : "+listValue);
		System.out.println("pageStart : "+searchVO.getPageStart());
		System.out.println("pageEnd : "+searchVO.getPageEnd());
		System.out.println("pageTot : "+searchVO.getTotPage());
		System.out.println("rowStart : "+searchVO.getRowStart());
		System.out.println("rowEnd : "+searchVO.getRowEnd());
		
		
		
		//마지막 배열로 온것은 페이징정보
		Map<String,Object> tempMap = new HashMap();
		tempMap.put("totRowCnt", total);
		tempMap.put("clickPage", listValue);
		tempMap.put("pageStart", searchVO.getPageStart());
		tempMap.put("pageEnd", searchVO.getPageEnd());
		tempMap.put("pageTot", searchVO.getTotPage());
		tempMap.put("rowStart", searchVO.getRowStart());
		tempMap.put("rowEnd", searchVO.getRowEnd());
		tempMap.put("page", searchVO.getPage());
		tempMap.put("totPage", searchVO.getTotPage());
		result.add(tempMap);

		
		return result;
	}



	@Override
	public void write(String bName, String bTitle, String bContent) {
		boardmapper.write(bName, bTitle, bContent);
	}



	@Override
	public Map<String, Object> content_view(String bid) {
		Map<String, Object> result = null;
		boardmapper.upHit(bid);
		result = boardmapper.contentView(bid);
		return result;
	}

}
