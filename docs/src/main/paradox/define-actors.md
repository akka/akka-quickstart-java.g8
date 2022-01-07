## Defining Actors and messages

Each actor defines a type `T` for the messages it can receive.
Case classes and case objects make excellent messages since they are immutable and have support for pattern matching,
something we will take advantage of in the Actor when matching on the messages it has received.

The Hello World Actors use three different messages:

* `Greet`: command sent to the `Greeter` actor to greet
* `Greeted`: reply from the `Greeter` actor to confirm the greeting has happened
* `SayHello`: command to the `GreeterMain` to start the greeting process

When defining Actors and their messages, keep these recommendations in mind:

* Since messages are the Actor's public API, _it is a good practice to define messages with good names and rich semantic and domain specific meaning_, even if they just wrap your data type. This will make it easier to use, understand and debug actor-based systems.

* _Messages should be immutable_, since they are shared between different threads.

* It is a good practice to put an actor's associated messages as static classes in the AbstractBehavior's class. This makes it easier to understand what type of messages the actor expects and handles.

* It is a good practice obtain an actor's initial behavior via a static factory method

Lets see how the implementations for `Greeter`, `GreeterBot` and `GreeterMain` demonstrate these best practices.

### The Greeter actor

The following snippet from the `Greeter.java` implements the `Greeter` Actor:

@@snip [Greeter.java]($g8src$/java/$package$/Greeter.java) { #greeter }

This small piece of code defines two message types, one for commanding the
Actor to greet someone and one that the Actor will use to confirm that it has
done so. The `Greet` type contains not only the information of whom to
greet, it also holds an `ActorRef` that the sender of the message
supplies so that the `Greeter` Actor can send back the confirmation
message.

The behavior of the Actor is defined as the `Greeter` AbstractBehavior with the help
of the `newReceiveBuilder` behavior factory. Processing the next message then results
in a new behavior that can potentially be different from this one. The state can be updated
by modifying the current instance as it is mutable. In this
case we don't need to update any state, so we return `this` without any field updates, which means
the next behavior is "the same as the current one".

The type of the messages handled by this behavior is declared to be of class
`Greet`. Typically, an actor handles more than one specific message type and then there
is one common `interface` that all messages that the
actor can handle `implements`.

On the last line we see the `Greeter` Actor send a message to another
Actor, which is done using the `tell` method.
It is an asynchronous operation that doesn't block the caller's thread.

Since the `replyTo` address is declared to be of type `ActorRef<Greeted>`, the
compiler will only permit us to send messages of this type, other usage will
be a compiler error.

The accepted message types of an Actor together with all reply types defines
the protocol spoken by this Actor; in this case it is a simple request–reply
protocol but Actors can model arbitrarily complex protocols when needed. The
protocol is bundled together with the behavior that implements it in a nicely
wrapped scope—the `Greeter` class.

### The Greeter bot actor

@@snip [GreeterBot.java]($g8src$/java/$package$/GreeterBot.java)

Note how this Actor manages the counter with an instance variable.
No concurrency guards such as `synchronized` or `AtomicInteger` are needed since an actor instance processes one
message at a time.

### The Greeter main actor

A third actor spawns the `Greeter` and the `GreeterBot` and starts the interaction, creating actors
and what `spawn` does is discussed next.

@@snip [GreeterMain.java]($g8src$/java/$package$/GreeterMain.java)
