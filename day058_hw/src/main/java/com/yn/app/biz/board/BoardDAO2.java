package com.yn.app.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO2 {
	// 기본 DAO를 고도화시키면 BoardDAO2가 될 예정임
	// 더 이상 기존 버전이 아니라 @Repository를 옮겨달것
	private final String SELECTALL = "SELECT BID,CONTENT,WRITER FROM BOARD";
	private final String SELECTALL_CONTENT = "SELECT BID,CONTENT,WRITER FROM BOARD WHERE CONTENT LIKE CONCAT('%',?,'%')";
	private final String SELECTALL_WRITER = "SELECT BID,CONTENT,WRITER FROM BOARD WHERE WRITER=?";
	private final String SELECTONE = "SELECT BID,CONTENT,WRITER FROM BOARD WHERE BID=? ";
	private final String INSERT = "INSERT INTO BOARD (BID,CONTENT,WRITER) VALUES(?,?,?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<BoardDTO> selectAll(BoardDTO boardDTO) {
		if (boardDTO.getCondition() != null) {
			if (boardDTO.getCondition().equals("CONTENT")) {
				return jdbcTemplate.query(SELECTALL_CONTENT, new Object[]{boardDTO.getKeyword()}, new BoardRowMapper());
			} else if (boardDTO.getCondition().equals("WRITER")) {
				return jdbcTemplate.query(SELECTALL_WRITER, new Object[]{boardDTO.getKeyword()}, new BoardRowMapper());
			}
		}
		// 조건이 없을 경우 전체 조회
		return jdbcTemplate.query(SELECTALL, new BoardRowMapper());
	}
	public BoardDTO selectOne(BoardDTO boardDTO) {
		Object[] args= {boardDTO.getBid()};
		return jdbcTemplate.queryForObject(SELECTONE,args,new BoardRowMapper());
	}
	public boolean insert(BoardDTO boardDTO) {
		boardDTO.setBid(20);
		int result=jdbcTemplate.update(INSERT, boardDTO.getBid(), boardDTO.getContent(), boardDTO.getWriter());
		if(result<=0) {
			return false;
		}
		return true;
	}
	public boolean update(BoardDTO boardDTO) {
		return false;
	}
	public boolean delete(BoardDTO boardDTO) {
		return false;
	}
}

class BoardRowMapper implements RowMapper<BoardDTO> {

	@Override
	public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDTO data=new BoardDTO();
		data.setBid(rs.getInt("BID"));
		data.setContent(rs.getString("CONTENT"));
		data.setWriter(rs.getString("WRITER"));
		return data;
	}



}
