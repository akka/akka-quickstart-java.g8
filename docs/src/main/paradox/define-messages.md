
Define the Messages
-------------------

An Actor does not have a public API in terms of methods that you can invoke. Instead its public
API is defined through messages that the actor handles. Messages can be of arbitrary type (any subtype of `Object`).  
This means that we can send boxed primitive values (such as `String`, `Integer`, `Boolean` etc.) as messages as well as plain data structures like arrays and collection types.

However, since the messages are the Actor's public API, you should define messages with good names and rich semantic and domain specific meaning, even if it's just wrapping your data type. This will make it easier to use, understand and debug actor-based systems.

_A pattern that we apply when building actor based systems is that we try to put the associated message into the companion object of the actor_. This way it is easier to understand what messages the actor expects and handles.

In this example we will define three different messages:

- `WhoToGreet`: who the actor should greet
- `Greet`: instruction to execute greeting
- `Greeting`: message containing the greeting

Messages handled by the `Greeter` Actor:

@@snip [Greeter.java]($g8src$/java/com/lightbend/akka/sample/Greeter.java) { #greeter-messages }

Message handled by the `Printer` Actor:

@@snip [Printer.java]($g8src$/java/com/lightbend/akka/sample/Printer.java) { #printer-messages }
