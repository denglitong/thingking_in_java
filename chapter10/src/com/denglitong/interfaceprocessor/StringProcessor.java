package com.denglitong.interfaceprocessor;

import java.util.Arrays;

/**
 * @autor denglitong
 * @date 2019/7/31
 */
public interface StringProcessor extends Processor {

    @Override
    String process(Object input);

    String S = "If she weighs the same as a duck, she's made of wood";

    static void main(String[] args) {
        Applicator.apply(new Upcase(), S);
        Applicator.apply(new Downcase(), S);
        Applicator.apply(new Splitter(), S);
    }

}

class Upcase implements StringProcessor {

    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }

}

class Downcase implements StringProcessor {

    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }

}

class Splitter implements StringProcessor {

    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }

}
