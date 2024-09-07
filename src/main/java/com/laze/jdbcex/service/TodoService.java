package com.laze.jdbcex.service;

import com.laze.jdbcex.dao.TodoDAO;
import com.laze.jdbcex.domain.TodoVO;
import com.laze.jdbcex.dto.TodoDTO;
import com.laze.jdbcex.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {

    INSTANCE;

    private TodoDAO todoDAO;
    private ModelMapper modelMapper;

    TodoService() {

        todoDAO = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    public void register(TodoDTO todoDTO) throws Exception {

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        log.info(todoVO);

        todoDAO.insert(todoVO);
    }

    public List<TodoDTO> listAll() throws Exception {

        List<TodoVO> voList = todoDAO.selectAll();

        log.info("voList ...");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO get(Long tno) throws Exception {

        log.info("tno : " + tno);
        TodoVO todoVO = todoDAO.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }

    public void remove(Long tno) throws Exception {

        log.info("tno : " + tno);
        todoDAO.deleteOne(tno);
    }

    public void modify(TodoDTO todoDTO) throws Exception {

        log.info("todoDTO : " + todoDTO);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        todoDAO.updateOne(todoVO);
    }
}
