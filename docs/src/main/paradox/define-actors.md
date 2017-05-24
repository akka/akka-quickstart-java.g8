## Defining Actors and messages      

Messages can be of arbitrary type (any subtype of `Object`). You can send boxed primitive values (such as `String`, `Integer`, `Boolean` etc.) as messages as well as plain data structures like arrays and collection types. 

Hello World Actors use three different messages:

* `WhoToGreet`: recipient of the greeting
* `Greet`: instruction to execute greeting
* `Greeting`: message containing the greeting

When defining Actors and their messages, keep these recommendations in mind:

* Since messages are the Actor's public API, _it is a good practice to define messages with good names and rich semantic and domain specific meaning_, even if they just wrap your data type. This will make it easier to use, understand and debug actor-based systems.

* _Messages should be immutable_, since they are shared between different threads. 

* _It is a good practice to put an actor's associated messages as static classes in the class of the Actor_. This makes it easier to understand what type of messages the actor expects and handles. 

* _It is also a common pattern to use a static `props` method in the class of the Actor that describes how to construct the Actor._ 

Lets see how the Actor implementations for `Greeter` and `Printer` demonstrate these best practices. 

### The Greeter Actor

The following snippet from the `Greeter.java` implements the `Greeter` Actor:

@@snip [Greeter.java]($g8src$/java/com/lightbend/akka/sample/Greeter.java)

Let's break down the functionality:

* The `Greeter` class extends the `akka.actor.AbstractActor` class and implements the `createReceive` method. 
* The `Greeter` constructor accepts two parameters: `String message`, which will be used when building greeting messages and `ActorRef printerActor`, which is a reference to the Actor handling the outputting of the greeting.
* The `receiveBuilder` defines the behavior; how the Actor should react to the different messages it receives. An Actor can have state. Accessing or mutating the internal state of an Actor is fully thread safe since it is protected by the Actor model. The `createReceive` method should handle the messages the actor expects. In the case of `Greeter`, it expects two types of messages: `WhoToGreet` and `Greet`. The former will update the `greeting` state of the Actor and the latter will trigger a sending of the `greeting` to the `Printer` Actor.
* The `greeting` variable contains the Actor's state and is set to `""` by default.
* The static `props` method creates and returns a `Props` instance. `Props` is a configuration class to specify options for the creation of actors, think of it as an immutable and thus freely shareable recipe for creating an actor that can include associated deployment information. This example simply passes the parameters that the Actor requires when being constructed. We will see the `props` method in action later in this tutorial.
 
### Printer Actor
 
The `Printer` implementation is very simple:

* It creates a logger via `Logging.getLogger(getContext().getSystem(), this);`. By doing this we can write `log.info()` in the Actor without any additional wiring.
* It just handles one type of message, `Greeting`, and logs the content of that message.  
 
@@snip [Printer.java]($g8src$/java/com/lightbend/akka/sample/Printer.java)
