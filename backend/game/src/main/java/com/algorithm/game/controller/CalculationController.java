package com.algorithm.game.controller;


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

    @GetMapping("/basic")
    public ResponseEntity<?> backjoon1000(@RequestParam Integer a, Integer b){
        return ResponseEntity.ok(new HashMap<String,Integer>(){
            {
                put("add",a+b);
                put("sub",a-b);
                put("mul",a*b);
                put("div",a/b);
                put("rem",a%b);
            }

        });
    }
}
