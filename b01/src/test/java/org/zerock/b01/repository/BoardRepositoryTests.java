package org.zerock.b01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.b01.domain.Board;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
  @Autowired
  private BoardRepository boardRepository;
  @Test
  public void testInsert(){
    IntStream.rangeClosed(1,100).forEach(i->{
        Board board = Board.builder()
            .title("title..."+i)
            .content("content..."+i)
            .writer("user"+(i%10))
        .build();
        Board result = boardRepository.save(board);
        log.info("BNO: " + result.getBno());
    });
  }
  @Test
  public void testSelect(){
    Long bno = 100L;
    Optional<Board> result = boardRepository.findById(bno);
    Board board = result.orElseThrow();
    log.info(board);
  }

  @Test
  public void testUpdate(){
    Long bno = 100L;
    Optional<Board> result = boardRepository.findById(bno);
    Board board = result.orElseThrow();
    board.change("update..title 100", "update content 100");
    boardRepository.save(board);
    log.info(board);
  }

  @Test
  public void testDelete(){
    Long bno = 101L;
    boardRepository.deleteById(bno);
  }

  @Test
  public void testPaging(){
    Pageable pageable =
        PageRequest.of(1,10, Sort.by("bno").descending());
    Page<Board> result = boardRepository.findAll(pageable);
    log.info("total Count : " + result.getTotalElements());
    log.info("total pages : " + result.getTotalPages());
    log.info("page number : " + result.getNumber());
    log.info("page size : " + result.getSize());
    List<Board> todoList = result.getContent();
    todoList.forEach(board -> log.info(board));
  }
  @Test
  public void testSearch1(){
    Pageable pageable = PageRequest.of(1,10,Sort.by("bno").descending());
    boardRepository.search1(pageable);
  }

  @Test
  public void testSearchAll(){
    //동적 WHERE위한 조건식값 설정하기 title, content, writer
    String[] types = {"t","c","w"};
    // 검색할 문자열 저장
    String keyword = "1";
    //몇개의 데이터를 어떤 정렬로 검색할지 설정
    Pageable pageable = PageRequest.of(0,10,Sort.by("bno").descending());
    //위의 조건식으로 데이터베이스에서 조회하는 레포지토리 실행
    Page<Board> result = boardRepository.searchAll(types,keyword,pageable);
    log.info(result.getTotalPages());
    log.info(result.getSize());
    log.info(result.getNumber());
    log.info(result.hasPrevious() + ":" + result.hasNext());
    result.getContent().forEach(board->log.info(board));
  }
}














