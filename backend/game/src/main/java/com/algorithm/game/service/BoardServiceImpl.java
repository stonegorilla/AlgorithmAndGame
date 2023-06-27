package com.algorithm.game.service;


import com.algorithm.game.domain.Board;
import com.algorithm.game.domain.User;
import com.algorithm.game.dto.request.BoardRequest;
import com.algorithm.game.dto.response.BoardResponse;
import com.algorithm.game.dto.response.MessageResponse;
import com.algorithm.game.repository.BoardRepository;
import com.algorithm.game.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;
    @Override
    public List<BoardResponse.BoardsAll> boardsAll(int start, int size) {


        PageRequest pageRequest = PageRequest.of(start,size);
        List<BoardResponse.BoardsAll> list = boardRepository.findAll(pageRequest)
                .stream().map(x -> BoardResponse.BoardsAll.builder()
                        .boardSeq(x.getBoardSeq())
                        .writer(x.getUser().getName())
                        .title(x.getTitle())
                        .viewCnt(0L)
                        .createTime(x.getCreateTime())
                        .build()).collect(Collectors.toList());
        return list;
    }

    @Override
    public Board boardDetail(Long boardSeq) throws Exception {
        Board board = boardRepository.findById(boardSeq).orElseThrow(()->new Exception("없습니다."));
        log.info(board.toString());
        return board;
    }

    @Override
    public MessageResponse registerBoard(BoardRequest.Register register) throws Exception {

        User user = userRepository.findById(register.getUserSeq()).orElseThrow(()-> new Exception("not exist user"));

        Board board = Board.builder()
                .title(register.getTitle())
                .content(register.getContent()).user(user).build();
        boardRepository.save(board);
        MessageResponse messageResponse = MessageResponse.builder().message("글이 등록되었습니다.").build();
        return messageResponse;
    }

    @Override
    public MessageResponse modifyBoard(BoardRequest.Modify modify) {
        Board board = boardRepository.findById(modify.getBoardSeq()).orElseThrow();
        board.setTitle(modify.getTitle());
        board.setContent(modify.getContent());
        boardRepository.save(board);
        return MessageResponse.builder().message("글이 수정되었습니다.").build();
    }

    @Override
    public MessageResponse removeBoard(Long boardSeq) {
        Board board = boardRepository.findById(boardSeq).orElseThrow();
        boardRepository.delete(board);

        return MessageResponse.builder().message("글이 삭제되었습니다.").build();
    }
}
