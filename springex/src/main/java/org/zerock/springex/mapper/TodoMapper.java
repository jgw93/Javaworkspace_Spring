package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {

  String getTime();

  void insert(TodoVO todoVO);

  List<TodoVO> selectAll();

  TodoVO selectOne(Long tno);

  void delete(Long tno);

  void update(TodoVO todoVO);

  // 페이징 관련 메서드 추가 부분.
  List<TodoVO> selectList(PageRequestDTO PageRequestDTO);

  // 전체 갯수를 알아야, 페이징을 나누기가 가능.
  int getCount(PageRequestDTO PageRequestDTO);

}
