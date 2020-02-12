## Testing Actors
 
The tests in the Hello World example illustrates use of the [JUnit](http://www.junit.org/) framework. The test coverage is not complete. 
It shows how to test actor code and provides some basic concepts. 

@@snip [AkkaQuickstartTest.java]($g8srctest$/java/$package$/AkkaQuickstartTest.java)

### Test class definition

@@snip [AkkaQuickstartTest.java]($g8srctest$/java/$package$/AkkaQuickstartTest.java) { #definition }

Support for JUnit is included by using the `TestKitJunitResource` JUnit rule. This automatically creates and cleans
up an `ActorTestKit`. To see how to use the testkit directly see the [full documentation](https://doc.akka.io/docs/akka/2.6/typed/testing-async.html).

### Test methods

This test uses TestProbe to interrogate and verify the expected behavior. Let’s look at a source code snippet:

@@snip [AkkaQuickstartTest.java]($g8srctest$/java/$package$/AkkaQuickstartTest.java) { #test }

Once we have a reference to TestProbe we pass it to Greeter as part of the `Greet` message. 
We then verify that the `Greeter` responds that the greeting has taken place.

### Full test code

And, here is the complete code:

@@snip [AkkaQuickstartTest.java]($g8srctest$/java/$package$/AkkaQuickstartTest.java)

The example code just scratches the surface of the functionality available in `ActorTestKit`. A complete overview can be found [here](http://doc.akka.io/docs/akka/2.6/java/testing.html).
 
