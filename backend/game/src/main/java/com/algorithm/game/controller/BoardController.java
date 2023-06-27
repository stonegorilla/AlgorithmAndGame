package com.algorithm.game.controller;


import com.algorithm.game.dto.request.BoardRequest;
import com.algorithm.game.dto.request.UserRequest;
import com.algorithm.game.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardService boardService;
    @PostMapping("/register")
    public ResponseEntity<?> registerBoard(@RequestBody BoardRequest.Register register) throws Exception {


        return ResponseEntity.ok().body(boardService.registerBoard(register));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getBoardsAll(@RequestParam int start, int size){
        return ResponseEntity.ok().body(boardService.boardsAll(start,size));
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getBoardDetail(@RequestParam Long boardSeq) throws Exception {
        return ResponseEntity.ok().body(boardService.boardDetail(boardSeq));
    }
    @PutMapping("/modify")
    public ResponseEntity<?> modifyBoard(@RequestBody BoardRequest.Modify modify){
        return ResponseEntity.ok().body(boardService.modifyBoard(modify));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeBoard(@RequestParam Long boardSeq){
        return ResponseEntity.ok().body(boardService.removeBoard(boardSeq));
    }
}
