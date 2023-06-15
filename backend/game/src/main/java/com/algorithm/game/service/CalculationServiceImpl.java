package com.algorithm.game.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;

@Service
public class CalculationServiceImpl implements CalculationService{
    @Override
    public HashMap<String, Integer> fourRules(Integer a, Integer b) {
        HashMap<String,Integer> map;
        try{
            map =  new HashMap<String,Integer>(){
                {
                    put("add",a+b);
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
    public HashMap<String, BigInteger> fibonacci(Integer num) {
        BigInteger a0 = new BigInteger("0");
        BigInteger a1 = new BigInteger("1");
        BigInteger finalA0 = a0;
        BigInteger finalA1 = a1;
        if(num == 0) return new HashMap<String,BigInteger>(){{
           put("result" , finalA0);
        }};
        if(num == 1) return new HashMap<String,BigInteger>(){{
            put("result", finalA1);
        }};
        for(int i=2; i<=num; i++){
            BigInteger temp = a0;
            a0 = a1;
            a1 = temp.add(a1);
        }
        BigInteger finalA = a1;
        return new HashMap<String,BigInteger>(){{
            put("result",finalA);
        }};
    }

}
