package com.algorithm.game.service;

import com.algorithm.game.domain.Board;
import com.algorithm.game.dto.request.BoardRequest;
import com.algorithm.game.dto.response.BoardResponse;
import com.algorithm.game.dto.response.MessageResponse;

import java.util.List;

public interface BoardService {

    List<BoardResponse.BoardsAll> boardsAll(int start, int size);

    Board boardDetail(Long boardSeq) throws Exception;
    MessageResponse registerBoard(BoardRequest.Register register) throws Exception;

    MessageResponse modifyBoard(BoardRequest.Modify modify);

    MessageResponse removeBoard(Long boardSeq);

}
