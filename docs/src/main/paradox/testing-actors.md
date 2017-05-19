Testing Actors
--------------

We will use the [JUnit](http://www.junit.org/) framework to conduct the testing of our sample. The test coverage is not complete in this example. We leave that as an exercise for the interested reader. Instead, the test code is there to showcase how how easy it is to test actor code and also to provide some basic concepts.

### Test Methods

The test uses `akka.test.TestKit` which is a module for integration testing of actors and actor systems. The showcased test class only uses a fraction of the functionality provided by [TestKit](http://doc.akka.io/docs/akka/2.5/java/testing.html).

When working with Actors everything is asynchronous and as such we need to ensure that we can test this asynchronous behavior. This is where integration testing comes in handy. In this test we will create a so-called "TestProbe" that we can interrogate to verify the expected behavior. Once we have a reference to this "TestProbe" we pass it to `Greeter` as part of the constructor arguments by using the method `testProbe.getRef()`. We thereafter send two messages to `Greeter`; one to set the greeting person to greet and another to trigger the sending of a `Greeting`. It is this sending that we then verify took place with the `expectMsg` method on the `testProbe` instance. Let's look at the source code for this:

@@snip [AkkaQuickstartTest.java]($g8srctest$/java/com/lightbend/akka/sample/AkkaQuickstartTest.java)

### Just the Surface

The above code is just scratching the surface of the available functionality in `TestKit`. A complete overview can be found [here](http://doc.akka.io/docs/akka/2.5/java/testing.html).

Now that we are done writing all the code we should of course look at the output of it. The next section is all about running the code and it also analyzes the output thereof.
