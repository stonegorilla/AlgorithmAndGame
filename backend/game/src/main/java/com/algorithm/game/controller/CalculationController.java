package com.algorithm.game.controller;


import com.algorithm.game.service.CalculationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculation")
@Slf4j
public class CalculationController {

    private final CalculationService calculationService;

    @GetMapping("/four-rules")
    public ResponseEntity<?> backjoon1000(@RequestParam Integer a, Integer b){
        return ResponseEntity.ok(calculationService.fourRules(a,b));
    }

    @GetMapping("/fibonacci")
    public ResponseEntity<?> fibonacci(@RequestParam Integer num){
        return ResponseEntity.ok(calculationService.fibonacci(num));
    }
}
