package com.pattern.builder.demo01.builderModel;

import com.pattern.builder.demo01.BMWModel;
import com.pattern.builder.demo01.CarModel;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder{
    BMWModel bmw = new BMWModel();

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }
}
