package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.TodoVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
  public String getTime() throws Exception {
//    String now = null;
//    try(Connection connection = ConnectionUtil.INSTANCE.getConnection();
//    PreparedStatement pstmt = connection.prepareStatement("select now()");
//    ResultSet resultSet = pstmt.executeQuery();){
//      resultSet.next();
//      now = resultSet.getString(1);
//    }catch(Exception e){
//      e.printStackTrace();
//    }

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement("select now()");
    @Cleanup ResultSet resultSet = pstmt.executeQuery();
    resultSet.next();
    String now = resultSet.getString(1);

    return now;
  }

  public void insert(TodoVO vo) throws Exception {
    String sql = "INSERT INTO tbl_todo(title,dueDate,finished) VALUES(?,?,?)";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setString(1, vo.getTitle());
    pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
    pstmt.setBoolean(3, vo.isFinished());
    pstmt.executeUpdate();
  }

  public List<TodoVO> selectAll() throws Exception{
    String sql = "SELECT * FROM tbl_todo";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    @Cleanup ResultSet resultSet = pstmt.executeQuery();
    List<TodoVO> list = new ArrayList<TodoVO>();
    while (resultSet.next()) {
      TodoVO vo = TodoVO.builder()
          .tno(resultSet.getLong("tno"))
          .title(resultSet.getString("title"))
          .dueDate(resultSet.getDate("dueDate").toLocalDate())
          .finished(resultSet.getBoolean("finished"))
          .build();
      list.add(vo);
    }
    return list;
  }

  public TodoVO selectOne(Long tno) throws Exception {
    String sql = "SELECT * FROM tbl_todo WHERE tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setLong(1,tno);
    @Cleanup ResultSet resultSet = pstmt.executeQuery();
    resultSet.next();
    TodoVO vo = TodoVO.builder()
        .tno(resultSet.getLong("tno"))
        .title(resultSet.getString("title"))
        .dueDate(resultSet.getDate("dueDate").toLocalDate())
        .finished(resultSet.getBoolean("finished"))
        .build();
    return vo;
  }
  public void deleteOne(Long tno) throws Exception {
    String sql = "DELETE FROM tbl_todo WHERE tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setLong(1, tno);
    pstmt.executeUpdate();
  }

  public void updateOne(TodoVO vo) throws Exception {
    String sql = "UPDATE tbl_todo SET title=?, dueDate=?, finished=? WHERE tno = ?";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setString(1, vo.getTitle());
    pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
    pstmt.setBoolean(3, vo.isFinished());
    pstmt.setLong(4, vo.getTno());
    pstmt.executeUpdate();
  }
}















