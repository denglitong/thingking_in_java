package com.denglitong.innerclasses;

/**
 * @autor denglitong
 * @date 2019/8/4
 */
public class Parcel2 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String whereTo) {
            this.label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        // defining references to
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
        System.out.println(c.value());
        System.out.println(d.readLabel());
    }
}