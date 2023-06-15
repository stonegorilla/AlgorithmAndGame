package com.algorithm.game.service;

import java.util.HashMap;

public interface RandomService {
    HashMap<String,Object> randomPick(Integer start, Integer end, Integer count, Boolean isDistinct);
}
