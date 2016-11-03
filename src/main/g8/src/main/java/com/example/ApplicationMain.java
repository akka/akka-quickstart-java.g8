package com.example;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;

public class ApplicationMain {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("MyActorSystem");
        ActorRef pingActor = system.actorOf(PingActor.props(), "pingActor");
        pingActor.tell(new PingActor.Initialize(), null);
        // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
        // see counter logic in PingActor
        system.awaitTermination();
    }

}