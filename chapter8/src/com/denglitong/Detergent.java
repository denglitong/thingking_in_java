package com.denglitong;

/**
 * @autor denglitong
 * @date 2019/7/26
 */

class Cleanser {

    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute() ");
    }

    public void apply() {
        append(" apply() ");
    }

    public void scrub() {
        append(" scrub() ");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }

}

public class Detergent extends Cleanser {

    @Override
    public void scrub() {
        // super.scrub();
        append(" Detergent.scrub() ");
    }

    public void foam() {
        append(" foam() ");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }

}