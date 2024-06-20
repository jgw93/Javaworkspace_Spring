package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
  public MemberVO getWithPassword(String mid, String mpw) throws Exception {
    String query = "SELECT mid,mpw,mname FROM tbl_member WHERE mid=? AND mpw=?";
    MemberVO memberVO = new MemberVO();
    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = conn.prepareStatement(query);
    preparedStatement.setString(1, mid);
    preparedStatement.setString(2, mpw);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    memberVO = MemberVO.builder()
        .mid(resultSet.getString("mid"))
        .mpw(resultSet.getString("mpw"))
        .mname(resultSet.getString("mname"))
        .build();
    return memberVO;
  }
  public void updateUuid(String mid, String uuid) throws Exception {
    String sql = "UPDATE tbl_member SET uuid=? WHERE mid=?";
    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,uuid);
    pstmt.setString(2, mid);
    pstmt.executeUpdate();
  }
  public MemberVO selectUUID(String uuid) throws Exception {
    String sql = "SELECT mid, mpw,mname,uuid FROM tbl_member WHERE uuid = ?";
    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = conn.prepareStatement(sql);
    preparedStatement.setString(1,uuid);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    MemberVO memberVO = MemberVO.builder()
        .mid(resultSet.getString("mid"))
        .mpw(resultSet.getString("mpw"))
        .mname(resultSet.getString("mname"))
        .uuid(resultSet.getString("uuid"))
        .build();
    return memberVO;
  }
}






