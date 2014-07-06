package controllers;

import akka.actor.*;

public class EchoActor extends UntypedActor {

    public static Props props(ActorRef out) {
        return Props.create(EchoActor.class, out);
    }

    private final ActorRef out;

    public EchoActor(ActorRef out) {
        this.out = out;
    }

    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            out.tell("I received your message: " + message, self());
        }
    }
}