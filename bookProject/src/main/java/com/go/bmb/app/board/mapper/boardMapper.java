package com.go.bmb.app.board.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.go.bmb.app.board.dto.boardDto;



@Repository
@Mapper
public interface boardMapper {
	
	public List<Map<String,Object>>  list(int start,int end,String searcKeyword,String selNum);
	public void write(String bName,String bTitle, String bContent);
	public Map<String,Object> contentView(String sbid);
	public void upHit(String sbid);
	public void delete(String bid);
	public void modify(String bid, String bName,String bTitle, String bContent);
	public boardDto replyView(String sbid);
	
//	reply
	public void reply(String bid, String bName,String bTitle, String bContent,String bgroup, String bstep,String bindent);
	
	
//	replyShape
	public void replyShape(String bgroup,String bstep);
	
	//totcnt
	public int selectBoardTotCount1(String searchKeyword);
	public int selectBoardTotCount2(String searchKeyword);
	public int selectBoardTotCount3(String searchKeyword);
	public int selectBoardTotCount0(String searchKeyword);
	
	
	
}