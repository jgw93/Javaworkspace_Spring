package org.zerock.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }

    @Override
    public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
        // 서버에서, 계산한 멤버들을 , 반환 값으로 보내기 위한 준비단계.
        // 기존에, 서비스에서 사용했던 메서드들을 재사용할 예정.
        // 해당 페이지의, 게시글 목록
        // 재료 1.
        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
        // TodoVO -> TodoDTO 로 변환하는 함수
        // voList : 페이지 당, 게시글 10개의 요소가 들어 있다.
        // stream().map, 요소를 정렬처리하는 기능
        // voList 의 10개의 요소들을, 하나씩 순회하면서, 각각 실행을 한다.
        // vo : 10개의 요소중 하나의 요소가 들어가고,
        // modelMapper.map : 하는 업무, vo 타입을, TodoDTO 타입으로 반환을 함, 각각 요소마다 전부다. 10개
        // collect : 모아주는데, 어떻게 모아주냐,
        // Collectors.toList() : List 타입으로 변환 시켜주기.
        // 결론, 리스트의 VO 타입을, DTO 타입으로 다 변환 해주기.
        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        // 재료 2.
        // 전체 갯수를 알아야 페이징을 할수 있다.
        int total = todoMapper.getCount(pageRequestDTO);

        // 재료 3. 재료 1 과 재료 2 에서 구한 내용으로 서버에서 재계산.
        // 실제로, 서버에서 계산한 많은 재료를 담아 놓은 인스턴스.
        PageResponseDTO<TodoDTO> pageResponseDTO = PageResponseDTO.<TodoDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);
        return todoDTO;
    }

    @Override
    public void remove(Long tno) {todoMapper.delete(tno);}

    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        todoMapper.update(todoVO);
    }
}
