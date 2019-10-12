package com.lightbend.akka.sample;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;

public class GreeterMain extends AbstractBehavior<GreeterMain.Start> {

    public static class Start {
        public final String name;

        public Start(String name) {
            this.name = name;
        }
    }

    private final ActorRef<Greeter.Greet> greeter;

    public static Behavior<Start> create() {
        return Behaviors.setup(GreeterMain::new);
    }

    private GreeterMain(ActorContext<Start> context) {
        super(context);
        //#create-actors
        greeter = context.spawn(Greeter.create(), "greeter");
        //#create-actors
    }

    @Override
    public Receive<Start> createReceive() {
        return newReceiveBuilder().onMessage(Start.class, this::onStart).build();
    }

    private Behavior<Start> onStart(Start command) {
        //#create-actors
        ActorRef<Greeter.Greeted> replyTo =
                getContext().spawn(GreeterBot.create(3), command.name);
        greeter.tell(new Greeter.Greet(command.name, replyTo));
        //#create-actors
        return this;
    }
}
