package com.algorithm.game.controller;


import com.algorithm.game.service.RandomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/random")
@Slf4j
public class RandomController {

    private final RandomService randomService;

    @GetMapping("/lotto")
    public ResponseEntity<?> Lotto(@RequestParam Integer start, Integer end, Integer count, Boolean isDistinct){
        return ResponseEntity.ok(randomService.randomPick(start,end,count,isDistinct));
    }
}
