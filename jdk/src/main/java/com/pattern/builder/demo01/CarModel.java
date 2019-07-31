package com.pattern.builder.demo01;

import java.util.ArrayList;

public abstract class CarModel {

    private ArrayList<String> sequence = new ArrayList<String>();

    protected  abstract  void  start();
    protected  abstract  void  stop();
    protected  abstract  void  alarm();
    protected  abstract  void  engineBoom();

    public  void  run(){
        for (int i = 0; i < this.sequence.size(); i++){
            String actionName = this.sequence.get(i);
            if (actionName.equalsIgnoreCase("start")){
                this.start();
            }
            if (actionName.equalsIgnoreCase("stop")){
                this.stop();
            }
            if (actionName.equalsIgnoreCase("alarm")){
                this.alarm();
            }
            if (actionName.equalsIgnoreCase("engine boom")){
                this.engineBoom();
            }
        }
    };

    public void setSequence(ArrayList<String> sequence){
        this.sequence = sequence;
    }

}
