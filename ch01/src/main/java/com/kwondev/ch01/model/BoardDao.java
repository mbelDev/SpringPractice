package com.kwondev.ch01.model;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class BoardDao {

  public int insertBoard(BoardDto boardDto) {
    int result = 0;

    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    result = sqlSession.insert("insertBoard", boardDto);
    if (result > 0) {
      sqlSession.commit();
    } else {
      sqlSession.rollback();
    }
    sqlSession.close();
    return result;
  }

  public int deleteBoard(int postNo, String postPW) {
    int result = 0;

    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    if (sqlSession.selectOne("checkPW", postNo).equals(postPW)) {
      result = sqlSession.delete("deletePost");
      if (result > 0) {
        sqlSession.commit();
      } else {
        sqlSession.rollback();
      }
    } else {
      result = -1; // 비밀번호 불일치
    }
    sqlSession.close();
    return result;
  }

  public int getTotal() {
    int result = 0;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    result = sqlSession.selectOne("getTotalPost");
    sqlSession.close();
    return result;
  }

  public List<BoardDto> getAll() {
    List<BoardDto> boardList = null;

    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    System.out.println(sqlSession);
    boardList = sqlSession.selectList("getSelectAll");
    sqlSession.close();
    return boardList;
  }

  public List<BoardDto> getBoardPage(int page, int howmany) {
    HashMap<String, Integer> pageMap = new HashMap<>();
    pageMap.put("start", page);
    pageMap.put("end", howmany);
    List<BoardDto> boardList = null;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    boardList = sqlSession.selectList("getBoardPage", pageMap);
    sqlSession.close();
    return boardList;
  }

  public BoardDto getSelectOne(int postNo) {
    BoardDto boardDto = null;
    SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
    boardDto = sqlSession.selectOne("getSelectOne", postNo);
    sqlSession.close();
    return boardDto;
  }
}
