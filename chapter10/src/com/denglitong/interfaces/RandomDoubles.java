package com.denglitong.interfaces;

import java.util.Random;

/**
 * @autor denglitong
 * @date 2019/8/3
 */
public interface RandomDoubles {
    Random RAND = new Random(47);

    default double next() {
        return RAND.nextDouble();
    }

    static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles() {};
        for (int i = 0; i < 7; i++) {
            System.out.println(rd.next() + " ");
        }
    }
}
