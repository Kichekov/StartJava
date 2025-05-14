package com.startjava.lesson_2_3_4.robot;

import com.startjava.lesson_2_3.robot.Jaeger;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger chernoAlpha = new Jaeger();
        chernoAlpha.setModelName("Cherno Alpha");
        chernoAlpha.setMark("Mark-1");
        chernoAlpha.setOrigin("Russia");
        chernoAlpha.setHeight(85.34f);
        chernoAlpha.setWeight(2.412f);
        chernoAlpha.setSpeed(3);
        chernoAlpha.setStrength(10);
        chernoAlpha.setArmor(10);
        System.out.println(chernoAlpha);

        Jaeger romeoBlue = new Jaeger("Romeo Blue", "Mark-1", "USA", 77.72f, 7.775f, 2, 7, 6);
        System.out.println(romeoBlue);
    }
}
