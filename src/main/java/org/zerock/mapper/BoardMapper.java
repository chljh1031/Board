package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

	public List<BoardVO> getListWithPaging(Criteria cri); // 294p 페이징 처리를 위해서 추가 및 수정된 부분

	// insert만 처리되고 생성된 PK 값을 알 필요가 없는 경우
	public void insert(BoardVO board);

	// insert문이 실행되고 생성된 PK 값을 알아야 하는 경우
//	public void insertSelectKey(BoardVO board);
	public Integer insertSelectKey(BoardVO board); // 294p 페이징 처리를 위해서 추가 및 수정된 부분

	// insert가 된 데이터를 조회하는 작업은 PK를 이용해서 처리하므로
	// BoardMapper의 파라미터 역시 BoardVO 클래스의 bno 타입 정보를 이용해서 처리합니다.
	public BoardVO read(Long bno);

	// 등록, 삭제, 수정과 같은 DML 작업은 '몇 건의 데이터가 삭제(혹은 수정)되었는지'를 반환할 수 있습니다.
	public int delete(Long bno);

	// Update는 delete와 마찬가지로 '몇 개의 데이터가 수정되었는가'를 처리할 수 있게 int 타입으로 메서드를 설계할 수 있습니다.
	public int update(BoardVO board);

	// 실제 모든 게시물의 수 가져오기
	public int getTotalCount(Criteria cri);

	// 글에 달린 댓글의 합을 업데이트
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}