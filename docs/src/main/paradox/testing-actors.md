## Testing Actors
 
The tests in the Hello World example illustrates use of the [JUnit](http://www.junit.org/) framework. The test coverage is not complete. It simply shows how easy it is to test actor code and provides some basic concepts. You could add to it as an exercise to increase your own knowledge.

The test class is using `akka.test.javadsl.TestKit`, which is a module for integration testing of actors and actor systems. This class only uses a fraction of the functionality provided by [TestKit](http://doc.akka.io/docs/akka/current/java/testing.html).

Integration testing can help us ensure that Actors are behaving asynchronously. This first test uses `TestKit` probe to interrogate and verify the expected behavior. Let's look at a source code snippet:

@@snip [AkkaQuickstartTest.java]($g8srctest$/java/com/lightbend/akka/sample/AkkaQuickstartTest.java)

Once we have a reference to  `TestKit` probe we pass the `ActorRef` of it to `Greeter` as part of the constructor arguments. We thereafter send two messages to `Greeter`; one to set the greeting person to greet and another to trigger the sending of a `Greeting`. The `expectMsg` method on the `TestKit` verifies whether the message got sent.

The example code just scratches the surface of the functionality available in `TestKit`. A complete overview can be found [here](http://doc.akka.io/docs/akka/current/java/testing.html).
 
Now that we've reviewed all of the code. Let's run the example again and look at its output.
