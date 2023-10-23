package $package$;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;

import java.util.Objects;

// #greeter
public class Greeter extends AbstractBehavior<Greeter.Greet> {

  public static record Greet(String whom, ActorRef<Greeted> replyTo) {}
  public static record Greeted(String whom, ActorRef<Greet> from) {}

  public static Behavior<Greet> create() {
    return Behaviors.setup(Greeter::new);
  }

  private Greeter(ActorContext<Greet> context) {
    super(context);
  }

  @Override
  public Receive<Greet> createReceive() {
    return newReceiveBuilder().onMessage(Greet.class, this::onGreet).build();
  }

  private Behavior<Greet> onGreet(Greet command) {
    getContext().getLog().info("Hello {}!", command.whom());
    //#greeter-send-message
    command.replyTo().tell(new Greeted(command.whom(), getContext().getSelf()));
    //#greeter-send-message
    return this;
  }
}
// #greeter

