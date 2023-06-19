package com.algorithm.game.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

@Service
public class CalculationServiceImpl implements CalculationService{
    @Override
    public HashMap<String, Integer> fourRules(Integer a, Integer b) {
        HashMap<String,Integer> map;
        LocalDateTime startDate = LocalDateTime.now();
        Integer ttt = 0;
        for(int i=0; i<1000000; i++){
            ttt++;
        }
        Integer tttFinal = ttt;
        LocalDateTime endDate = LocalDateTime.now();
        System.out.println(startDate);
        System.out.println(endDate);

        try{
            map =  new HashMap<String,Integer>(){
                {
                    put("add",tttFinal);
                    put("sub",a-b);
                    put("mul",a*b);
                    put("div",a/b);
                    put("rem",a%b);
                }

            };
        }catch(ArithmeticException e){
            map =  new HashMap<String,Integer>(){
                {
                    put("add",a+b);
                    put("sub",a-b);
                    put("mul",a*b);
                    put("div",0);
                    put("rem",0);
                }

            };
        }


        return map;
    }

    @Override
    public HashMap<String, String> fibonacci(Integer num) {
        BigInteger a0 = new BigInteger("0");
        BigInteger a1 = new BigInteger("1");
        BigInteger finalA0 = a0;
        BigInteger finalA1 = a1;
        if(num == 0) return new HashMap<String,String>(){{
           put("result" , finalA0.toString());
        }};
        if(num == 1) return new HashMap<String,String>(){{
            put("result", finalA1.toString());
        }};
        for(int i=2; i<=num; i++){
            BigInteger temp = a0;
            a0 = a1;
            a1 = temp.add(a1);
        }
        BigInteger finalA = a1;
        return new HashMap<String,String>(){{
            put("result",finalA.toString());
        }};
    }

}
