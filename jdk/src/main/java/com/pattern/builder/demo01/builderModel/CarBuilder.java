package com.pattern.builder.demo01.builderModel;

import com.pattern.builder.demo01.CarModel;

import java.util.ArrayList;

public abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String> sequence);

    public abstract CarModel getCarModel();
}
