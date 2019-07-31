package com.pattern.builder.demo01;

import com.pattern.builder.demo01.BenzModel;
import com.pattern.builder.demo01.builderModel.BenzBuilder;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {


        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");
        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequence);

        BenzModel benz = (BenzModel) benzBuilder.getCarModel();
        benz.run();
    }
}
