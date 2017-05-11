Define the Actors
-----------------

The Actor is the unit of execution in Akka. Actors are object-oriented in the sense that they encapsulate state and behavior, but they have much stronger isolation than regular objects in Java.

The Actor model prevents sharing state between Actors and the only way to observe another actor's state is by sending it a message asking for it. Actors are extremely lightweight, they are only constrained by the memory of which they consume only a few hundred bytes each &#8212; this means you can easily create millions of concurrent Actors in a single application. Their strong isolation principles together with the event-driven model (that we will talk about later on) and location transparency makes it easy to solve hard concurrency and scalability problems in an intuitive way.

In this example application, we will define two actors: `Greeter` and `Printer`.

### The Greeter Actor

The `Greeter` Actor handles the creation of greeting messages and communicates with the `Printer` actor when instructed to. Let's take a look at its implementation to get a better understanding of what it looks like.

A good practice is to define the messages as part of the Actor implementation. he Another recommended practice is to create a `props` method in the Actor. Think of a `props` method as the factory method for how to create instances of this Actor. The `props` method creates and returns a `Props` instance. `Props` is a configuration class to specify options for the creation of actors, think of it as an immutable and thus freely shareable recipe for creating an actor including associated deployment information. In this example, we just pass on the parameters that the Actor requires when being constructed. We will see the `props` method in action later in this tutorial.

Let us take a look at the full implementation:  

@@snip [Greeter.java]($g8src$/java/com/lightbend/akka/sample/Greeter.java)

We create an Actor by defining a class that extends `akka.actor.AbstractActor` and implements the `createReceive` method. It is in the `onReceive` method that we define the behavior; how the Actor should react to the different messages it receives. An Actor can have state and accessing or mutating the internal state of an Actor is fully thread safe since it is protected by the Actor model. The `Greeter` Actor implementation keeps a state in its variable `greeting` which by default is set to `""`.

Actors can, like every other class, have constructors that define parameters. The constructor of `Greeter` accepts two parameters: `String message` which will be used when building greeting messages and `ActorRef printerActor` which is a reference to the Actor handling the outputting of the greeting.

The `createReceive` method should handle the messages the actor expects. In the case of `Greeter`, it expects two types of messages: `WhoToGreet` and `Greet`. The former will update the `greeting` state of the Actor and the latter will trigger a sending of the `greeting` to the `Printer` Actor. We use the `receiveBuilder` and its convenience methods to create a `Receive` block that is being used by Akka. More information about the functionality of `receiveBuilder` can be found [here](http://doc.akka.io/docs/akka/2.5/java/actors.html#Receive_messages).

### The Printer Actor

Instead of rehashing all the explanations in the sections above we will just look at the source code of the `Printer` Actor.

The `Printer` implementation is very simple. It just handles one type of message, `Greeting`, and logs the content of that message. One thing to highlight is that we import a reference to a logger via `Logging.getLogger(getContext().getSystem(), this);`. By doing this we can write `log.info()` in the `createReceive` method without any additional wiring.

@@snip [Printer.java]($g8src$/java/com/lightbend/akka/sample/Printer.java)
