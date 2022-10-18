package org.zerock.service;

import java.util.List;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board); // C

	public BoardVO get(Long bno); // R

	public boolean modify(BoardVO board); // U

	public boolean remove(Long bno); // D

//	public List<BoardVO> getList(); // List
	public List<BoardVO> getList(Criteria cri); // 페이징 처리된 List
	
	public int getTotal(Criteria cri); // 전체 갯수

	
}