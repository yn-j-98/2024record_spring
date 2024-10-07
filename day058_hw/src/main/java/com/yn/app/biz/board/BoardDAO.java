package com.yn.app.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yn.app.biz.common.JDBCUtil;

@Repository
public class BoardDAO implements BoardService {

    private final String SEARCH_ALL = "SELECT BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER FROM BOARD"; // 전체 게시글 조회
    private final String SEARCH_ONE = "SELECT BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER FROM BOARD WHERE BOARD_NUM = ?"; // 특정 게시글 조회
    private final String INSERT = "INSERT INTO BOARD (BOARD_NUM, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER) VALUES (?, ?, ?, ?)"; // 게시글 추가
    private final String UPDATE = "UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ?, BOARD_WRITER = ? WHERE BOARD_NUM = ?"; // 게시글 수정
    private final String DELETE = "DELETE FROM BOARD WHERE BOARD_NUM = ?"; // 게시글 삭제 

    @Autowired
    private BoardDTO boardDTO;

    @Override
    public List<BoardDTO> SelectAll(BoardDTO boardDTO) {
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;
        List<BoardDTO> datas = new ArrayList<>();

        try {
            pstmt = conn.prepareStatement(SEARCH_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                boardDTO = new BoardDTO();
                boardDTO.setBoard_num(rs.getInt("BOARD_NUM"));
                boardDTO.setBoard_title(rs.getString("BOARD_TITLE"));
                boardDTO.setBoard_content(rs.getString("BOARD_CONTENT"));
                boardDTO.setBoard_writer(rs.getString("BOARD_WRITER"));
                datas.add(boardDTO);
            }
        } catch (SQLException e) {
            System.err.println("SQL문 실패");
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return datas;
    }

    @Override
    public BoardDTO SelectOne(BoardDTO boardDTO) {
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(SEARCH_ONE);
            pstmt.setInt(1, boardDTO.getBoard_num());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                boardDTO.setBoard_num(rs.getInt("BOARD_NUM"));
                boardDTO.setBoard_title(rs.getString("BOARD_TITLE"));
                boardDTO.setBoard_content(rs.getString("BOARD_CONTENT"));
                boardDTO.setBoard_writer(rs.getString("BOARD_WRITER"));
            }
        } catch (SQLException e) {
            System.err.println("SQL문 실패");
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        return this.boardDTO;
    }

    @Override
    public boolean insert(BoardDTO boardDTO) {
        System.out.println("board.BoardDAO.insert 시작");
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, boardDTO.getBoard_num());
            pstmt.setString(2, boardDTO.getBoard_title());
            pstmt.setString(3, boardDTO.getBoard_content());
            pstmt.setString(4, boardDTO.getBoard_writer());

            int rs = pstmt.executeUpdate();
            if (rs <= 0) {
                System.err.println("board.BoardDAO.insert 실패");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("board.BoardDAO.insert SQL문 실패");
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        System.out.println("board.BoardDAO.insert 성공");
        return true;
    }

    @Override
    public boolean update(BoardDTO boardDTO) {
        System.out.println("board.BoardDAO.update 시작");
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, boardDTO.getBoard_title());
            pstmt.setString(2, boardDTO.getBoard_content());
            pstmt.setString(3, boardDTO.getBoard_writer());
            pstmt.setInt(4, boardDTO.getBoard_num());

            int rs = pstmt.executeUpdate();
            if (rs <= 0) {
                System.err.println("board.BoardDAO.update 실패");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("board.BoardDAO.update SQL문 실패");
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        System.out.println("board.BoardDAO.update 성공");
        return true;
    }

    @Override
    public boolean delete(BoardDTO boardDTO) {
        System.out.println("board.BoardDAO.delete 시작");
        Connection conn = JDBCUtil.connect();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, boardDTO.getBoard_num());

            int rs = pstmt.executeUpdate();
            if (rs <= 0) {
                System.err.println("board.BoardDAO.delete 실패");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("board.BoardDAO.delete SQL문 실패");
            return false;
        } finally {
            JDBCUtil.disconnect(pstmt, conn);
        }
        System.out.println("board.BoardDAO.delete 성공");
        return true;
    }
}
