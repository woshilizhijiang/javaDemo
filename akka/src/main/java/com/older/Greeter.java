package com.older;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {

    public static enum Msg{
        GREET,DONE;
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message == Msg.GREET){
            System.out.println("Hello, world.");
            getSender().tell(Msg.DONE, getSelf());
        }else {
            unhandled(message);
        }
    }

    public static void main(String[] args) {

    }
}
