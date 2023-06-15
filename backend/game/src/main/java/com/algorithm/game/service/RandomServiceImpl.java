package com.algorithm.game.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RandomServiceImpl implements RandomService {

    @Override
    public HashMap<String, Object> randomPick(Integer start, Integer end, Integer count, Boolean isDistinct) {
        Integer gap = end-start+1;
        int[] arr = new int[count];
        if(!isDistinct){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int)(Math.random()*gap)+start;
            }
        }else{
            // 중복 제거하는 방법엔 2가지 방법이 있는데, 빠르기가 일정한 방법을 쓰겠다.
            boolean[] isVisited = new boolean[gap];
            int temp = gap;
            for(int i=0; i<arr.length; i++){
                int value = (int)(Math.random()*temp);
                for(int j=0,r=0; j<isVisited.length; j++){
                    if(isVisited[j]) continue;
                    else{
                        if(r == value){
                            isVisited[j] = true;

                            arr[i] = j+start;
                            break;
                        }else{
                            r = r+1;
                            continue;
                        }
                    }
                }
                temp--;
            }
        }

        return new HashMap<String,Object>(){
            {
            put("data",arr);

            }
        };
    }
}
